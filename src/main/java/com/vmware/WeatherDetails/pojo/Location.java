package com.vmware.WeatherDetails.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LOCATION_INFO")
public class Location {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int locationId;
    private float lat;
    private float lon;
    private String city;
    private String state;

    @OneToOne(mappedBy = "location")
    @JsonIgnore
    private Weather weather;
}