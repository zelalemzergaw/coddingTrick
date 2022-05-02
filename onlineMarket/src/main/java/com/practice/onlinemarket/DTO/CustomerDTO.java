package com.practice.onlinemarket.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.onlinemarket.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private int age;
    private Product product ;
}
