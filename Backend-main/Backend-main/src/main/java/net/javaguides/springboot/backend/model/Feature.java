package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idf;
    @Column(name="namef")
	private String namef;
    @Column(name="rating")
	private Integer rating;
    @Column(name="pondiration")
	private Integer pondiration;
    @Column(name="fluctuation")
	private Integer fluctuation;
	public Feature(){
		
	}
	public Feature(String namef,Integer rating,Integer pondiration, Integer fluctuation) {
		super();
		this.fluctuation = fluctuation;
		this.namef = namef;
		this.pondiration = pondiration;
		this.rating = rating;
		
	}
	public String getNamef() {
		return namef;
	}
	public void setNamef(String namef) {
		this.namef = namef;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getPondiration() {
		return pondiration;
	}
	public void setPondiration(Integer pondiration) {
		this.pondiration = pondiration;
	}
	public Integer getFluctuation() {
		return fluctuation;
	}
	public void setFluctuation(Integer fluctuation) {
		this.fluctuation = fluctuation;
	}
	public Integer getIdf() {
		return idf;
	}
	public void setIdf(Integer idf) {
		this.idf = idf;
	}
	

}
