package uz.customs.customsprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ServletComponentScan
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class CustomspriceApplication {
    public final static String MODEL_PACKAGE = "uz.customs.customsprice.entity";

    public static void main(String[] args) {
        SpringApplication.run(CustomspriceApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CustomspriceApplication.class);
    }

}
