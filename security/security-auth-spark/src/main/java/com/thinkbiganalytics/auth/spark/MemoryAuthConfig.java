package com.thinkbiganalytics.auth.spark;

/*-
 * #%L
 * kylo-security-auth-spark
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

import com.thinkbiganalytics.auth.jaas.LoginConfiguration;
import com.thinkbiganalytics.auth.jaas.LoginConfigurationBuilder;
import com.thinkbiganalytics.auth.jaas.config.JaasAuthConfig;

import org.jboss.security.auth.spi.MemoryUsersRolesLoginModule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

import javax.annotation.Nonnull;

/**
 * Configures a memory-based login module.
 */
@Configuration
@Profile("auth-spark")
public class MemoryAuthConfig {

    @Value("${security.auth.spark.login.flag:sufficient}")
    private String loginFlag;
    
    @Value("${security.auth.spark.login.order:#{T(com.thinkbiganalytics.auth.jaas.LoginConfiguration).LOWEST_ORDER + 10}}")
    private int loginOrder;

    @Bean(name = "sparkLoginRoles")
    public Properties getRoles() {
        return new Properties();
    }

    @Bean(name = "sparkLoginUsers")
    public Properties getUsers() {
        return new Properties();
    }

    @Bean(name = "servicesSparkLoginConfiguration")
    public LoginConfiguration servicesFileLoginConfiguration(@Nonnull final LoginConfigurationBuilder builder, 
                                                             @Qualifier("sparkLoginUsers") final Properties users,
                                                             @Qualifier("sparkLoginRoles") final Properties roles) {
        // @formatter:off
        return builder
                .order(this.loginOrder)
                .loginModule(JaasAuthConfig.JAAS_SERVICES)
                    .moduleClass(MemoryUsersRolesLoginModule.class)
                    .controlFlag(this.loginFlag)
                    .option("users", users)
                    .option("roles", roles)
                    .add()
                .build();
        // @formatter:on
    }
}
