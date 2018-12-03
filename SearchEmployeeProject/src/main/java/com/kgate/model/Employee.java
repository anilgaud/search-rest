package com.kgate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employee123")

public class Employee implements Serializable {

    private static final long serialVersionUID = -3465813074586302847L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_employee_skill",
            joinColumns = {
                @JoinColumn(name = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "skill_Id")})
    private List<Skill> listSkill = new ArrayList<Skill>();

    @Transient
    private List<String> skills = new ArrayList<>();

    @Transient
    private String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public List<Skill> getListSkill() {
        return listSkill;
    }

    public void setListSkill(List<Skill> listSkill) {
        this.listSkill = listSkill;
    }

    @Column
    @NotEmpty(message = "Please enter your name.")
    private String name;

    @Column
    @NotEmpty(message = "Please enter your email.")
    @Email
    private String email;

    @Column
    private String address;

    @Column
    private String telephone;
    
   /* @Transient
    private String otp;

    public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}*/

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", listSkill=" + listSkill + ", skills=" + skills + ", otp=" + otp + ", name=" + name + ", email=" + email + ", address=" + address + ", telephone=" + telephone + '}';
    }

}
