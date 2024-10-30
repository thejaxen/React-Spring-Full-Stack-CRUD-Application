package com.CRUD.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //lombok /*for reading the values of variables*/
@Setter //lombok /*for updating the values of variables*/
@NoArgsConstructor//lombok
@AllArgsConstructor//lombok
@Entity //JPA //used this to define class as jpa entity
@Table(name = "employees")//JPA //to specify table details

public class Employee {

    @Id //JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY)//JPA
    //automatically increment the primary key
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

}
