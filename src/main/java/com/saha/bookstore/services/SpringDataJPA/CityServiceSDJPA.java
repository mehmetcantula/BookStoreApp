package com.saha.bookstore.services.SpringDataJPA;

import com.saha.bookstore.model.City;
import com.saha.bookstore.repositories.CityRepository;
import com.saha.bookstore.services.CityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CityServiceSDJPA implements CityService {

    private CityRepository cityRepository;

    public CityServiceSDJPA(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Set<City> findAll() {
        Set<City> cities = new HashSet<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }

    @Override
    public City findById(Long aLong) {
        return cityRepository.findById(aLong).orElse(null);
    }

    @Override
    public City save(City object) {
        return cityRepository.save(object);
    }

    @Override
    public void delete(City object) {
        cityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        cityRepository.deleteById(aLong);
    }
}
