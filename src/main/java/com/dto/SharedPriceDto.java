package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SharedPriceDto {

    private String symbol;
    private String name;
    private Double price;
    private String exchange;
    private String exchangeShortName;
    private String type;

} //ENDCLASS
