package com.nlobo.ownersandpets.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pets")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Please enter pet name.")
	@Size(min = 2, max = 45, message = "Pet name must be between 2 and 45 characters.")
	private String petName;

	@NotEmpty(message = "Please enter pet type.")
	@Size(min = 2, max = 45, message = "Pet type must be between 2 and 45 characters.")
	private String petType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Pet() {}
    
    public Pet(String petName, String petType, Owner owner) {
    	this.petName = petName;
    	this.petType = petType;
    	this.owner = owner;
    }

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public Long getId() {
		return id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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
