package com.vmware.WeatherDetails.controller;

import com.vmware.WeatherDetails.Util;
import com.vmware.WeatherDetails.pojo.Weather;
import com.vmware.WeatherDetails.repository.WeatherDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherDetailsRepository weatherDetailsRepository;


    //== Adding new Weather information ==
    @PostMapping(value = "/weather", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> addWeatherInfo(@RequestBody Weather weather) {
        if (weatherDetailsRepository.existsById(weather.getId())) {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
        weatherDetailsRepository.save(weather);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    //== Get all weather information and sort in ascending order based on ID==
    @GetMapping(value = "/weather", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> getWeatherInfo() {
        return weatherDetailsRepository.findAll();

    }

    //== Get weather information by date ==
    @GetMapping(value = "/weatherByDate", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Weather> getWeatherInfoByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return weatherDetailsRepository.findByDate(date);
    }

    //== Erase all weather information ==

    @DeleteMapping(value = "/erase")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String deleteAllRecords() {
        weatherDetailsRepository.deleteAll();
        return "All Records are Successfully Deleted";
    }
}
