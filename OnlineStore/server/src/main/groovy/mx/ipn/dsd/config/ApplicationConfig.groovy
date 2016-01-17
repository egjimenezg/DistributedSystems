package mx.ipn.dsd.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

@Configuration
@PropertySource('file:${HOME}/.dsd/db.properties')
class ApplicationConfig{

  @Autowired
  Environment env

}
