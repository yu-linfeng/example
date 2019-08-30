import com.coderbuff.config.AppConfig;
import com.coderbuff.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author cdyulinfeng
 * @date 2019/8/30
 **/
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*public void onStartup(ServletContext servletCtx) throws ServletException {

        *//**
         * Spring IoC容器
         *//*
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(AppConfig.class);

        //<listener><listener-class>org.springframework.web.context.ContextLoaderListener</listener-class></listener>
        servletCtx.addListener(new ContextLoaderListener(rootCtx));

        *//**
         * Spring MVC IoC容器
         *//*
        AnnotationConfigWebApplicationContext dispatcherCtx = new AnnotationConfigWebApplicationContext();
        dispatcherCtx.register(WebConfig.class);

        *//**
         * 注册请求分发器
         *//*
        ServletRegistration.Dynamic dispatcher = servletCtx.addServlet("dispatcherCtx", new DispatcherServlet(dispatcherCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }*/

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
}
