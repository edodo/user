package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class},
        basePackages = {"user.model"})
@SpringBootApplication
public class user {
    public static void main(String[] args) {
        SpringApplication.run(user.class, args);
    }
}
