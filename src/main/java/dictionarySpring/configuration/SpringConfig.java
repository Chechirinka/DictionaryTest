package dictionarySpring.configuration;

import dictionarySpring.storage.DictionaryStorage;
import dictionarySpring.storage.FileStorage;
import dictionarySpring.storage.MapStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("dictionarySpring")
@PropertySource(value = "classpath:test.yml")
@EnableWebMvc
public class SpringConfig {

    private final static String MAP = "map";

    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    @Bean(name = "dictionaryFactory")
    public DictionaryStorage getDictionary(@Value("${type}") String args) {
        if (args.equals(MAP)) {
            return new MapStorage();
        } else {
            return new FileStorage();
        }
    }
}

