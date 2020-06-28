package org.example.lifeCycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 14:05
 */
public class Student implements BeanNameAware, InitializingBean, DisposableBean {
    private String name;

    /**
     * 无参构造
     */
    public Student(){
        System.out.println("无参构造函数");
    }

    /**
     * 设置对象属性
     * @param name
     */
    public void setName(String name) {
        System.out.println("设置对象属性setName()..");
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行DisposableBean接口的destroy方法");
    }

    /**
     * 自定义Bean的初始化方法
     */
    private void initStudent() {
        System.out.println("Student这个Bean：自定义初始化");
    }

    /**
     * 自定义Bean的销毁
     */
    private void destroyStudent() {
        System.out.println("Student这个Bean：自定义销毁");
    }

    public void play(){
        System.out.println("Student这个Bean：使用");
    }

    @Override
    public String toString() {
        return "Student [name = " + name + "]";
    }

    /**
     * 调用BeanNameAware的setBeanName()
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware的setBeanName()..."+"name："+name);
    }

}
