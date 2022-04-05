package validator;

import java.util.regex.Pattern;

public class Validation implements ValidInterface{

    String valuePattern;
    String keyPattern;

    public Validation(String valuePattern, String keyPattern){
        this.valuePattern = valuePattern;
        this.keyPattern = keyPattern;
    }

    @Override
    public boolean keyCheck(String key) {
        return Pattern.matches(keyPattern, key);
    }

    @Override
    public boolean valueCheck(String value) {
        return Pattern.matches(valuePattern, value);
    }
}
