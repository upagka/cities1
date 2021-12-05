package vip.daur.cities.ui.list;

import java.util.List;

import vip.daur.cities.domain.CitiesRepository;
import vip.daur.cities.domain.City;

public class CitiesListPresenter {

    private CitiesListView view;

    private CitiesRepository repository;

    public CitiesListPresenter(CitiesListView view, CitiesRepository repository) {
        this.view = view;
        this.repository = repository;
    }


    public void refresh() {

        List<City> result = repository.getAllCities();

        view.showCities(result);
    }

}
