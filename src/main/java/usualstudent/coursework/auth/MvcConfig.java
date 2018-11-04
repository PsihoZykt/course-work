package usualstudent.coursework.auth;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Указываем спрингу на каком URL у нас происходит логин
     * и имя контроллера отвечающего за логин
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");

    }

    /**
     * Нужно для того, чтобы подключать всякие css js и прочее
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/");
    }



}