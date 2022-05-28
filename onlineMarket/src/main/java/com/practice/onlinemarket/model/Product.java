package com.practice.onlinemarket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Made_In")
    private String madeIn;
    @Column(name = "Price")
    private float price;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date manufacturedDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    static final long serialVersionUID = 42L;
}
