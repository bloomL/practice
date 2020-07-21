package org.example;

/**
 * @author liguo
 * @Description
 * @date 2020/6/29/029 15:24
 */
public class Student {
    private String name;
    private Integer age;

    public Student(){
        name="l";
        age=18;
    }

    public void publicPlay(String palce){
        System.out.println("go to "+palce+" to play");
    }

    public String getName() {
        return name;
    }

    private void privateEat(String name){
        System.out.println("eat "+name);
    }
}
