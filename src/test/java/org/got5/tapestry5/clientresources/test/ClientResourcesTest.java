package org.got5.tapestry5.clientresources.test;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.test.PageTester;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientResourcesTest extends Assert
{
    public final static String APP_PACKAGE = "org.got5.tapestry5.clientresources.test";

    @Test
    public void testDefaultJSAndCSS()
    {
        String appName = "DefaultJSAndCSS";

        PageTester tester = new PageTester(APP_PACKAGE, appName, "src/test/webapp");
        Document doc = tester.renderPage("Index");

        String raw = doc.getRootElement().toString();
        assertContains(raw, "prototype.js");
        assertContains(raw, "scriptaculous.js");
        assertContains(raw, "default.css");
    }

    @Test
    public void testDefaultJSAndNoCSS()
    {
        String appName = "DefaultJSAndNoCSS";

        PageTester tester = new PageTester(APP_PACKAGE, appName, "src/test/webapp");
        Document doc = tester.renderPage("Index");

        String raw = doc.getRootElement().toString();

        assertContains(raw, "prototype.js");
        assertContains(raw, "scriptaculous.js");
        assertNotContains(raw, "default.css");
    }

    @Test
    public void testNoJSAndDefaultCSS()
    {
        String appName = "NoJSAndDefaultCSS";
        // services.
        PageTester tester = new PageTester(APP_PACKAGE, appName, "src/test/webapp");
        Document doc = tester.renderPage("Index");

        String raw = doc.getRootElement().toString();

        assertNotContains(raw, "prototype.js");
        assertNotContains(raw, "scriptaculous.js");
        assertContains(raw, "default.css");
    }

    @Test
    public void testNoJSAndNoCSS()
    {
        String appName = "NoJSAndNoCSS";

        PageTester tester = new PageTester(APP_PACKAGE, appName, "src/test/webapp");
        Document doc = tester.renderPage("Index");

        String raw = doc.getRootElement().toString();
        assertNotContains(raw, "prototype.js");
        assertNotContains(raw, "scriptaculous.js");
        assertNotContains(raw, "default.css");
    }

    @Test
    public void testAutofocusRemover()
    {
        String appName = "NoJSAndDefaultCSS";

        PageTester tester = new PageTester(APP_PACKAGE, appName, "src/test/webapp");
        Document doc = tester.renderPage("Validation");

        String raw = doc.getRootElement().toString();

        assertNotContains(raw, ".activate()");
    }

    public final static void assertContains(String src, String value)
    {
        assertTrue(src.contains(value));
    }

    public final static void assertNotContains(String src, String value)
    {
        assertFalse(src.contains(value));
    }
}
