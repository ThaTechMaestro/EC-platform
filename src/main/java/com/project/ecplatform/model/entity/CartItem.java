package com.project.ecplatform.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private Integer id;

    private int quantity;

    @ManyToOne(fetch= FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch= FetchType.LAZY)
    private Item item;


}
