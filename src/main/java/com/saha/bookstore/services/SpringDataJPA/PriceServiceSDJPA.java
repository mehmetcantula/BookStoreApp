package com.saha.bookstore.services.SpringDataJPA;

import com.saha.bookstore.model.Price;
import com.saha.bookstore.repositories.PriceRepository;
import com.saha.bookstore.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PriceServiceSDJPA implements PriceService {

    private PriceRepository priceRepository;

    public PriceServiceSDJPA(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Set<Price> findAll() {
        Set<Price> prices = new HashSet<>();
        priceRepository.findAll().forEach(prices::add);
        return prices;
    }

    @Override
    public Price findById(Long aLong) {
        return priceRepository.findById(aLong).orElse(null);
    }

    @Override
    public Price save(Price object) {
        return priceRepository.save(object);
    }

    @Override
    public void delete(Price object) {
        priceRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        priceRepository.deleteById(aLong);
    }
}
