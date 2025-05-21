package codewithike.demo.models;

import lombok.*;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    private Integer id;
    private String word;
    private Date date;
}
