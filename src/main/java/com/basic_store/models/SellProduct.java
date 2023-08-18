package com.basic_store.models;

import javax.persistence.*;

@Entity
public class SellProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private User seller;

    private String filename;

    public String getFilename() {
        return filename;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public SellProduct() {
    }
    public SellProduct(Long id, String type, User seller, Long price) {
        this.id = id;
        this.type = type;
        this.seller = seller;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
