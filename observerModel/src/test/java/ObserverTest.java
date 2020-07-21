import org.example.publisher.DemoPublisher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author liguo
 * @Description
 * @date 2020/6/28/028 10:50
 */
public class ObserverTest {
    //@Test
    public void test(){
        DemoPublisher publisher = new DemoPublisher();
        publisher.publisher("监听者");
    }

    public void write() throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        br.close();
    }

}
