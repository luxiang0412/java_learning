package luxiang.top.redis;

import redis.clients.jedis.Jedis;

public class RedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("连接成功");
        System.out.println("服务正在运行"+jedis.ping());
        String a = jedis.get("a");
        System.out.println(a);
        jedis.set("b","sdfa f");
        jedis.lpush("c","a","b","c");
    }
}
