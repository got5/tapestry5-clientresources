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

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.FieldFocusPriority;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.AssetSource;

public class RenderSupportInterceptor implements RenderSupport
{
    private final RenderSupport delegate;

    private final boolean autofocusEnabled;

    public RenderSupportInterceptor(RenderSupport delegate, boolean autofocusDisabled)
    {
        this.delegate = delegate;
        this.autofocusEnabled = !autofocusDisabled;
    }

    public void addClasspathScriptLink(String... classpaths)
    {
        delegate.addClasspathScriptLink(classpaths);
    }

    public void addInit(String functionName, JSONArray parameterList)
    {
        delegate.addInit(functionName, parameterList);
    }

    public void addInit(String functionName, JSONObject parameter)
    {
        delegate.addInit(functionName, parameter);
    }

    public void addInit(String functionName, String... parameters)
    {
        delegate.addInit(functionName, parameters);
    }

    public void addScript(String format, Object... arguments)
    {
        delegate.addScript(format, arguments);
    }

    public void addScriptLink(Asset... scriptAssets)
    {
        delegate.addScriptLink(scriptAssets);
    }

    public void addScriptLink(String... scriptURLs)
    {
        delegate.addScriptLink(scriptURLs);
    }

    public void addStylesheetLink(Asset stylesheet, String media)
    {
        delegate.addStylesheetLink(stylesheet, media);
    }

    public String allocateClientId(String id)
    {
        return delegate.allocateClientId(id);
    }

    public String allocateClientId(ComponentResources resources)
    {
        return delegate.allocateClientId(resources);
    }

    public void autofocus(FieldFocusPriority priority, String fieldId)
    {
        if (autofocusEnabled)
            delegate.autofocus(priority, fieldId);
    }

    public void addScript(String script)
    {
        delegate.addScript(script);
    }

    public void addStylesheetLink(String stylesheetURL, String media)
    {
        delegate.addStylesheetLink(stylesheetURL, media);
    }

}
