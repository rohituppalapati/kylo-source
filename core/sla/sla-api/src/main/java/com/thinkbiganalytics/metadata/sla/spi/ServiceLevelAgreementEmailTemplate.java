package com.thinkbiganalytics.metadata.sla.spi;
/*-
 * #%L
 * thinkbig-feed-manager-controller
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceLevelAgreementEmailTemplate {
    public static final String EMAIL_TEMPLATE_TYPE ="SLA_EMAIL_TEMPLATE";

    private String id;
    private String systemName;
    private String name;
    private String subject;
    private String template;
    private boolean enabled;
    private boolean isDefault;


    public ServiceLevelAgreementEmailTemplate() {

    }

    public ServiceLevelAgreementEmailTemplate(String id, String name, String systemName,String subject, String template) {
       this(id,name,systemName,subject,template,true,false);
    }


    public ServiceLevelAgreementEmailTemplate(String id, String name, String systemName, String subject, String template, boolean enabled, boolean isDefault) {
        this.id = id;
        this.name = name;
        this.systemName = systemName;
        this.subject = subject;
        this.template = template;
        this.enabled = enabled;
        this.isDefault = isDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
