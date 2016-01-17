package mx.ipn.dsd.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

@Configuration
class DataSourceConfig{

  @Bean
  DataSource dataSource(Environment env){
    HikariConfig dataSourceConfig = new HikariConfig()
    dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"))
    dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"))
    dataSourceConfig.setUsername(env.getRequiredProperty("db.username"))
    dataSourceConfig.setPassword(env.getRequiredProperty("db.password"))
    new HikariDataSource(dataSourceConfig)
  }
}
