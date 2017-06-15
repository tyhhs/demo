import com.netease.tyh.springmvcSpringDataRedisDemo.model.Address;
import com.netease.tyh.springmvcSpringDataRedisDemo.model.User;
import com.netease.tyh.springmvcSpringDataRedisDemo.service.redis.UserCacheService;
import com.netease.tyh.springmvcSpringDataRedisDemo.service.redis.RedisService;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * RedisTest
 * Author: bjtangyunhao
 * Creation date: 2017年06月14日 20:34
 * Modified by: bjtangyunhao
 * Last modified: 2017年06月14日 20:34
 */
public class RedisTest extends AbstractSpringTest{
    @Resource
    RedisService redisService;

    @Resource
    UserCacheService userCacheService;

    @Test
    public void testRedis(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        redisService.put("test", sdf.format(new Date()));
    }

    @Test
    public void testZSet(){
        redisService.zadd("zsetTest", "tony", 10);
        redisService.zadd("zsetTest", "michelle", 5);
        redisService.zadd("zsetTest", "alex", 1);
        redisService.zadd("zsetTest", "tonyMax", 100);
        Set<String> res = redisService.zrevrange("zsetTest", 0L, -1L);
        for(String i : res){
            System.out.println(i);
        }
    }

    @Test
    public void testRepository(){
        Address address = new Address("Anhui", "Huangshan", "Huangshan");
        User user = new User(1L, "yunhao", 26, address);
        userCacheService.cacheUser(user);
        User user1 = userCacheService.getUser("1");
        System.out.println(user1.toString());
        System.out.println(user1.getAddress().toString());
    }
}
