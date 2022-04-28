package uz.customs.customsprice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/CUSTOMSPRICE/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                .antMatchers("/user/auth/auth-signin/**").permitAll()
                .antMatchers("/user/auth/auth-signup/**").permitAll()//.not().fullyAuthenticated()
                .antMatchers("/user/auth/auth-create/**").not().fullyAuthenticated()
                .antMatchers("/user/auth/E404/**").permitAll()
                .antMatchers("/esad", "/logo/**").permitAll()
                .antMatchers("/logo", "/skvnksjdhfjksd.do/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/personsrestapi/**").permitAll()
                .antMatchers("/appsrestapi/**").permitAll()
                .antMatchers("/commodityrestapi/**").permitAll()
                .antMatchers("/transporttyperestapi/**").permitAll()
                .antMatchers("/decisionPdfDownload/**").permitAll()
                .antMatchers("/appsrequesthaving/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/user/auth/auth-signin")
                .defaultSuccessUrl("/")
                .failureUrl("/user/auth/E404")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/exit.do")
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/user/auth/E404");
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @Configuration
    public static class FaviconConfiguration {
        @Bean
        public SimpleUrlHandlerMapping faviconHandlerMapping() {
            SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
            mapping.setOrder(Integer.MIN_VALUE);
            mapping.setUrlMap(Collections.singletonMap("/favicon.ico", faviconRequestHandler()));
            return mapping;
        }

        @Bean
        protected ResourceHttpRequestHandler faviconRequestHandler() {
            ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
            requestHandler.setLocations(List.<Resource>of(new ClassPathResource("/")));
            return requestHandler;
        }
    }
}
