package dictionarySpring;

import dictionarySpring.configuration.SpringConfig;
import dictionarySpring.view.ActionController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ActionController test = context.getBean(ActionController.class);
        test.choice();
        test.actions();
    }
}
