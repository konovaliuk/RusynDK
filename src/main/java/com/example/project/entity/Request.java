package com.example.project.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Year;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Request", schema = "project")
@Data
@NoArgsConstructor
public class Request {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")
private Integer id;
private Timestamp checkin;
private Timestamp checkout;
private Integer places;
private String apartclass;

@ManyToOne
@JoinColumn(name="bill_id", referencedColumnName="id")
private Bill bill;

@ManyToOne
@JoinColumn(name="client_id", referencedColumnName="id")
private User client;


public Request(String apartclass, Integer places, Timestamp checkin, Timestamp checkout) {
this.apartclass = apartclass;
this.places = places;
this.checkin = checkin;
this.checkout = checkout;
}
}

