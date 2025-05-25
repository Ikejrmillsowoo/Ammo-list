package codewithike.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@Getter
@Setter
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
}
