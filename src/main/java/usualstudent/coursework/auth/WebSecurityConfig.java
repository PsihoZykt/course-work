


//package usualstudent.coursework.auth;


////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.core.userdetails.UserDetailsService;
////
////
////@Configuration
////@EnableWebSecurity
////@EnableOAuth2Sso
////public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
////
////    @Autowired
////    private UserDetailsService userDetailsService;
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////
////        http
////                .authorizeRequests()
////                  .antMatchers("/", "/login", "/callback", "portal/home","/registration", "/google ", "/login/**", "/callback/**", "/static/**", "/activate/*").permitAll()
////             //   .antMatchers("/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .rememberMe()
////                .and()
////                .logout()
////                .permitAll()
////                .and()
////                .csrf().disable();
////
////    }
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService);
////    }
////
////    @Override
////    public UserDetailsService userDetailsService() {
////        return userDetailsService;
////    }
////}