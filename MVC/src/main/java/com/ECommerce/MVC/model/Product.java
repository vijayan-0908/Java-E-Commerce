package com.ECommerce.MVC.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "alias")
    private String alias;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "image")
    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "vendor_id")
    @ToString.Exclude
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private Category category;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private List<OrderBasket> orderBaskets;

    @Transient
    public String getShortTitle(){
        if(title.length() > 40){
            return  title.substring(0,40).concat("...");
        }
        return title;
    }

    @Transient
    public String getShortAlias(){
        if(alias.length() > 40){
            return alias.substring(0,40).concat("...");
        }
        return alias;
    }

    @Transient
    public String getShortDescription(){
        if(description != null && description.length() > 40){
            return  description.substring(0,40).concat("...");
        }
        return description;
    }
}
