//
// Copyright 2010 GOT5 (Gang Of Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.clientresources;

public interface ClientResourcesConstants
{
    /**
     * Allows you to select your preferred javascript framework. Tapestry will
     * try and use the selector, DOM-manipulation, animation and/or
     * event-handling from the selected Javascript framework so it will blend in
     * better with your custom components. Currently supported options:
     * <ul>
     * <li>js-none - no javascript inclusion</li>
     * <li>js-prototype - Uses the default Prototype library</li>
     * </ul>
     */
    public static final String JAVASCRIPT_STACK = "tapestry.javascript-stack";

    public static final String JAVASCRIPT_STACK_DEFAULT = "js-prototype";

    public static final String JAVASCRIPT_STACK_NONE = "js-none";

    /**
     * Default CSS used on each Tapestry page Currently supported options:
     * <ul>
     * <li>css-none : no css inclusion</li>
     * <li>css-default : default cssinclusion</li>
     * </ul>
     */
    public static final String CSS_STACK = "tapestry.css-stack";

    public static final String CSS_STACK_DEFAULT = "css-default";

    public static final String CSS_STACK_DEFAULT_WITHOUT_BLACKBIRD = "css-default-without-blackbird";

    public static final String CSS_STACK_NONE = "css-none";

    public static final String DISABLED_FORM_AUTOFOCUS = "tapestry.disabled-autofocus";
}
