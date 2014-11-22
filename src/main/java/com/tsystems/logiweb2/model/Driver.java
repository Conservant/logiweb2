package com.tsystems.logiweb2.model;

import com.tsystems.logiweb2.model.enums.DriverStatus;

import javax.persistence.*;

/**
 * Entity Driver class
 */
@Entity
@Table(name = "DRIVERS")
@NamedQueries({
        @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d"),
        @NamedQuery(name = "Driver.getByLicNumber", query = "SELECT d FROM Driver d WHERE d.licNumber = :licNumber")}
)
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LICENSE_NUMBER")
    private String licNumber;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DRIVER_STATUS")
    @Enumerated(EnumType.STRING)
    private DriverStatus driverStatus;

    @ManyToOne(/*fetch = FetchType.EAGER, cascade = CascadeType.ALL*/)
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
                "id=" + id +
                ", licNumber='" + licNumber + '\'' +
                ", name='" + name + '\'' +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
