package com.thinkbiganalytics.feedmgr.service;

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

import java.util.HashMap;
import java.util.Map;

/**
 * Service for access to ui functions
 */
public class UIService {

    /**
     * common CodeMirror types supported by the user interface
     **/
    private Map<String, String> supportedCodeMirrorTypes = new HashMap<>();

    private UIService() {
        registerCodeMirrorType("text/x-pig", "Pig");
        registerCodeMirrorType("text/x-sql", "Sql");
        registerCodeMirrorType("text/x-mysql", "MySql");
        registerCodeMirrorType("text/x-hive", "Hive");
        registerCodeMirrorType("shell", "Shell");
        registerCodeMirrorType("text/x-cython", "Python");
        registerCodeMirrorType("xml", "Xml");
        registerCodeMirrorType("text/x-groovy", "Groovy");
        registerCodeMirrorType("text/x-properties", "Properties");

    }

    public static UIService getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Map<String, String> getCodeMirrorTypes() {
        return supportedCodeMirrorTypes;
    }

    private void registerCodeMirrorType(String type, String name) {
        supportedCodeMirrorTypes.put(type, name);
    }

    private static class LazyHolder {

        static final UIService INSTANCE = new UIService();
    }

}
