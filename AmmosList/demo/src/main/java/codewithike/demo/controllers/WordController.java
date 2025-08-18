package codewithike.demo.controllers;

import codewithike.demo.models.Word;
import codewithike.demo.services.WordServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class WordController {

    @Autowired
    WordServices service;

    @GetMapping
    public List<Word> getAllWords() {
        return this.service.getAllWords();
    }

    @GetMapping("/word")
    public Word getOneWord(){
        return service.getRandomWord();
    }

    @PostMapping
    public Word addWord(@RequestBody Word word){
        return service.createWord(word);
    }
}
