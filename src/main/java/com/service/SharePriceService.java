package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.config.KafkaProducer;
import com.model.FilterTable;
import com.model.SharedPrice;
import com.repository.FilterRepository;
import com.repository.SharedPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class SharePriceService {

    @Autowired
    public SharedPriceRepository sharedPriceRepository;

    @Autowired
    public FilterRepository filterRepository;

    private final KafkaProducer kafkaProducer;

    public SharePriceService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public SharedPrice insert(SharedPrice sharedPrice) {

        SharedPrice prices = sharedPriceRepository.save(sharedPrice);
        return prices;
    }

    public List<SharedPrice> getList() throws IOException {

        final String uri = "https://financialmodelingprep.com/api/v3/stock/list?apikey=0dbbd75a650040eaab859d3383bf3395";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<SharedPrice> sharedPriceList  = Arrays.asList(mapper.readValue(result, SharedPrice[].class));
        List<FilterTable> filterTables = filterRepository.findAll();

        for (SharedPrice sharedPrice : sharedPriceList) {
            for(FilterTable f1: filterTables){
                if(f1.getSymbol().equalsIgnoreCase(sharedPrice.getSymbol())){
                    SharedPrice sharedPriceDto = new SharedPrice();
                    sharedPriceDto.setSymbol(sharedPrice.getSymbol());
                    sharedPriceDto.setName(sharedPrice.getName());
                    sharedPriceDto.setPrice(sharedPrice.getPrice());
                    sharedPriceDto.setExchange(sharedPrice.getExchange());
                    sharedPriceDto.setExchangeShortName(sharedPrice.getExchangeShortName());
                    sharedPriceDto.setType(sharedPrice.getType());
                    sharedPriceRepository.save(sharedPriceDto);
                    kafkaProducer.sendMessage("retrieved stock price of " + sharedPrice.getSymbol());
                }
            }
        }
        return sharedPriceList;
    }

    public List<SharedPrice> getAllRecord() {
        return sharedPriceRepository.findAll();
    }

} //ENDCLASS