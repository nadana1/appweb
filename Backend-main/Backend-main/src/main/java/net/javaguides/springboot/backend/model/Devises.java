package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="devises")
public class Devises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idd;
    @Column(name="currency")
    private String currency;
    @Column(name="acronym")
    private String acronym;
    @Column(name="unit")
    private String unit;
    @Column(name="value")
    private Float value;
    public Devises(){

    }
    public Devises(String currency, String acronym, String unit, Float value){
        super();
        this.acronym=acronym;
        this.currency=currency;
        this.unit=unit;
        this.value=value;

    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getAcronym() {
        return acronym;
    }
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
    
    
}
