package com.lenaHelen17.project.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurants extends BaseEntity implements Serializable {

    @Column(name = "name", nullable = false, unique = true)
    @Size(max = 128)
    private String name;
}
