package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "keyword")

public class KeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idword;
    @Column(name = "word")
	private String word;
	public KeyWord() {
		
	}
	public KeyWord(String word) {
		super();
		this.word = word;
	}
	public Integer getIdword() {
		return idword;
	}
	public void setIdword(Integer idword) {
		this.idword = idword;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	

}
