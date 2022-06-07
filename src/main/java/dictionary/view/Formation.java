package dictionary.view;

import java.util.Formatter;

public class Formation {

    private Formatter formatter;

    private void formatTo(String userInput, String form) {
        formatter = new Formatter();
        formatter.format(form, userInput);
        System.out.println(formatter);
        formatter.close();
    }
}
