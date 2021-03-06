package com.practice.onlinemarket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
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
    private String phoneNumber;
    @OneToOne(cascade=CascadeType.ALL)
    private Product product ;
    static final long serialVersionUID = 42L;
}
