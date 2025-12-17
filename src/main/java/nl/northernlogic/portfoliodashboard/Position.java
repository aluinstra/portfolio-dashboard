package nl.northernlogic.portfoliodashboard;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("positions")
public class Position {

    @Id
    private Long id;

    private String symbol;
    private int quantity;

    public Position() {
    }

    public Position(String symbol, int quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }
}
