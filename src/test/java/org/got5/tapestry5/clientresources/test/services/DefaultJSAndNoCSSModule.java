package org.got5.tapestry5.clientresources.test.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.got5.tapestry5.clientresources.ClientResourcesConstants;


@SubModule(BaseModule.class)
public class DefaultJSAndNoCSSModule
{
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
        configuration.add(ClientResourcesConstants.CSS_STACK, ClientResourcesConstants.CSS_STACK_NONE);
    }
}
