package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class SharedPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "exchange")
    private String exchange;

    @Column(name = "exchange_short_name")
    private String exchangeShortName;

    @Column(name = "type")
    private String type;

} //ENDCLASS
