package io.github.jhipster.security.uaa;

/*-
 * #%L
 * JHipster server-side framework
 * %%
 * Copyright (C) 2016 - 2018 JHipster
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import io.github.jhipster.config.JHipsterProperties;

@Configuration
@ConditionalOnClass({ ClientCredentialsResourceDetails.class, LoadBalancerClient.class })
@ConditionalOnProperty("jhipster.security.client-authorization.client-id")
public class UaaAutoConfiguration {

    private JHipsterProperties jHipsterProperties;

    public UaaAutoConfiguration(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @Bean
    public LoadBalancedResourceDetails loadBalancedResourceDetails(LoadBalancerClient loadBalancerClient) {
        LoadBalancedResourceDetails loadBalancedResourceDetails = new LoadBalancedResourceDetails(loadBalancerClient);
        JHipsterProperties.Security.ClientAuthorization clientAuthorization = jHipsterProperties.getSecurity()
            .getClientAuthorization();
        loadBalancedResourceDetails.setAccessTokenUri(clientAuthorization.getAccessTokenUri());
        loadBalancedResourceDetails.setTokenServiceId(clientAuthorization.getTokenServiceId());
        loadBalancedResourceDetails.setClientId(clientAuthorization.getClientId());
        loadBalancedResourceDetails.setClientSecret(clientAuthorization.getClientSecret());
        return loadBalancedResourceDetails;
    }
}
