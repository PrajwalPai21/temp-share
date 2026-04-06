package com.tempshare.tempshare_backend.model;
//shows that this is a model class to java

import jakarta.persistence.*; // for jpa annotations @Id, @Entity
import lombok.AllArgsConstructor; //lombok for boiler plate gen
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //maps to a db table
@Data //Lombok annotation that generates getters, setters, toString(), equals(), and hashCode() automatically.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users_table") //Specifies the table name in the database (users). If omitted, JPA uses a default name.
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto generates and increments automatically
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String email;
    private String password; // hash these in the future
}
