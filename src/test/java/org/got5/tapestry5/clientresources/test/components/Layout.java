package org.got5.tapestry5.clientresources.test.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

@IncludeStylesheet("context:static/style.css")
public class Layout
{
    @Property
    private String title;

    @Inject
    private ComponentResources resources;

    @SetupRender
    void init()
    {
	this.title = resources.getPageName();
    }
}
