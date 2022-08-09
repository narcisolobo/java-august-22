package com.nlobo.lakersroster.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lakers")
public class Laker {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, max = 45)
    private String firstName;
    
    @NotNull
    @Size(min = 2, max = 45)
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 2)
    private String position;
    
    @NotNull
    @Min(17)
    @Max(45)
    private Integer age;
    
    @NotNull
    @Size(min = 4, max = 5)
    private String height;
    
    @NotNull
    @Min(140)
    @Max(300)
    private Integer weight;
    
    @NotNull
    @Size(min = 2, max = 45)
    private String college;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Laker() {}
    
    
    
    public Laker(
    		String firstName,
    		String lastName,
    		String position,
    		Integer age,
    		String height,
    		Integer weight,
			String college) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.college = college;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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