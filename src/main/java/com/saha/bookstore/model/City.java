package com.saha.bookstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    @Builder
    public City(Long id, String cityName, Set<Store> stores){
        super(id);
        this.cityName = cityName;
        this.stores = stores;

    }
    @Column(name = "city_name")
    private String cityName;
    @OneToMany
    private Set<Store> stores = new HashSet<>();


}
