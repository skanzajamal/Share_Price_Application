package com.controller;

import com.model.SharedPrice;
import com.service.SharePriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/stockPrices")
public class SharedPriceController {

    private final SharePriceService sharePriceService;

    public SharedPriceController(SharePriceService sharePriceService) {
        this.sharePriceService = sharePriceService;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody SharedPrice sharedPrice) throws Exception{
        try {
            SharedPrice price = sharePriceService.insert(sharedPrice);
            return new ResponseEntity<SharedPrice>(price, HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception(ex.getCause());
        }
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SharedPrice> getList() {
        return sharePriceService.getAllRecord();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SharedPrice>> getSharedPriceList() throws IOException {
        List<SharedPrice> sharedPrices = sharePriceService.getList();
        return new ResponseEntity<List<SharedPrice>>(sharedPrices, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id){
        sharePriceService.delete(id);
    }

} //ENDCLASS