package com.github.lenaHelen17.boot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lenaHelen17.boot.util.DateTimeUtil;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "voting")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"user"})
public class Voting extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    @Column(name = "date_voting", nullable = false, updatable = false)
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String dateVoting = LocalDateTime.now().format(DateTimeUtil.DATE_FORMATTER);

    public Voting(Integer id, User user, Restaurant restaurant) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
    }
}
