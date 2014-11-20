package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.model.enums.CapacityClass;

import javax.persistence.*;
import java.util.List;

/**
 * Entity Truck class
 */
@Entity
@Table(name = "TRUCKS")
@NamedQueries({
        @NamedQuery(name = "Truck.allTrucks", query = "SELECT t FROM Truck t"),
        @NamedQuery(name = "Truck.getByRegNumber", query = "SELECT t FROM Truck t WHERE t.regNumber = :regNumber")}
)
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REG_NUMBER")
    private String regNumber;

    @Column(name = "REQ_NUM_OF_DRIVERS")
    private Integer requiredNumberOfDrivers;

    @Column(name = "CAPACITY")
    private Double capacity;

    @Column(name = "CAPACITY_CLASS")
    @Enumerated(EnumType.STRING)
    private CapacityClass capacityClass;

    @OneToMany(mappedBy = "truck")
    private List<Driver> drivers;

    public Truck() {
    }

    public Truck(String regNumber, Integer requiredNumberOfDrivers, Double capacity) {
        this.regNumber = regNumber;
        this.requiredNumberOfDrivers = requiredNumberOfDrivers;
        this.capacity = capacity;
        if (capacity < 0) {
            setCapacityClass(CapacityClass.SMALL);
        } else if (capacity > 5) {
            setCapacityClass(CapacityClass.LARGE);
        } else {
            setCapacityClass(CapacityClass.MEDIUM);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Integer getRequiredNumberOfDrivers() {
        return requiredNumberOfDrivers;
    }

    public void setRequiredNumberOfDrivers(Integer requiredNumberOfDrivers) {
        this.requiredNumberOfDrivers = requiredNumberOfDrivers;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public CapacityClass getCapacityClass() {
        return capacityClass;
    }

    public void setCapacityClass(CapacityClass capacityClass) {
        this.capacityClass = capacityClass;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", RegNumber='" + regNumber + '\'' +
                ", requiredNumberOfDrivers=" + requiredNumberOfDrivers +
                ", capacity=" + capacity +
                ", capacityClass=" + capacityClass +
                "}";
    }
}
