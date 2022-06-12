package com.practice.onlinemarket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "Date_Of_Manufacture")
    private Date manufacturedDate;
    @Column(name="Active")
    private boolean active;
    @Column(name="Amount_In_Stock")
    private int unitsInStock;
    @Column(name="Image_Url")
    private String imageUrl;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    static final long serialVersionUID = 42L;
}
