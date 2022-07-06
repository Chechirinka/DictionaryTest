package dictionarySpring.controllers;

import dictionarySpring.configuration.DictionaryType;
import dictionarySpring.exception.TypeNotFoundException;
import dictionarySpring.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/action")

public class ActionController {
    private final static String NO_EXIST_LANGUAGE = "Ошибка, такого языка не существует, повторите ввод!";
    private final static String SUCCESS = "Success";
    private final static String ERROR = "Error";
    private final static String DELETE = "Удалено";
    private final static String NO_DELETE = "Не удалено";
    private final static String RESULT = "result";
    public final static String ID = "id";

    private final DictionaryService dictionaryService;

    private DictionaryType selectedDictionary;

    @Autowired
    public ActionController(DictionaryService dictionaryService) {

        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/read")

    public String read(@RequestParam(value = "id") int id,
                       Model model) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        List<String> readResult = dictionaryService.readService(selectedDictionary);

        model.addAttribute(ID, id);
        model.addAttribute(RESULT, readResult);
        return "action_results/read_result";
    }

    @PostMapping("/add")

    public String write(@RequestParam(value = "key") String key,
                        @RequestParam(value = "value") String value,
                        @RequestParam(value = "id") int id, Model model) {
        model.addAttribute("id", id);
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        if (dictionaryService.addService(key, value, selectedDictionary)) {
            model.addAttribute(RESULT, SUCCESS);
        } else {
            model.addAttribute(RESULT, ERROR);
        }
        return "action_results/add_result";
    }

    @GetMapping("/search")

    public String search(@RequestParam String key,
                         @RequestParam(value = "id") int id, Model model) {
        model.addAttribute("id", id);
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        String searchResult = dictionaryService.searchService(key, selectedDictionary);
        model.addAttribute(RESULT, searchResult);
        return "action_results/search_result";
    }

    @PostMapping("/remove")

    public String remove(@RequestParam String key,
                         @RequestParam(value = "id") int id, Model model) {
        model.addAttribute(ID, id);
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        if (dictionaryService.removeService(key, selectedDictionary)) {
            model.addAttribute(RESULT, DELETE);
        } else {
            model.addAttribute(RESULT, NO_DELETE);
        }
        return "action_results/remove_result";
    }
}
