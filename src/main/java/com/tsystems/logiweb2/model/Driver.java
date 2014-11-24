package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.Annotation.UniqueNumber;
import com.tsystems.logiweb2.model.enums.DriverStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Entity Driver class
 */
@Entity
@Table(name = "DRIVERS")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, message = "В водительских правах 6 символов!")
    @UniqueNumber(message = "Водитель с таким номером прав уже существует!")
    @Column(name = "LICENSE_NUMBER", unique = true)
    private String licNumber;

    @Size(min = 6, message = "Слишком короткое имя!")
    @Column(name = "NAME")
    private String name;

    @Column(name = "DRIVER_STATUS")
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;

    @ManyToOne()
    @JoinColumn(name = "TRUCK_ID")
    private Truck truck;

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber = licNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "Driver{" +
                ", licNumber='" + licNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
