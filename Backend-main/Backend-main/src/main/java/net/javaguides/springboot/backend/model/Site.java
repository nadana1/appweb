package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="siteconfirmed")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsite;
    @Column(name="namecompany")
    private String namecompany;
    @Column(name="sitename")
    private String sitename;
    @Column(name="link")
    private String link;
    public Site(){

    }
    public Site(Integer idsite, String namecompany, String sitename, String link) {
        this.idsite = idsite;
        this.namecompany = namecompany;
        this.sitename = sitename;
        this.link = link;
    }
    public Integer getIdsite() {
        return idsite;
    }
    public void setIdsite(Integer idsite) {
        this.idsite = idsite;
    }
    public String getNamecompany() {
        return namecompany;
    }
    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }
    public String getSitename() {
        return sitename;
    }
    public void setSitename(String sitename) {
        this.sitename = sitename;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    
}
