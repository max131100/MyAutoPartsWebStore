package com.my.entity;

import java.io.Serializable;
import java.util.Objects;

public class PartId implements Serializable {
    private String manufacturer;
    private String article;

    public PartId() {
    }

    public PartId(String manufacturer, String article) {
        this.manufacturer = manufacturer;
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PartId partId)) return false;
        return manufacturer.equals(partId.manufacturer) && article.equals(partId.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, article);
    }
}
