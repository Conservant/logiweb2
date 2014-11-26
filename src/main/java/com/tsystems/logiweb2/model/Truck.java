package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.Annotation.UniqueNumber;
import com.tsystems.logiweb2.model.enums.CapacityClass;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Entity Truck class
 */
@Entity
@Table(name = "TRUCKS")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @NotBlank(message = "Не может быть пустым")
    @UniqueNumber(message = "Грузовик с таким номером уже существует!")
    @Pattern(regexp = "[A-Z]{1}[0-9]{3}[A-Z]{2}",
             message = "Неверно указан номер")
    @Column(name = "REG_NUMBER", unique = true)
    private String regNumber;

//    @NotBlank(message = "Не может быть пустым")
    @Min(value = 1, message = "Число водителей не может быть меньше 1")
    @Column(name = "REQ_NUM_OF_DRIVERS")
    private Integer requiredNumberOfDrivers;

//    @NotBlank(message = "Не может быть пустым")
    @DecimalMin(value = "0.5", message = "Слишком маленькая грузоподъемность")
    @DecimalMax(value = "15", message = "Слишком большая грузоподъемность")
    @Column(name = "CAPACITY")
    private Double capacity;

    @Column(name = "CAPACITY_CLASS")
    @Enumerated(EnumType.STRING)
    private CapacityClass capacityClass;

    @OneToOne(mappedBy = "truck")
    private Order order;

    @OneToMany(mappedBy = "truck")
    private List<Driver> drivers;

    public Truck() {
    }

    public Truck(String regNumber, Integer requiredNumberOfDrivers, Double capacity) {
        this.regNumber = regNumber;
        this.requiredNumberOfDrivers = requiredNumberOfDrivers;
        this.capacity = capacity;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
                ", RegNumber='" + regNumber + '\'' +
                ", requiredNumberOfDrivers=" + requiredNumberOfDrivers +
                ", capacity=" + capacity +
                "}";
    }
}
