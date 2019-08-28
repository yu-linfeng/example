import com.coderbuff.aop.LogAspect;
import com.coderbuff.bean.Calc;
import com.coderbuff.config.AopConfig;
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
        ctx = new AnnotationConfigApplicationContext(AopConfig.class);
    }


    @Test
    public void aopTest() {
        Calc calc = ctx.getBean(Calc.class);
        LogAspect a = ctx.getBean(LogAspect.class);
        System.out.println(a == null);
        calc.div(1, 2);
    }
}
