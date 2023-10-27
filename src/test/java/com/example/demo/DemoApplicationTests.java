package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void redisConnectionTest(){

        JedisPool pool = new JedisPool("172.17.0.2", 6379);

        try (Jedis jedis = pool.getResource()) {

            // Store & Retrieve a simple string
            jedis.set("test.foo", "bar");

            assertEquals("bar", jedis.get("test.foo"));
            
            jedis.del("test.foo");

            // Store and Retrieve a HashMap
            Map<String, String> hash = new HashMap<>();;
            hash.put("name", "John");
            hash.put("surname", "Smith");
            hash.put("company", "Redis");
            hash.put("age", "29");
            
            jedis.hset("test.user.John", hash);

            assertEquals(hash, jedis.hgetAll("test.user.John"));

            jedis.del("test.user.John");

        }
        
    }

}
