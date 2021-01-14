package container.config.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"container.soundsystem"}) // Automatic Configuration
public class CDPlayerConfig {
}
