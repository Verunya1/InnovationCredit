package com.example.innovationcredit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loan_order")
public class Application {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String order_id;

    @Column
    Long user_id;

    @Column
    Long tariff_id;

    @Column
    Double credit_rating;

    @Column
    String status;

    @Column
    Timestamp time_insert;

    @Column
    Timestamp time_update;

    public Application(long id, String order_id, Long user_id, Long tariff_id, Double credit_rating, String status, Timestamp time_insert, Timestamp time_update) {
        this.id = id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.tariff_id = tariff_id;
        this.credit_rating = credit_rating;
        this.status = status;
        this.time_insert = time_insert;
        this.time_update = time_update;
    }
}
