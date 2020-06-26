package com.edureka.hotelservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Entity
//@Table(name = "order_table")
//@Data
@Getter @Setter
//@Builder
@NoArgsConstructor
@ToString
public class Order /*implements Serializable*/ {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
//    @Enumerated(EnumType.STRING)
    private String orderState;
//    @Enumerated(EnumType.STRING)
    private String orderStatus;
    private String sourceLocation;
    private String destinationLocation;

    private BigDecimal amount;

    private LocalDate bookingDate;
}
