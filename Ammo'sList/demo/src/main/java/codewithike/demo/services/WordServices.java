package codewithike.demo.services;

import codewithike.demo.models.Word;
import codewithike.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WordServices {

    @Autowired
    WordRepository repository;

    private Word currentWord;

    public WordServices(WordRepository repository) {
        this.repository = repository;
    }

    public List<Word> getAllWords(){
        return this.repository.findAll();
    }

    public Word getRandomWord(){
        int randNum = repository.findAll().size();
        int rand = (int)(Math.random() * randNum);
        currentWord = getAllWords().get(rand);
        return getAllWords().get(rand);
    }

    public Word createWord(Word word){
        if (word != null) {
            word.setCreatedAt(LocalDate.now()); // Timestamp when saving
            return repository.save(word);
        }
        return null;
    }



}
