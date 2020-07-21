import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liguo
 * @Description 测试反射
 * @date 2020/6/29/029 16:01
 */
public class ReflectTest {

    //@Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> rClass = Class.forName("org.example.Student");
        Object reflectObject = rClass.newInstance();
        //所有定义的方法
        Method[] methods = rClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));
        //获取指定方法并调用
        Method publicPlay = rClass.getDeclaredMethod("publicPlay", String.class);
        publicPlay.invoke(reflectObject,"chengdu");
        Method getName = rClass.getDeclaredMethod("getName");
        System.out.println("name修改前值："+getName.invoke(reflectObject));
        //获取指定参数并修改
        Field name = rClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(reflectObject,"ll");
        System.out.println("name修改后值："+getName.invoke(reflectObject));
        //调用private方法
        Method privateEat = rClass.getDeclaredMethod("privateEat", String.class);
        privateEat.setAccessible(true);
        privateEat.invoke(reflectObject,"watermelon");
    }

    @Test
    public void show(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(8);
        /*for (Integer i : list){
            //list.remove(i);
            //list.add(8);
            System.out.println(i);
        }*/
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if (Objects.equals(1,iterator.next())){
                iterator.remove();
            }
            System.out.println(iterator.next());
            //list.add(2);

        }

    }

}
