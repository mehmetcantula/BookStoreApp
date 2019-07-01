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
@Table(name = "categories")
public class Category extends BaseEntity{

    @Builder
    public Category(Long id, String categoryName){
        super(id);
        this.categoryName = categoryName;
    }

    @Column(name = "category_name")
    private String categoryName;
    @OneToMany
    private Set<Book> books = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
