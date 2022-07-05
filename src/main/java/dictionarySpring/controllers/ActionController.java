package dictionarySpring.controllers;

import dictionarySpring.configuration.DictionaryType;
import dictionarySpring.exception.TypeNotFoundException;
import dictionarySpring.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/action")
public class ActionController {
    public final static String NO_EXIST_KEY = "Ключ не найден";
    private final static String SELECT_LANGUAGE = "Select lang: 1 - English; 2 - Digital;";
    private final static String NO_EXIST_LANGUAGE = "Ошибка, такого языка не существует, повторите ввод!";
    private final static String SUCCESS = "Success";
    private final static String ERROR = "Error";
    private final static String DELETE = "Удалено";
    private final static String NO_DELETE = "Не удалено";
    private final DictionaryService dictionaryService;

    private DictionaryType selectedDictionary;

    @Autowired
    public ActionController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("read")
    @ResponseBody
    public List<String> read() {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(1);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        return dictionaryService.readService(selectedDictionary);
    }

    @PostMapping("write")
    @ResponseBody
    public boolean write(@RequestParam String key, @RequestParam String value) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(1);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        return dictionaryService.addService(key, value, selectedDictionary);
    }

    @GetMapping("search")
    @ResponseBody
    public String search(@RequestParam String key) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(1);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        return dictionaryService.searchService(key, selectedDictionary);
    }

    @PostMapping("remove")
    @ResponseBody
    public String remove(@RequestParam String key){
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(1);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        if (dictionaryService.removeService(key, selectedDictionary)) {
            return DELETE;
        }
        return NO_DELETE;
    }
}