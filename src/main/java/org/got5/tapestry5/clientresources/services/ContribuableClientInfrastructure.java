//
// Copyright 2010 GOT5 (Gang Of Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.clientresources.services;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.ioc.services.SymbolSource;
import org.apache.tapestry5.ioc.services.ThreadLocale;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.ClientInfrastructure;
import org.got5.tapestry5.clientresources.ClientResourcesConstants;


public class ContribuableClientInfrastructure implements ClientInfrastructure
{
    private final List<Asset> javascriptStack, stylesheetStack;

    private final SymbolSource symbolSource;

    private final AssetSource assetSource;

    private final ThreadLocale threadLocale;

    public ContribuableClientInfrastructure(Map<String, AssetPathStack> assetsStackMap,
            @Symbol(ClientResourcesConstants.JAVASCRIPT_STACK)
            @Inject
            String javascriptStackId, @Symbol(ClientResourcesConstants.CSS_STACK)
            @Inject
            String stylesheetStackId, @Inject
            AssetSource assetSource, @Inject
            ThreadLocale threadLocale, @Inject
            SymbolSource symbolSource)
    {
        this.symbolSource = symbolSource;
        this.assetSource = assetSource;
        this.threadLocale = threadLocale;

        AssetPathStack javascriptPathStack = assetsStackMap.get(javascriptStackId);
        AssetPathStack stylesheetPathStack = assetsStackMap.get(stylesheetStackId);

        this.javascriptStack = convertToAssets(javascriptPathStack.getStack());
        this.stylesheetStack = convertToAssets(stylesheetPathStack.getStack());
    }

    public List<Asset> getJavascriptStack()
    {
        List<Asset> result = CollectionFactory.newList(javascriptStack);

        if (result.size() != 0)
        {
            Asset messages = assetSource.getAsset(null,
                    "org/apache/tapestry5/tapestry-messages.js", threadLocale.getLocale());

            result.add(messages);
        }

        return result;
    }

    public List<Asset> getStylesheetStack()
    {
        return stylesheetStack;
    }

    private final List<Asset> convertToAssets(String[] paths)
    {
        List<Asset> assets = CollectionFactory.newList();

        if (paths != null)
        {
            for (String path : paths)
            {
                assets.add(expand(path, this.threadLocale.getLocale()));
            }
        }

        return Collections.unmodifiableList(assets);
    }

    private final Asset expand(String path, Locale locale)
    {
        String expanded = symbolSource.expandSymbols(path);

        return assetSource.getAsset(null, expanded, locale);
    }
}
