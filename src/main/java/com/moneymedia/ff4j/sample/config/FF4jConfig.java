/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2013-2016 the original author or authors.
 */

package com.moneymedia.ff4j.sample.config;

import io.lettuce.core.RedisClient;
import org.ff4j.FF4j;
import org.ff4j.audit.repository.EventRepository;
import org.ff4j.audit.repository.InMemoryEventRepository;
import org.ff4j.conf.FF4jConfiguration;
import org.ff4j.core.FeatureStore;
import org.ff4j.parser.yaml.YamlParser;
import org.ff4j.property.store.InMemoryPropertyStore;
import org.ff4j.property.store.PropertyStore;
import org.ff4j.store.EventRepositoryRedisLettuce;
import org.ff4j.store.FeatureStoreRedisLettuce;
import org.ff4j.store.InMemoryFeatureStore;
import org.ff4j.store.PropertyStoreRedisLettuce;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;


/**
 * Definition of FF4j Bean.
 */
@Configuration
public class FF4jConfig {

    @Value("${ff4j.redis.uri}")
    private String redisUri;

    @Bean
    public FF4j getFF4j() {
        RedisClient redisClient = RedisClient.create(redisUri);

        FF4j ff4jBean = new FF4j();
        ff4jBean.setPropertiesStore(new PropertyStoreRedisLettuce(redisClient));
        ff4jBean.setFeatureStore(new FeatureStoreRedisLettuce(redisClient));
        ff4jBean.setEventRepository(new InMemoryEventRepository());
        ff4jBean.setEnableAudit(true);
        return ff4jBean;
    }
}
