package example.smallest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
    	 SpringApplication.run(Application.class, args);
    }

    @Scheduled(fixedDelay = 1000L)
    public void foo() {
        System.out.println(jdbcTemplate.queryForObject("select 1", String.class));
    }
}
