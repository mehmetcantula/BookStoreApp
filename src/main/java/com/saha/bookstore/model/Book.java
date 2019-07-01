package com.saha.bookstore.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    @Builder
    public Book(Long id, String name, Category category){
        super(id);
        this.name = name;
        this.category = category;
    }

    @Column(name = "name")
    private String name;

    //@Column(name = "category")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
