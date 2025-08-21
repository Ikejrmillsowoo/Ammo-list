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
    //Get all words
    @GetMapping
    public List<Word> getAllWords() {
        return this.service.getAllWords();
    }
    //Get one word
    @GetMapping("/word")
    public Word getOneWord(){
        return service.getRandomWord();
    }
    //get all recently added words
    @GetMapping("/recent")
    public List<Word> getRecentlyAddedWords(){
        return service.getRecentWords();
    }
    //Add work to list
    @PostMapping
    public Word addWord(@RequestBody Word word){
        return service.createWord(word);
    }


}
