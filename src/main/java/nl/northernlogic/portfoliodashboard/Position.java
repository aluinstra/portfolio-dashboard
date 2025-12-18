package nl.northernlogic.portfoliodashboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Value;

@Table
@Value
public class Position {

    @Id
    private Long id;

    private String symbol;
    private int quantity;
}
