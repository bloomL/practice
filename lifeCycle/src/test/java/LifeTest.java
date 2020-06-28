import org.example.lifeCycle.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liguo
 * @Description
 * @date 2020/6/24/024 14:38
 */
public class LifeTest {

    @Test
    public void testLife(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student = (Student) context.getBean("student");
        student.play();
        System.out.println(student);
        //关闭容器
        context.close();
    }
}
