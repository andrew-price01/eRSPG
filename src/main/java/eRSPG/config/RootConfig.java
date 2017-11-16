package eRSPG.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@Configuration
@Import({DataConfig.class, WebSecurityConfig.class})
@ComponentScan(basePackages={"eRSPG"})
public class RootConfig {
}
