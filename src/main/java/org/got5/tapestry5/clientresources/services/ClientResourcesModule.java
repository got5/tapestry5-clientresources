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

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.ClientInfrastructure;
import org.apache.tapestry5.services.Environment;
import org.apache.tapestry5.services.MarkupRenderer;
import org.apache.tapestry5.services.MarkupRendererFilter;
import org.apache.tapestry5.services.PartialMarkupRenderer;
import org.apache.tapestry5.services.PartialMarkupRendererFilter;
import org.got5.tapestry5.clientresources.ClientResourcesConstants;


public class ClientResourcesModule
{
    private final Environment environment;

    public ClientResourcesModule(Environment environment)
    {
        this.environment = environment;
    }

    public static void bind(ServiceBinder binder)
    {
        binder.bind(ClientInfrastructure.class, ContribuableClientInfrastructure.class).withId("ContribuableClientInfrastructure");
    }

    @SuppressWarnings("unchecked")
    public static void contributeServiceOverride(MappedConfiguration<Class, Object> configuration, @Local ClientInfrastructure override)
    {
        configuration.add(ClientInfrastructure.class, override);
    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration)
    {
        // default css and js resources are loaded
        configuration.add(ClientResourcesConstants.CSS_STACK, ClientResourcesConstants.CSS_STACK_DEFAULT);
        configuration.add(ClientResourcesConstants.JAVASCRIPT_STACK, ClientResourcesConstants.JAVASCRIPT_STACK_DEFAULT);

        configuration.add(ClientResourcesConstants.DISABLED_FORM_AUTOFOCUS, "false");
    }

    /**
     * The definition of the global CSS and JS stack is now defined in this way,
     * thanks to a more open ClientInfrastructure
     */
    public void contributeContribuableClientInfrastructure(MappedConfiguration<String, AssetPathStack> configuration)
    {

        configuration.add(ClientResourcesConstants.CSS_STACK_DEFAULT, new AssetPathStack("${tapestry.default-stylesheet}",
                "${tapestry.blackbird}/blackbird.css"));
        configuration.add(ClientResourcesConstants.CSS_STACK_DEFAULT_WITHOUT_BLACKBIRD, new AssetPathStack("${tapestry.default-stylesheet}"));
        configuration.add(ClientResourcesConstants.CSS_STACK_NONE, new AssetPathStack());
        configuration.add(ClientResourcesConstants.JAVASCRIPT_STACK_DEFAULT, new AssetPathStack("${tapestry.scriptaculous}/prototype.js",
                "${tapestry.scriptaculous}/scriptaculous.js", "${tapestry.scriptaculous}/effects.js", "org/apache/tapestry5/tapestry.js",
                "${tapestry.blackbird}/blackbird.js"));
        configuration.add(ClientResourcesConstants.JAVASCRIPT_STACK_NONE, new AssetPathStack());
    }

    /**
     * Provides decoration to Rendersupport
     * 
     * @param configuration
     * @param overrideHelper
     * @param autofocusDisabled
     */
    public void contributeMarkupRenderer(OrderedConfiguration<MarkupRendererFilter> configuration,
            final @Symbol(ClientResourcesConstants.DISABLED_FORM_AUTOFOCUS) boolean autofocusDisabled)
    {
        MarkupRendererFilter renderSupportInterceptor = new MarkupRendererFilter()
        {
            public void renderMarkup(MarkupWriter writer, MarkupRenderer renderer)
            {
                // to decorate a MarkupRendererFilter, you just have to pop it just after it was
                // created, then push a wrapped version of it
                RenderSupport delegate = (RenderSupport) environment.pop(RenderSupport.class);
                RenderSupport interceptor = new RenderSupportInterceptor(delegate, autofocusDisabled);

                environment.push(RenderSupport.class, interceptor);
                renderer.renderMarkup(writer);
            }
        };
        configuration.add("RenderSupportDecorator", renderSupportInterceptor, "after:RenderSupport", "before:ClientBehaviorSupport",
                "before:InjectDefaultStyleheet", "before:Heartbeat");
    }
    
    
    public void contributePartialMarkupRenderer(OrderedConfiguration<PartialMarkupRendererFilter> configuration,
            final @Symbol(ClientResourcesConstants.DISABLED_FORM_AUTOFOCUS) boolean autofocusDisabled)
    {
        PartialMarkupRendererFilter renderSupportInterceptor = new PartialMarkupRendererFilter()
        {
            public void renderMarkup(MarkupWriter writer, JSONObject reply, PartialMarkupRenderer renderer)
            {
                // to decorate a MarkupRendererFilter, you just have to pop it just after it was
                // created, then push a wrapped version of it
                RenderSupport delegate = (RenderSupport) environment.pop(RenderSupport.class);
                RenderSupport interceptor = new RenderSupportInterceptor(delegate, autofocusDisabled);

                environment.push(RenderSupport.class, interceptor);
                renderer.renderMarkup(writer, reply);
                
            }
        };
        configuration.add("RenderSupportDecorator", renderSupportInterceptor, "after:RenderSupport", "before:ClientBehaviorSupport",
                "before:InjectDefaultStyleheet", "before:Heartbeat");
    }

}
