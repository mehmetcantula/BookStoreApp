package com.saha.bookstore.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prices")
public class Price extends BaseEntity{
    @Builder
    public Price(Long id, Double price){
        super(id);
        this.price = price;
    }
    @Column(name = "price")
    private Double price;
    @JoinColumn(name="book_id")
    private Book bookId;
    @JoinColumn(name="city_id")
    private City cityId;
}
