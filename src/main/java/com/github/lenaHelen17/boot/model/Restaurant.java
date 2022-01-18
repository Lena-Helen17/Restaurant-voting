package com.github.lenaHelen17.boot.model;

import lombok.*;
import org.hibernate.annotations.Proxy;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Proxy(lazy = false)
public class Restaurant extends NamedEntity implements Serializable {

    @Column(name = "address", nullable = false)
    @Size(max = 128)
    private String adress;

}
