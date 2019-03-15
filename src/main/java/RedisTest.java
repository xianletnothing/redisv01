import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接reids成功");
        jedis.set("test01","1");
        String test01=jedis.get("test01");
        System.out.println(test01);
        jedis.lpush("test02","55");
        jedis.lpush("test02","22");
        jedis.lpush("test02","33");
        jedis.lpush("test02","44");


        List<String> arr = jedis.lrange("test02",0,100);
        String test02 = jedis.lpop("test02");
        String test03 = jedis.lpop("test02");
        String test04 = jedis.rpop("test02");
        for(String array:arr){
            System.out.println(array);
        }
        System.out.println(test02);
        System.out.println(test03);
        System.out.println(test04);
        System.out.println("这里是map的测试方法");
        Map<String,String>  map = new HashMap<String, String>();
        map.put("name","xiaoxianshen");
        map.put("age","19");
        map.put("school","xidian");
        jedis.hmset("people",map);
        String[] arr1=new String[3];
        arr1[0]="name";
        arr1[1]="age";
        arr1[2]="school";
        List<String> list = jedis.hmget("people",arr1);
        for (int i=0;i<arr1.length;i++){
            System.out.println(list.get(i));
        }

    }
}
