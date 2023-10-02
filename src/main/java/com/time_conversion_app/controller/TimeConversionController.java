package com.time_conversion_app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time_conversion_app.service.TimeConversionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/api/time")
@Api(value = "Time Conversion API", description = "Operations related to time conversion")

public class TimeConversionController {
    @Autowired
    private TimeConversionService timeConversionService;
    @GetMapping("/convert")
    @ApiOperation(value = "Convert time to words", response = String.class)
    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
        try {
            String result = timeConversionService.convertTimeToWords(time);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid time format.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
