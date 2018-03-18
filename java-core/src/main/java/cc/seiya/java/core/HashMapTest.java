package cc.seiya.java.core;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMapTest test
 * @author seiya
 * @date 2018/3/9 22:50
 */
public class HashMapTest {

    @Test
    public void putTest(){

        String a = "a";
        String b = "b";

        Map<String,String> map = new HashMap();
        map.put(a,a);
        map.put(b,b);
        map.put(a,a);


    }
}
