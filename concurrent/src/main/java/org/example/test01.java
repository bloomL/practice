package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liguo
 * @Description
 * @date 2020/8/19/019 16:49
 */
public class test01 {
    public static void main(String[] args) {
        System.out.println("blob:http://localhost:8080/f4efebaa-bfc4-42b5-a1d3-d19c2ce83a18".length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(sdf.format(new Date()));

        //当前时间的时间戳
        System.out.println(System.currentTimeMillis());
        //System.out.println(getCode("大专"));

    }

    public static String getCode(String name){
        StringBuilder code = new StringBuilder();
        switch (name){
            case "中职":
                code.append("0");
                break;
            case "高职":
                code.append("1");
                break;
            case "本科":
                code.append("2");
                break;
            default:
                break;
        }
        return code.toString();
    }
}
