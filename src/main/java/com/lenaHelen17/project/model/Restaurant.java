package com.lenaHelen17.project.model;

import com.lenaHelen17.project.util.DateTimeUtil;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity implements Serializable {

    @Column(name = "name_restaurant", nullable = false)
    @Size(max = 128)
    private String nameRestuarant;

    @Column(name = "food_name_one")
    @Size(max = 128)
    @NotNull
    private String foodNameOne;

    @Column(name = "price_one", nullable = false)
    @NotNull
    private Double priceOne;

    @Column(name = "food_name_two")
    @Size(max = 128)
    @NotNull
    private String foodNamTwo;

    @Column(name = "price_two", nullable = false)
    @NotNull
    private Double priceTwo;

    @Column(name = "food_name_three")
    @Size(max = 128)
    private String foodNameThree;

    @Column(name = "price_three")
    private Double priceThree;

    @Column(name = "food_name_four")
    @Size(max = 128)
    private String foodNameFour;

    @Column(name = "price_four")
    private Double priceFour;

    @Column(name = "food_name_five")
    @Size(max = 128)
    private String foodNameFive;

    @Column(name = "price_five")
    private Double priceFive;

    @Column(name = "date_menu")
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDate dateMenu;

    public Restaurant(String nameRestuarant, String foodNameOne, Double priceOne, String foodNamTwo, Double priceTwo, LocalDate dateMenu) {
        this.nameRestuarant = nameRestuarant;
        this.foodNameOne = foodNameOne;
        this.priceOne = priceOne;
        this.foodNamTwo = foodNamTwo;
        this.priceTwo = priceTwo;
        this.dateMenu = dateMenu;
    }

    public Restaurant(String nameRestuarant, String foodNameOne, Double priceOne, String foodNamTwo, Double priceTwo, String foodNameThree, Double priceThree, String foodNameFour, LocalDate dateMenu) {
        this.nameRestuarant = nameRestuarant;
        this.foodNameOne = foodNameOne;
        this.priceOne = priceOne;
        this.foodNamTwo = foodNamTwo;
        this.priceTwo = priceTwo;
        this.foodNameThree = foodNameThree;
        this.priceThree = priceThree;
        this.foodNameFour = foodNameFour;
        this.dateMenu = dateMenu;
    }

    public Restaurant(String nameRestuarant, String foodNameOne, Double priceOne, String foodNamTwo, Double priceTwo, String foodNameThree, Double priceThree, String foodNameFour, Double priceFour, LocalDate dateMenu) {
        this.nameRestuarant = nameRestuarant;
        this.foodNameOne = foodNameOne;
        this.priceOne = priceOne;
        this.foodNamTwo = foodNamTwo;
        this.priceTwo = priceTwo;
        this.foodNameThree = foodNameThree;
        this.priceThree = priceThree;
        this.foodNameFour = foodNameFour;
        this.priceFour = priceFour;
        this.dateMenu = dateMenu;
    }
}
