import com.coderbuff.bean.Calc;
import com.coderbuff.config.Config;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OKevin On 2019/8/28
 */
public class SpringAnnotationAopTest {
    /**
     * IoC容器
     */
    private AnnotationConfigApplicationContext ctx;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }


    @Test
    public void aopTest() {
        Calc calc = ctx.getBean(Calc.class);
        System.out.println(calc.div(1, 1));
    }
}
