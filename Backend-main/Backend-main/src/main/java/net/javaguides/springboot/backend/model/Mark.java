package net.javaguides.springboot.backend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmark;
    @Column(name="idc")
    private Integer idc;
    @Column(name="namec")
    private String namec;
    @Column(name="date")
    private String date;
    @Column(name="colsure")
    private Float closure;
    @Column(name="variation")
    private Float variation;
    @Column(name="mark")
    private Float mark;
    @Column(name="descision")
    private Integer descision;
    public Mark(){

    }
    public Mark(Integer idc,String namec,String date,Float closure,Float variation,Float mark,Integer descision){
        super();
        this.closure=closure;
        this.date=date;
        this.descision=descision;
        this.idc=idc;
        this.mark=mark;
        this.namec=namec; 
        this.variation=variation;
    }
    public Integer getIdc() {
        return idc;
    }
    public void setIdc(Integer idc) {
        this.idc = idc;
    }
    public String getNamec() {
        return namec;
    }
    public void setNamec(String namec) {
        this.namec = namec;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Float getClosure() {
        return closure;
    }
    public void setClosure(Float closure) {
        this.closure = closure;
    }
    public Float getVariation() {
        return variation;
    }
    public void setVariation(Float variation) {
        this.variation = variation;
    }
    public Float getMark() {
        return mark;
    }
    public void setMark(Float mark) {
        this.mark = mark;
    }
    public Integer getDescision() {
        return descision;
    }
    public void setDescision(Integer descision) {
        this.descision = descision;
    }
    
}
