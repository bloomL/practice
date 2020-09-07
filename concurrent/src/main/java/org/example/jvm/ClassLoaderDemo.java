package org.example.jvm;

/**
 * @author liguo
 * @Description
 * @date 2020/8/27/027 15:49
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("类加载器为："+ClassLoaderDemo.class.getClassLoader());
        System.out.println("父级类加载器为："+ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("父父级类加载器为："+ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
