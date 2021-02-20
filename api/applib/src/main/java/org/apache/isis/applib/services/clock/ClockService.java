/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.isis.applib.services.clock;

/**
 * This service allows an application to be decoupled from the system time.
 * The most common use case is in support of testing scenarios, to &quot;mock the clock&quot;.
 * Use of this service also opens up the use of centralized
 * co-ordinated time management through a centralized time service.
 *
 * @since 1.x revised for 2.0 {@index}
 */
public interface ClockService {

    VirtualClock getClock();

    // -- SHORTCUTS

    default long getEpochMillis() {
        return getClock().getEpochMillis();
    }

}
