import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private String name;
    private Date releaseDate;
    private float rating;
    private double cost;
    private String description;
    private Date creationDate;
}
