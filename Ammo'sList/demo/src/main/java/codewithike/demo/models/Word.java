package codewithike.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "WORD_ID")
    private Integer id;
    @Column(name = "WORD")
    private String word;
    @Column(name = "DATE")
    private LocalDate createdAt;
//   private List<Word> wordBank= new ArrayList<>();

    public int getWordLength(){
        return this.getWord().length();
    }

    public char[] toCharArray() {
        return word.toCharArray();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
