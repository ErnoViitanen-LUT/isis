/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.isis.core.plugins.ioc;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Singleton;

/**
 * Acts as a no-op implementation, that is used as lowest priority default, whenever
 * service-provisioning can not find any alternative with higher priority.  
 * 
 * @since 2.0.0-M3
 *
 */
@Singleton @Alternative @Priority(0)
public class RequestContextServiceDefault implements RequestContextService {

    @Override
    public RequestContextHandle startRequest() {
        return null; // don't return a handle
    }

}