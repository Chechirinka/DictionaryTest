package dictionarySpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static dictionarySpring.controllers.ActionController.ID;

@Controller
@RequestMapping()
public class ActionMenuController {

    @GetMapping("/add-menu")
    public String menuAddPair(@RequestParam(name = "dictionaryId") int dictionaryId,
                              Model model){
        model.addAttribute(ID, dictionaryId);
        return "action_menu/add_menu";
    }

    @GetMapping("/search-menu")
    public String menuSearchPair(@RequestParam(name = "dictionaryId") int dictionaryId,
                                 Model model){
        model.addAttribute(ID, dictionaryId);
        return "action_menu/search_menu";
    }

    @GetMapping("/remove-menu")
    public String menuDeletePair(@RequestParam(name = "dictionaryId") int dictionaryId,
                                 Model model){
        model.addAttribute(ID, dictionaryId);
        return "action_menu/remove_menu";
    }

    @GetMapping("/work-lib-menu")
    public String workWithLibrary(@RequestParam(name = "dictionaryId") int dictionaryId, Model model) {
        model.addAttribute(ID, dictionaryId);
        return "action_menu/action_library_menu";
    }
}

