package boot.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
@EnableJpaRepositories("boot.repository")
public class CustomHikariConfig extends HikariConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }
  
}
  