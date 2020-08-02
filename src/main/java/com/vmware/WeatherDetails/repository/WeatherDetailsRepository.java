package com.vmware.WeatherDetails.repository;

import com.vmware.WeatherDetails.pojo.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherDetailsRepository extends JpaRepository<Weather, Integer> {

    @Override
    @Query
    List<Weather> findAll();

    @Query
    List<Weather> findByDate(LocalDate date);

    //== For Unit Testing==
    @Query
    Weather findByWeatherId(Integer id);

}
