package codewithike.demo.services;

import codewithike.demo.models.Word;
import codewithike.demo.repository.UsersRepository;
import codewithike.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class WordServices {

    @Autowired
    WordRepository repository;

    public WordServices(WordRepository repository) {
        this.repository = repository;
    }

    public List<Word> getAllWords(){
        return this.repository.findAll();
    }

    public Word getRandomWord(){
        int randNum = repository.findAll().size();
        int rand = (int)(Math.random() * randNum);
        return getAllWords().get(rand);
    }

    public void createWord(Word word){
        if (word != null) {
            word.setCreatedAt(LocalDate.now()); // Timestamp when saving
            repository.save(word);
        }
    }
}
