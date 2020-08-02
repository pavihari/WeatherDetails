package com.vmware.WeatherDetails.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WEATHER_INFO")
@NamedQueries({
        @NamedQuery(name = "Weather.findAll", query = "select w from Weather w order by w.id"),
        @NamedQuery(name = "Weather.findByDate", query = "select w from Weather w where w.date=:date"),
        @NamedQuery(name = "Weather.findByWeatherId", query = "select w from Weather w where w.id=:id")
})
public class Weather {

    @Id
    private Integer id;
    private LocalDate date;
    @ElementCollection
    private List<Float> temperature = new ArrayList<>(24);

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "locationId", nullable = false)
    private Location location;

}
