package com.github.lenaHelen17.boot.model;

import lombok.*;
import org.hibernate.annotations.Proxy;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Proxy(lazy = false)
public class Restaurant extends NamedEntity{

    @Column(name = "address", nullable = false)
    @Size(max = 128)
    private String adress;

    public Restaurant(Restaurant u) {
        this(u.id, u.name, u.adress);
    }

    public Restaurant(String adress) {
        this.adress = adress;
    }
    public Restaurant(Integer id, String name, String adress) {
        super(id, name);
        this.adress = adress;
    }

}
