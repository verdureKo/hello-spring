package hello.hellospring.order.entity;

import javax.persistence.*;

@Entity
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    int price;
    @Column(name = "stock_quantity")
    int StockQuantity;



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }
}
