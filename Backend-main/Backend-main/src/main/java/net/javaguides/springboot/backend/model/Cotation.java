package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cotation")
public class Cotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcot;
    @Column(name="name")
    private String name;
    @Column(name="opening")
    private Float opening;
    @Column(name="high")
    private Float high;
    @Column(name="low")
    private Float low;
    @Column(name="volume")
    private Float volume;
    @Column(name="variation")
    private Float variation;
    public Cotation(){

    }
    public Cotation(Integer idcot, String name, Float opening, Float high, Float low, Float volume, Float variation) {
        this.idcot = idcot;
        this.name = name;
        this.opening = opening;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.variation = variation;
    }
   
    public Integer getIdcot() {
        return idcot;
    }
    public void setIdcot(Integer idcot) {
        this.idcot = idcot;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getOpening() {
        return opening;
    }
    public void setOpening(Float opening) {
        this.opening = opening;
    }
    public Float getHigh() {
        return high;
    }
    public void setHigh(Float high) {
        this.high = high;
    }
    public Float getLow() {
        return low;
    }
    public void setLow(Float low) {
        this.low = low;
    }
    public Float getVolume() {
        return volume;
    }
    public void setVolume(Float volume) {
        this.volume = volume;
    }
    public Float getVariation() {
        return variation;
    }
    public void setVariation(Float variation) {
        this.variation = variation;
    }
    
    
}
