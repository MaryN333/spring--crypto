package cz.wz.marysidy.spring_crypto.model;

import java.util.UUID;

public class Crypto {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private String symbol;
//    how not to display data in Postman/JSON
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double price;
    private Double quantity;

    // Constructors
    public Crypto(String name, String symbol, Double price, Double quantity) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public Crypto() {
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
