package com.sample_project.userApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String street;
    String city;
    //    @OneToOne(cascade = {CascadeType.ALL},mappedBy = "address")
    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)
    Geo geo;

    @OneToOne
    User user;


}