package com.space.model;

import com.space.validation.DateBetween;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(schema = "cosmoport", name = "ship")
public class ShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Positive
    @Min(1L)
    private Long id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    @NotEmpty(message = "Ship name cannot be empty")
    @NotNull
    private String name;

    @Size(max = 50)
    @Column(name = "planet", length = 50)
    @NotEmpty(message = "Ship planet cannot be empty")
    @NotNull
    private String planet;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ShipType shipType;

    @NotNull
    @DateBetween(minYear = 2800, maxYear = 3019)
    private Date prodDate;


    private Boolean isUsed;

    @DecimalMin("0.01")
    @DecimalMax("0.99")
    @Column(name = "speed", precision = 2)
    @NotNull
    private Double speed;

    @Min(1)
    @Max(9999)
    @NotNull
    private Integer crewSize;

    @Column(name = "rating", precision = 2)
    private Double rating;


    public ShipEntity() {
    }

    public ShipEntity(Long id, String name, String planet, ShipType shipType, Date prodDate, Boolean isUsed, Double speed, Integer crewSize, Double rating) {
        this.id = id;
        this.name = name;
        this.planet = planet;
        this.shipType = shipType;
        this.prodDate = prodDate;
        this.isUsed = isUsed;
        this.speed = speed;
        this.crewSize = crewSize;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ShipEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", shipType=" + shipType +
                ", prodDate=" + prodDate +
                ", isUsed=" + isUsed +
                ", speed=" + speed +
                ", crewSize=" + crewSize +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipEntity)) return false;
        ShipEntity that = (ShipEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(planet, that.planet) &&
                shipType == that.shipType &&
                Objects.equals(prodDate, that.prodDate) &&
                Objects.equals(isUsed, that.isUsed) &&
                Objects.equals(speed, that.speed) &&
                Objects.equals(crewSize, that.crewSize) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, planet, shipType, prodDate, isUsed, speed, crewSize, rating);
    }
}
