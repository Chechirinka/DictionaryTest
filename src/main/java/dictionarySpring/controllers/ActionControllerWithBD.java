//package dictionarySpring.controllers;
//
//import dictionarySpring.dao.DictionaryDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/test")
//public class ActionControllerWithBD {
//
//    private final DictionaryDAO dictionaryDAO;
//
//    @Autowired
//    public ActionControllerWithBD(DictionaryDAO dictionaryDAO) {
//        this.dictionaryDAO = dictionaryDAO;
//    }
//
//    @GetMapping("/check")
//    public String check(Model model) {
//        model.addAttribute("result", DictionaryDAO.read());
//        return "action-bd/check";
//    }
//}
