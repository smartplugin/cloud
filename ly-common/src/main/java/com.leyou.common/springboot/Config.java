package com.leyou.common.springboot;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.PropertySource;

import java.util.*;

/**
 * @author chendong
 * @date 2018-07-16
 * @description
 */
public class Config {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
//        map.put("c", "vvvvvv");
//        map.put("a", "aaaaa");
//        map.put("b", "bbbbb");
//        map.put("d", "ddddd");

        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        //升序排序
        Collections.sort(list, Comparator.comparing(Map.Entry::getKey));

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

}
