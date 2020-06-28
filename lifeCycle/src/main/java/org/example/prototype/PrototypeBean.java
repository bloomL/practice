package org.example.prototype;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 17:18
 */
public class PrototypeBean {
    private String name;

    public PrototypeBean(){
        System.out.println("PrototypeBean构造函数");
    }

    private void init() {
        System.out.println("自定义初始化：this is init of prototypeBean");
    }

    private void destroy() {
        System.out.println("自定义销毁：this is destroy of prototypeBean " + this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
