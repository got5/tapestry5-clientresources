package org.got5.tapestry5.clientresources.test.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.got5.tapestry5.clientresources.ClientResourcesConstants;


@SubModule(BaseModule.class)
public class NoJSAndNoCSSModule
{
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
        configuration.add(ClientResourcesConstants.JAVASCRIPT_STACK, ClientResourcesConstants.JAVASCRIPT_STACK_NONE);
        configuration.add(ClientResourcesConstants.CSS_STACK, ClientResourcesConstants.CSS_STACK_NONE);
        configuration.add(ClientResourcesConstants.DISABLED_FORM_AUTOFOCUS, "true");
    }
}
