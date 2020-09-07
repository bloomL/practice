package org.example.jvm;

/**
 * @author liguo
 * @Description
 * @date 2020/8/4/004 15:44
 */
public class Demo1 {
    public static void main(String[] args) {
        byte[] allocation1, allocation2;
        allocation1 = new byte[58000*1024];
        allocation2 = new byte[2000*1024];
    }
}
