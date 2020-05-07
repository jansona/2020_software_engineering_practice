package software.practice.distribution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan("software.practice.distribution.mapper")
@ComponentScan(basePackages = {"software.practice.distribution.controller","software.practice.distribution.service","software.practice.distribution.entity","software.practice.distribution.result","software.practice.distribution.mapper"})
public class DistributionApplication {

    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(DistributionApplication.class, args);
    }
}
