import com.coderbuff.bean.AutoInjectionBean;
import com.coderbuff.bean.Demo;
import com.coderbuff.bean.InstanceA;
import com.coderbuff.bean.InstanceB;
import com.coderbuff.config.Config;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OKevin On 2019/8/27
 */
public class SpringAnnotationTest {
    /**
     * IoC容器
     */
    private AnnotationConfigApplicationContext ctx;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    /**
     * 测试注解配置方式创建bean
     */
    @Test
    public void beanCreateTest() {
        Demo demo = ctx.getBean(Demo.class);
        Assert.assertNotNull(demo);
    }

    /**
     * 测试注解自动注入bean
     */
    @Test
    public void autowiredBeanCreateTest() {
        AutoInjectionBean autoInjectionBean = ctx.getBean(AutoInjectionBean.class);
        Assert.assertNotNull(autoInjectionBean);
    }

    /**
     * 测试循环依赖bean创建
     */
    @Test
    public void cycleBeanCreateTest() {
        InstanceA instanceA = ctx.getBean(InstanceA.class);
        InstanceB instanceB = ctx.getBean(InstanceB.class);
        Assert.assertNotNull(instanceA);
        Assert.assertNotNull(instanceB);
    }

    /**
     * 关闭IoC容器
     * 测试bean的销毁方法
     */
    @After
    public void destory() {
        ctx.close();
    }
}
