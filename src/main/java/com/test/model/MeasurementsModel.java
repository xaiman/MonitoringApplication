package com.test.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class MeasurementsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String userName;

    @Column
    @NotNull
    @Min(0)
    private long gas;

    @Column
    @NotNull
    @Min(0)
    private long coldWater;

    @Column
    @NotNull
    @Min(0)
    private long hotWater;
}
