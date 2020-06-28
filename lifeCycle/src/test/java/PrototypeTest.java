import org.example.prototype.PrototypeBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 17:22
 */
public class PrototypeTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Prototype.xml");
        PrototypeBean bean1 = (PrototypeBean) context.getBean("prototypeBean");
        System.out.println(bean1);

        PrototypeBean bean2 = (PrototypeBean) context.getBean("prototypeBean");
        System.out.println(bean2);

        context.close();
    }
}
