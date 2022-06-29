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

    private final static String MAP = "map";

    @Bean(name = "dictionaryFactory")
    public DictionaryStorage getDictionary(@Value("${type}") String args) {
        if (args.equals(MAP)) {
            return new MapStorage();
        } else {
            return new FileStorage();
        }
    }
}

