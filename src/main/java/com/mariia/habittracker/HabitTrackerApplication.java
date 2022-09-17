package com.mariia.habittracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
@ComponentScan(excludeFilters={
    @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=DataSourceAutoConfiguration.class),
    @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=HibernateJpaAutoConfiguration.class)
})
public class HabitTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitTrackerApplication.class, args);
    }

}
