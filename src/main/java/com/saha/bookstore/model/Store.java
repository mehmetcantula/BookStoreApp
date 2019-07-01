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
@Table(name = "stores")
public class Store extends BaseEntity{

    @Builder
    public Store(Long id, String storeName){
        super(id);
        this.storeName = storeName;
    }

    @Column(name = "store_name")
    private String storeName;
    @OneToMany
    private Set<Category> categories = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
