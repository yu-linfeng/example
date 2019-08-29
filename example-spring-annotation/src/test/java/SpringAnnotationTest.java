import com.coderbuff.bean.*;
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
     * bean通过配置文件属性赋值测试
     */
    @Test
    public void propertyValueTest() {
        Client client = ctx.getBean(Client.class);
        Assert.assertEquals(client.getUrl(), "localhost");
        Assert.assertEquals(client.getUser(), "okevin");
        Assert.assertEquals(client.getPassword(), "0000");
    }

    /**
     * profile测试环境切换测试
     * Run Config: -Dspring.profiles.active=test
     * 常结合maven使用
     */
    @Test
    public void testEnvirProfileTest() {
    }

    /**
     * profile生产切换测试
     * Run Config: -Dspring.profiles.active=prod
     * 常结合maven使用
     */
    @Test
    public void prodEnvirProfileTest() {
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
