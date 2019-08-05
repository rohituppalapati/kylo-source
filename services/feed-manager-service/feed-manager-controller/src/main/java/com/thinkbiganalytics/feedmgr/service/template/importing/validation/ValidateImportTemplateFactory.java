package com.thinkbiganalytics.feedmgr.service.template.importing.validation;
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
import com.thinkbiganalytics.feedmgr.rest.model.ImportTemplateOptions;
import com.thinkbiganalytics.feedmgr.service.template.importing.model.ImportTemplate;

/**
 * Functional interface for new ImportTemplateValidation ImportTemplate = (String filename, byte[] content, ImportTemplateOptions options)
 */
@FunctionalInterface
public interface ValidateImportTemplateFactory<I extends ImportTemplate,O extends ImportTemplateOptions, T extends ImportTemplate.TYPE, V extends AbstractValidateImportTemplate> {
    public V apply(I importTemplate, O importTemplateOptions, T importType);
}
