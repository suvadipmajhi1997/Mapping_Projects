package com.geekster.Employee.address.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Street cannot be blank")
    private String street;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Size(min = 2, max = 10, message = "State must be 2 characters long")
    private String state;

    @NotBlank(message = "Zipcode cannot be blank")
    @Pattern(regexp = "\\d{6}", message = "Zipcode must be 6 digits long")
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;
}
