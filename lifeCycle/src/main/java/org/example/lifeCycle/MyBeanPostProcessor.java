package org.example.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liguo
 * @Description  bean的后处理器
 *                  bean的初始化前后对bean对象提供自己的实例化逻辑
 *                  postProcessBeforeInitialization：初始化之前对bean进行增强处理
 *                  postProcessAfterInitialization：初始化之后对bean进行增强处理
 * @date 2020/6/24/024 14:20
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 对初始化之前的Bean进行处理
     * @param bean 即将初始化的bean
     * @param beanName bean名称
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行BeanPostProcessor的postProcessBeforeInitialization方法,名称为："+bean);
        return bean;
    }

    /**
     * 对初始化之后的bean进行处理
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Student stu = null;
        System.out.println("执行BeanPostProcessor的postProcessAfterInitialization方法,名称为："+bean+" 并将Bean的成员变量的值修改了");
        if(bean instanceof Student) {
            stu = (Student) bean;
            stu.setName("Guo");
        }
        return stu;
    }
}
