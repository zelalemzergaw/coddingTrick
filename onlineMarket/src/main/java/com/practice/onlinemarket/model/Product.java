package com.practice.onlinemarket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Brand")
    private String brand;
    @Column(name = "Made_In")
    private String madeIn;
    @Column(name ="Price" )
    private float price;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date manufacturedDate;
}