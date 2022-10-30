package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter

public class Payment extends BaseModel{
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Date timeOfPayment;
    private Double amount;
    private String referenceId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Ticket ticket;
}
