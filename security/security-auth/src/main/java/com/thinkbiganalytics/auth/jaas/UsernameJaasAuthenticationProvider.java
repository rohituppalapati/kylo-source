/**
 *
 */
package com.thinkbiganalytics.auth.jaas;

/*-
 * #%L
 * kylo-security-auth
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.thinkbiganalytics.auth.UsernameAuthenticationToken;

import org.springframework.security.authentication.jaas.DefaultJaasAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * A type of {@link DefaultJaasAuthenticationProvider} that only accepts a UsernameAuthenticationToken.
 */
public class UsernameJaasAuthenticationProvider extends DefaultKyloJaasAuthenticationProvider {

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return UsernameAuthenticationToken.class.isAssignableFrom(aClass);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        return super.authenticate(((UsernameAuthenticationToken) auth).getWrappedToken());
    }
}
