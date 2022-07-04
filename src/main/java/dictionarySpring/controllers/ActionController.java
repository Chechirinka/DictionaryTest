package dictionarySpring.controllers;

import dictionarySpring.configuration.DictionaryType;
import dictionarySpring.exception.TypeNotFoundException;
import dictionarySpring.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @GetMapping("/read")

    public String read(@RequestParam(value = "id") int id,
                             ModelMap model) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        List<String> readResult = dictionaryService.readService(selectedDictionary);

        model.addAttribute("id", id);
        model.addAttribute("result", readResult);
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
            model.addAttribute("result", SUCCESS);
        } else {
            model.addAttribute("result", ERROR);
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
        model.addAttribute("result", searchResult);
        return "action_results/search_result";
    }

    @PostMapping("/remove")

    public String remove(@RequestParam String key,
                         @RequestParam(value = "id") int id, Model model) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            System.out.println(NO_EXIST_LANGUAGE);
        }
        if (dictionaryService.removeService(key, selectedDictionary)) {
            model.addAttribute("id", DELETE);
        } else {
            model.addAttribute("id", NO_DELETE);
        }
        return "action_results/remove_result";
    }
}







