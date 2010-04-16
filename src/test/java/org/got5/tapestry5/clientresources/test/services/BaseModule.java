package org.got5.tapestry5.clientresources.test.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.got5.tapestry5.clientresources.services.ClientResourcesModule;


@SubModule(ClientResourcesModule.class)
public class BaseModule
{
    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
	configuration.add(SymbolConstants.GZIP_COMPRESSION_ENABLED, "false");
	configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
	configuration.add(SymbolConstants.COMPRESS_WHITESPACE, "false");
	configuration.add(SymbolConstants.COMBINE_SCRIPTS, "false");
    }
}
