package com.saha.bookstore.services.SpringDataJPA;

import com.saha.bookstore.model.Store;
import com.saha.bookstore.repositories.StoreRepository;
import com.saha.bookstore.services.StoreService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StoreServiceSDJPA implements StoreService {

    private StoreRepository storeRepository;

    public StoreServiceSDJPA(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Set<Store> findAll() {
        Set<Store> stores = new HashSet<>();
        storeRepository.findAll().forEach(stores::add);
        return stores;
    }

    @Override
    public Store findById(Long aLong) {
        return storeRepository.findById(aLong).orElse(null);
    }

    @Override
    public Store save(Store object) {
        return storeRepository.save(object);
    }

    @Override
    public void delete(Store object) {
        storeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        storeRepository.deleteById(aLong);
    }
}
