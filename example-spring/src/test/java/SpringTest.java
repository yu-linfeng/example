import com.coderbuff.bean.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by OKevin On 2019/8/27
 */
public class SpringTest {

    /**
     * IoC容器
     */
    private ClassPathXmlApplicationContext ctx;

    /**
     * 初始化IoC容器
     */
    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 测试xml配置方式创建bean
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

    @Test
    public void propertyValueTest() {
        Client client = ctx.getBean(Client.class);
        Assert.assertEquals(client.getUrl(), "localhost");
        Assert.assertEquals(client.getUser(), "okevin");
        Assert.assertEquals(client.getPassword(), "0000");
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
