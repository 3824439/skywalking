/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.core.analysis;

import org.apache.skywalking.oap.server.core.source.NodeType;
import org.junit.Assert;
import org.junit.Test;

public class IDManagerTest {
    @Test
    public void testServiceID() {
        IDManager.ServiceID.ServiceIDDefinition define = new IDManager.ServiceID.ServiceIDDefinition(
            "Service",
            NodeType.Normal
        );
        final IDManager.ServiceID.ServiceIDDefinition relationDefine = IDManager.ServiceID.analysisId(
            IDManager.ServiceID.buildId(
                "Service",
                NodeType.Normal
            ));
        Assert.assertEquals(define, relationDefine);
    }

    @Test
    public void testServiceRelationID() {
        IDManager.ServiceID.ServiceRelationDefine define = new IDManager.ServiceID.ServiceRelationDefine(
            IDManager.ServiceID.buildId("ServiceSource", NodeType.Normal),
            IDManager.ServiceID.buildId("ServiceDest", NodeType.Normal),
            1
        );

        final IDManager.ServiceID.ServiceRelationDefine serviceRelationDefine = IDManager.ServiceID.analysisRelationId(
            IDManager.ServiceID.buildRelationId(define));
        Assert.assertEquals(define, serviceRelationDefine);
    }

}
