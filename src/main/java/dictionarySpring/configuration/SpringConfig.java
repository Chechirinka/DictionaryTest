package dictionarySpring.configuration;

import dictionarySpring.storage.DictionaryStorage;
import dictionarySpring.storage.FileStorage;
import dictionarySpring.storage.MapStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("dictionarySpring")
@PropertySource(value = "classpath:test.yml")
public class SpringConfig {

    @Bean(name = "dictionaryFactory")
    public DictionaryStorage getDictionary(@Value("${type}") String args) {
        if (args.equals("map")) {
            return new MapStorage();
        } else {
            return new FileStorage();
        }
    }
}

