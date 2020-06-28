import org.example.singleton.SingletonBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 16:56
 */
public class SingletonTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Singleton.xml");
        SingletonBean singletonBean = (SingletonBean) context.getBean("singletonBean");
        System.out.println(singletonBean);
        context.close();
    }

}
