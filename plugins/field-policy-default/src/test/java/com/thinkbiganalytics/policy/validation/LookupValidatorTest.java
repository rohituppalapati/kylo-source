package com.thinkbiganalytics.policy.validation;

/*-
 * #%L
 * thinkbig-field-policy-default
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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * test the {@link LookupValidator}
 */
public class LookupValidatorTest {

    @Test
    public void testValidate() throws Exception {
        LookupValidator validator = new LookupValidator("true", "false");
        assertTrue(validator.validate("true"));
        assertTrue(validator.validate("false"));
        assertFalse(validator.validate("FALSE"));
        assertFalse(validator.validate("none"));
        assertFalse(validator.validate(""));
    }
}
