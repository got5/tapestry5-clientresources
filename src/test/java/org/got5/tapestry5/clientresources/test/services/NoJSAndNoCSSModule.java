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
