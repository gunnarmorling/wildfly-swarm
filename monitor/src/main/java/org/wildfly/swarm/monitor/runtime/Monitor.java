/**
 * Copyright 2015-2016 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wildfly.swarm.monitor.runtime;

import java.util.List;
import java.util.Optional;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.as.domain.management.SecurityRealm;
import org.jboss.dmr.ModelNode;
import org.wildfly.swarm.monitor.HealthMetaData;

/**
 * The main API exposed by the monitoring service
 *
 * @author Heiko Braun
 * @since 19/02/16
 */
public interface Monitor {

    String JNDI_NAME = "swarm/monitor";

    static Monitor lookup() throws NamingException {
        InitialContext context = new InitialContext();
        return (Monitor) context.lookup("jboss/" + Monitor.JNDI_NAME);
    }

    ModelNode getNodeInfo();

    ModelNode heap();

    ModelNode threads();

    void registerHealth(HealthMetaData metaData);

    List<HealthMetaData> getHealthURIs();

    Optional<SecurityRealm> getSecurityRealm();
}
