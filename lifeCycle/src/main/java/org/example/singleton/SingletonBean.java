package org.example.singleton;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 16:48
 */
public class SingletonBean {
    private String name;

    public SingletonBean(){
        System.out.println("SingletonBean构造函数");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("填充属性：setName");
        this.name = name;
    }

    private void init() {
        System.out.println("自定义初始化：this is init of lifeBean");
    }

    private void destroy() {
        System.out.println("自定义销毁：this is destroy of lifeBean " + this);
    }

    @Override
    public String toString() {
        return "SingletonBean [name = " + name + "]";
    }
}
