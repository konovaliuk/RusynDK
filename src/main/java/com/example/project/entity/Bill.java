package com.example.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill", schema = "project")
public class Bill {

    @Id
    private Integer id;
    private Integer sum;
    private Timestamp billDate;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;

    @OneToMany(mappedBy = "request")
    @JsonIgnore
    private List<Request> request;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Room> room;

}