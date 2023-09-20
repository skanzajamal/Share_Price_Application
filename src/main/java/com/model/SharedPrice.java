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
    int id;

    @Column(name = "symbol")
    String symbol;

    @Column(name = "name")
    String name;

    @Column(name = "price")
    Double price;

    @Column(name = "exchange")
    String exchange;

    @Column(name = "exchange_short_name")
    String exchangeShortName;

    @Column(name = "type")
    String type;

} //ENDCLASS
