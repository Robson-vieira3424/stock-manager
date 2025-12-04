package com.StockManager.Model.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private long quantity;
    private long min;

    public ProductDTO(long quantity, long min, String name) {
        this.quantity = quantity;
        this.min = min;
        this.name = name;
    }

    public ProductDTO(){}

    public long getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public long getMin() {
        return min;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setMin(long min) {
        this.min = min;
    }
}