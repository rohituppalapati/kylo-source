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


/**
 * Validates credit card number matches pattern
 */
/*
^(?:4[0-9]{12}(?:[0-9]{3})?          # Visa
        |  5[1-5][0-9]{14}                  # MasterCard
        |  3[47][0-9]{13}                   # American Express
        |  3(?:0[0-5]|[68][0-9])[0-9]{11}   # Diners Club
        |  6(?:011|5[0-9]{2})[0-9]{12}      # Discover
        |  (?:2131|1800|35\d{3})\d{11}      # JCB
        )$
http://www.regular-expressions.info/creditcard.html
*/
@Validator(name = "Credit card", description = "Valid credit card")
public class CreditCardValidator extends RegexValidator implements ValidationPolicy<String> {

    private static final CreditCardValidator instance = new CreditCardValidator();

    private CreditCardValidator() {
        super(
            "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}||6(?:011|5[0-9]{2})[0-9]{12}|(?:2131|1800|35\\d{3})\\d{11})$");
    }

    public static CreditCardValidator instance() {
        return instance;
    }

}




