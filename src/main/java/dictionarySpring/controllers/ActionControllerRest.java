package dictionarySpring.controllers;

import dictionarySpring.configuration.DictionaryType;
import dictionarySpring.exception.TypeNotFoundException;
import dictionarySpring.model.DictionaryLine;
import dictionarySpring.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/action-rest")
public class ActionControllerRest{
    private final static String NO_EXIST_LANGUAGE = "Error, this language does not exist!";
    private final static String SUCCESS = "Success";
    public final static String ERROR = "Error";
    private final static String DELETE = "Delete";
    private final static String NO_DELETE = "No delete";
    private final DictionaryService dictionaryService;
    private DictionaryType selectedDictionary;

    @Autowired
    public ActionControllerRest(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("read")
    @ResponseBody
    public ResponseEntity<?> read(@RequestParam(value = "dictionaryId") int id) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            return new ResponseEntity<>(NO_EXIST_LANGUAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(dictionaryService.readServiceRest(selectedDictionary), HttpStatus.OK);
    }

    @PostMapping("write")
    @ResponseBody
    public ResponseEntity<?> write(@RequestParam(value = "dictionaryId") int id,
                                   @RequestBody DictionaryLine dictionaryLine) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            return new ResponseEntity<>(NO_EXIST_LANGUAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (dictionaryService.addService(dictionaryLine.getKey(), dictionaryLine.getValue(), selectedDictionary)) {
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<>(ERROR, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestParam(value = "dictionaryId") int id,
                                 @RequestParam(value = "key") String key) {
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            return new ResponseEntity<>(NO_EXIST_LANGUAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return dictionaryService.searchServiceRest(key, selectedDictionary);
    }

    @PostMapping("remove")
    @ResponseBody
    public ResponseEntity<?> remove(@RequestParam(value = "dictionaryId") int id,
                                    @RequestParam(value = "key") String key){
        try {
            selectedDictionary = DictionaryType.getDictionaryTypeByNumber(id);
        } catch (TypeNotFoundException e) {
            return new ResponseEntity<>(NO_EXIST_LANGUAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (dictionaryService.removeService(key, selectedDictionary)) {
            return new ResponseEntity<>(DELETE, HttpStatus.OK);
        }
        return new ResponseEntity<>(NO_DELETE, HttpStatus.BAD_REQUEST);
    }
}