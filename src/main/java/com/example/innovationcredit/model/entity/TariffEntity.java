package com.example.innovationcredit.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tariffs")
public class TariffEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String type;

    @Column
    String interestRate;

    public TariffEntity(long id, String type, String interestRate) {
        this.id = id;
        this.type = type;
        this.interestRate = interestRate;
    }
}
