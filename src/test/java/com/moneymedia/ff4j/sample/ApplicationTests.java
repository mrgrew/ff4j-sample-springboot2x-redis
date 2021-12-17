package com.moneymedia.ff4j.sample;

import com.github.fppt.jedismock.RedisServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ApplicationTests {

    private static RedisServer redisServer = null;

    @BeforeAll
    public static void beforeAll() throws IOException {
        redisServer = RedisServer.newRedisServer();
        redisServer.start();

        String ff4jRedisUri = String.format("redis://%s:%d/1", redisServer.getHost(), redisServer.getBindPort());
        System.setProperty("ff4j.redis.uri", ff4jRedisUri);
    }

    @AfterAll
    static void afterAll() {
        redisServer.stop();
    }

    @Test
    void contextLoads() {
    }

}
