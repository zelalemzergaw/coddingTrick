package com.practice.onlinemarket.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String name;
    private String brand;
    private String madeIn;
    private float price;
    private Date manufacturedDate;
}
