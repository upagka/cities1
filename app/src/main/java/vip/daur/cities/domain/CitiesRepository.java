package vip.daur.cities.domain;

import java.util.List;

public interface CitiesRepository {

    List<City> getAllCities();

    void addCity(City city);

    void removeCity(City city);

}
