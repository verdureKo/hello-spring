package hello.hellospring.domain.order.entity;


import hello.hellospring.domain.order.entity.Item;
import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @JoinColumn(name="orders_id")
    @ManyToOne
    hello.hellospring.order.entity.Orders orders;
    @JoinColumn(name = "item_id")
    @ManyToOne
    Item item;
    @Column(name="order_price")
    int orderPrice;
    int count;

}
