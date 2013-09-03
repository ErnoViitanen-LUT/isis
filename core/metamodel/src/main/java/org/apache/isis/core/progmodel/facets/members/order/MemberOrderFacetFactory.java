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

package org.apache.isis.core.progmodel.facets.members.order;

import java.util.Properties;

import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.core.metamodel.facetapi.FacetUtil;
import org.apache.isis.core.metamodel.facetapi.FeatureType;
import org.apache.isis.core.metamodel.facets.Annotations;
import org.apache.isis.core.metamodel.facets.FacetFactoryAbstract;
import org.apache.isis.core.metamodel.facets.FacetedMethod;
import org.apache.isis.core.metamodel.facets.members.order.MemberOrderFacet;

public class MemberOrderFacetFactory extends FacetFactoryAbstract {

    public MemberOrderFacetFactory() {
        super(FeatureType.MEMBERS);
    }

    @Override
    public void process(final ProcessMethodContext processMethodContext) {
        
        final FacetedMethod holder = processMethodContext.getFacetHolder();
        
        MemberOrderFacet memberOrderFacet = null;
        final Properties properties = processMethodContext.metadataProperties("memberOrder");
        if(properties != null) {
            memberOrderFacet = new MemberOrderFacetProperties(properties, holder);
        }

        if(memberOrderFacet == null) {
            final MemberOrder annotation = Annotations.getAnnotation(processMethodContext.getMethod(), MemberOrder.class);
            if (annotation != null) {
                memberOrderFacet = new MemberOrderFacetAnnotation(annotation.name(), annotation.sequence(), holder);
            }
        }

        // no-op if facet is null
        FacetUtil.addFacet(memberOrderFacet);
    }

}
