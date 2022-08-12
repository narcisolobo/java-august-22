package com.nlobo.ownersandpets.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "owners")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Please enter first name.")
	@Size(min = 2, max = 45, message = "First name must be between 2 and 45 characters.")
	private String firstName;
	
	@NotEmpty(message = "Please enter last name.")
	@Size(min = 2, max = 45, message = "Last name must be between 2 and 45 characters.")
	private String lastName;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pet> pets; 
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Owner() {}

	public Owner(
			String firstName,
			String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pets = new ArrayList<Pet>();
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
	
}
