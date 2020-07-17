package com.diflows.backend;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void testRedis() throws NullPointerException {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations<Object, Object> ops = redisTemplate.opsForValue();
        System.out.println(ops.get("k1"));

        ops.set("k2", "v2", Duration.ofHours(1));
        Object k1 = ops.get("k2");
        Assert.assertEquals("v2", k1);
        System.out.println(k1);

        ops.set("k3", 3);
        Object k3 = ops.get("k3");
        Assert.assertEquals(3, k3);
        System.out.println(k3);

        List<Integer> k4 = Arrays.asList(1, 2, 3);
        ops.set("k5", k4);
        Object k5 = ops.get("k5");
        Assert.assertEquals(k5, k4);

        Set<Object> keys = redisTemplate.keys("*");
        assert keys != null;
        assert keys.size() != 0;
        System.out.println(keys);

        redisTemplate.delete(keys);
        Object keysNum = redisTemplate.countExistingKeys(keys);
        assert keysNum != null;
        Assert.assertEquals(0, (long) keysNum);
    }

    @Test
    void contextLoads() {

    }
}
