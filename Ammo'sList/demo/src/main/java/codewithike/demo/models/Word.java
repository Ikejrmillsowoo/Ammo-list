package codewithike.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    @Column(name = "Word")
    private String word;
    @Column(name = "Date")
    private LocalDate createdAt;
//   private List<Word> wordBank= new ArrayList<>();
}
