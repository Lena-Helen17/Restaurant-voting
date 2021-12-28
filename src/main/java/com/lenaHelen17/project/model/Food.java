package com.lenaHelen17.project.model;

import com.lenaHelen17.project.util.DateTimeUtil;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "restaurants_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurants restaurants;

    @Column(name = "food_name")
    @Size(max = 128)
    @NotNull
    private String foodName;

    @Column(name = "price", nullable = false)
    @NotNull
    private Double price;

    @Column(name = "date_food", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDateTime dateTime;
}
