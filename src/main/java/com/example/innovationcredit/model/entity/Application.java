package com.example.innovationcredit.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan_order")
public class Application {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column
    String orderId;

    @Column
    Long userId;

    @Column
    Long tariffId;

    @Column
    Double creditRating;

    @Column
    String status;

    @Column
    Timestamp timeInsert;

    @Column
    Timestamp timeUpdate;
}
