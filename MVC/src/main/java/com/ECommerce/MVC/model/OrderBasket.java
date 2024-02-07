package com.ECommerce.MVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "order_basket")
public class OrderBasket {
    private int id;
    private Product product;
    private User user;
    private int quantity;
    
}
