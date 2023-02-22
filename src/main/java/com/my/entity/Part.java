package com.my.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PartId.class)
public class Part {
    @Id
    private String manufacturer;
    @Id
    private String article;
    private String description;
    private Integer price;
    private Integer qtyOnHand;

    public Part() {
    }

    public Part(String manufacturer, String article, String description, Integer price, Integer qtyOnHand) {
        this.manufacturer = manufacturer;
        this.article = article;
        this.description = description;
        this.price = price;
        this.qtyOnHand = qtyOnHand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
