package nl.northernlogic.portfoliodashboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Value;

@Table("position")
@Value
public class Position {
    @Id
    Long id;
    String symbol;
    int quantity;
}
