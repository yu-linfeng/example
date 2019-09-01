import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by OKevin On 2019/9/1
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        ctx.start();
        while (true) {

        }
    }
}
