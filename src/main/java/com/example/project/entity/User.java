package com.example.project.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "users", schema = "project")
@Data

@NoArgsConstructor
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private String surname;
private String login;
private String phone;
private String role;


@OneToMany(mappedBy = "client")
@JsonIgnore
private List <Bill> clientBill;

@OneToMany(mappedBy = "admin")
@JsonIgnore
private List <Bill> adminBill;

public User(String name, String surname, String login, String phone, String role){
this.name = name;
this.surname = surname;
this.login = login;
this.phone = phone;
this.role = role;
}
}