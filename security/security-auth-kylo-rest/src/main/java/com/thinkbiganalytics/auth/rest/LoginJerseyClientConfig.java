package com.thinkbiganalytics.auth.rest;

/*-
 * #%L
 * REST API Authentication
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

import com.thinkbiganalytics.rest.JerseyClientConfig;

import javax.annotation.Nonnull;

/**
 * Configuration for a Login REST client.
 */
public class LoginJerseyClientConfig extends JerseyClientConfig {

    /**
     * Base URL path
     */
    private String path;
    
    /**
     * The user that is being authenticated; which may be different than user/password
     * used to make the REST call.
     */
    private String authenticatingUser;

    /**
     * Default constructor, does nothing
     */
    LoginJerseyClientConfig() {
    }

    /**
     * Constructs a {@code LoginJerseyClientConfig} by copying another.
     *
     * @param other the configuration to copy
     */
    LoginJerseyClientConfig(@Nonnull final LoginJerseyClientConfig other) {
        setHttps(other.isHttps());
        setHost(other.getHost());
        setPort(other.getPort());
        setPath(other.path);
        setKeystorePath(other.getKeystorePath());
        setKeystorePassword(other.getKeystorePassword());
        setKeystoreType(other.getKeystoreType());
        setKeystoreOnClasspath(other.isKeystoreOnClasspath());
    }

    /**
     * Sets base path
     */
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getUrl() {
        final String url = super.getUrl();
        return path != null ? url + path : url;
    }
    
    /**
     * @return the user being authenticated (as opposed to the REST login credentials)
     */
    public String getAuthenticatingUser() {
        return authenticatingUser;
    }
    
    /**
     * @param authenticatingUser the user being authenticated (as opposed to the REST login credentials)
     */
    public void setAuthenticatingUser(String authenticatingUser) {
        this.authenticatingUser = authenticatingUser;
    }
    
    /**
     * @return true if the REST login credentials are different from the user being authenticated
     */
    public boolean isAlternateUser() {
        return getUsername() != null && this.authenticatingUser != null && getUsername().equals(this.authenticatingUser);
    }
}
