import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.onlineShop.*"})
@EntityScan(basePackages = {"com.onlineShop.*"})
@EnableJpaRepositories(basePackages = {"com.onlineShop.*"})
@SpringBootApplication
public class StoreApp {
    public static void main(String[] args) {
        SpringApplication.run(StoreApp.class, args);
        Facade running = new Facade();
        running.run();
    }
}