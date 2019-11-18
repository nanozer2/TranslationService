package com.zero.number.translation.controller;

import com.zero.number.translation.service.TranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class TranslationController implements Serializable {


    @RequestMapping(value = {"/{number}"}, method = {RequestMethod.GET})
    public ResponseEntity<?> convert(@PathVariable Long number){
        String words = TranslationService.convert(number);
        return new ResponseEntity<>(words, HttpStatus.OK);
    }


}
