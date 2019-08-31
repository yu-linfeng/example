import com.coderbuff.config.Config;
import com.coderbuff.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by OKevin On 2019/8/31
 */
public class SprintAnnotationTransactionalTest {
    private AnnotationConfigApplicationContext ctx;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void insertTest() {
        UserService userService = ctx.getBean(UserService.class);
        userService.insertUser();
    }
}
