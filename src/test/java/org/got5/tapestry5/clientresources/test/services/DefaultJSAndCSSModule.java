package org.got5.tapestry5.clientresources.test.services;

import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.got5.tapestry5.clientresources.services.AssetPathStack;


@SubModule(BaseModule.class)
public class DefaultJSAndCSSModule
{
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
    }
}
