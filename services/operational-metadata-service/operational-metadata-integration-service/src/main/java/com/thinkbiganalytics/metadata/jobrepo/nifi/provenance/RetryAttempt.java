package com.thinkbiganalytics.metadata.jobrepo.nifi.provenance;
/*-
 * #%L
 * thinkbig-operational-metadata-integration-service
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
import org.joda.time.DateTime;

/**
 * Created by sr186054 on 11/3/17.
 */
public class RetryAttempt {

    private Integer retryAttempt;
    private DateTime lastRetryTime;
    private Integer maxRetries = 5;

    public RetryAttempt(Integer maxRetries) {
        if (this.lastRetryTime == null) {
            this.lastRetryTime = DateTime.now();
        }
        if (retryAttempt == null) {
            retryAttempt = 1;
        }
        this.maxRetries = maxRetries;
    }

    public boolean shouldRetry() {
        return !maxRetriesReached();
    }

    public boolean maxRetriesReached() {
        return this.retryAttempt >= maxRetries;
    }

    public Integer getRetryAttempt() {
        return retryAttempt;
    }

    public void incrementRetryAttempt() {
        this.retryAttempt++;
    }

    public DateTime getLastRetryTime() {
        return lastRetryTime;
    }

    public void setLastRetryTime(DateTime lastRetryTime) {
        this.lastRetryTime = lastRetryTime;
    }

}
