package com.vmware.WeatherDetails;

import com.vmware.WeatherDetails.pojo.Location;
import com.vmware.WeatherDetails.pojo.Weather;
import com.vmware.WeatherDetails.repository.WeatherDetailsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherDetailsApplicationTests {

	@Autowired
	private WeatherDetailsRepository weatherDetailsRepository;

	@Test
	public void testSaveWeather() throws ParseException {
		LocalDate testDate = LocalDate.parse("2020-07-03");
		Weather mockWeather = new Weather(6, testDate, getMockTemperatures(),getMockLocation());
		weatherDetailsRepository.save(mockWeather);
		Weather weatherInDb = weatherDetailsRepository.findByWeatherId(6);
		assertNotNull(weatherInDb.getId());
		assertEquals(weatherInDb.getDate(), mockWeather.getDate());
		assertEquals(mockWeather.getLocation().getCity(), weatherInDb.getLocation().getCity());
	}

	private List<Float> getMockTemperatures() {
		List<Float> testFloat = new ArrayList<Float>();
		testFloat.add(Float.parseFloat("34.5"));
		testFloat.add(Float.parseFloat("36.5"));
		testFloat.add(Float.parseFloat("37.5"));
		testFloat.add(Float.parseFloat("38.5"));
		testFloat.add(Float.parseFloat("39.5"));
		testFloat.add(Float.parseFloat("40.5"));
		return testFloat;
	}

	private Location getMockLocation() {
		Location location = new Location();
		location.setLat(32.45f);
		location.setLon(89.45f);
		location.setCity("Abc");
		location.setState("NK");
		return location;
	}
}
