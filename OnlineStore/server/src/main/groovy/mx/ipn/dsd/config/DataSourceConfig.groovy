package mx.ipn.dsd.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

import static org.springframework.orm.jpa.vendor.Database.MYSQL
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories("mx.ipn.dsd.repository")
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

  @Bean
  JpaVendorAdapter jpaVendorAdapter(){
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter()
    hibernateJpaVendorAdapter.setShowSql(false)
    hibernateJpaVendorAdapter.setGenerateDdl(false)
    hibernateJpaVendorAdapter.setDatabase(MYSQL)
    hibernateJpaVendorAdapter 
  }
  
  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env){
    LocalContainerEntityManagerFactoryBean localContainer = new LocalContainerEntityManagerFactoryBean()
    localContainer.setDataSource(dataSource(env))
    localContainer.setJpaVendorAdapter(jpaVendorAdapter()) 
    localContainer.setPackagesToScan("mx.ipn.dsd.domain")
    localContainer
  }
  
}
