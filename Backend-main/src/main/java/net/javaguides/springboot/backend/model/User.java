package net.javaguides.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "role")
    private Integer role;
    @Column(name = "dateofbirth")
    private String dateofbirth;
    @Column(name = "phonenumber")
    private long phonenumber;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;

    public User() {

    }

    public User(String firstname, String lastname, int role, String dateofbirth, long phonenumber, String mail,
            String password) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.dateofbirth = dateofbirth;
        this.phonenumber = phonenumber;
        this.mail = mail;
        this.password = password;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "users{" +
                "iduser=" + iduser +
                ", phonenumber=" + phonenumber + " " +
                ", mail='" + mail + " " +
                '}';
    }

    public Object getEmailId() {
        return null;
    }

}
