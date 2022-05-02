package com.practice.onlinemarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long customerId;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="Password")
    private String password;
    @Column(name="Age")
    private int age;
    @Column(name="phoneNumber")
    private long phoneNumber;
    @OneToOne(cascade=CascadeType.ALL)
    private Product product ;
}
