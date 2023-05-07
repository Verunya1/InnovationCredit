package com.example.innovationcredit.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tariff_id")
public class TariffEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String type;

    @Column
    String interest_rate;

    public TariffEntity(long id, String type, String interest_rate) {
        this.id = id;
        this.type = type;
        this.interest_rate = interest_rate;
    }
}
