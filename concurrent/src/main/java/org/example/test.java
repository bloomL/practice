package org.example;

/**
 * @author liguo
 * @Description
 * @date 2020/8/17/017 15:02
 */
public class test {
    public static void main(String[] args) {
        /*String testStr = "公司S22, 3. 92啊a";
        String regex = "[^\\s]";
        Matcher matcher = Pattern.compile(regex).matcher(testStr);
        if (matcher.find()) {
            int index = matcher.start();
            System.out.println("第一个非空的位置是:" + index);
        }*/
        String s = "1-1";
        String[] split = s.split("-");
        System.out.println(split.length);
    }
}
