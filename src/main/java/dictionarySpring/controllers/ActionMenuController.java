package dictionarySpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/work")
public class ActionMenuController {

    @GetMapping("/add-menu")
    public String menuAddPair(@RequestParam(name = "id") Long id,
                              Model model){
        model.addAttribute("id", id);
        return "action_menu/add_menu";
    }

    @GetMapping("/search-menu")
    public String menuSearchPair(@RequestParam(name = "id") Long id,
                                 Model model){
        model.addAttribute("id", id);
        return "action_menu/search_menu";
    }

    @GetMapping("/remove-menu")
    public String menuDeletePair(@RequestParam(name = "id") Long id,
                                 Model model){
        model.addAttribute("id", id);
        return "action_menu/remove_menu";
    }

    @GetMapping("/start")//Выбор языка
    public String menuLibraries() {
        return "action_menu/choose_language_menu";
    }

    @GetMapping("/work-lib-menu")//Какие действия мы хотим выполнить
    public String workWithLibrary(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("id", id);
        return "action_menu/action_library_menu";
    }

}

