package nl.northernlogic.portfoliodashboard;

import lombok.Value;

@Value
public class UpdatePosition {
    String symbol;
    int quantity;
}