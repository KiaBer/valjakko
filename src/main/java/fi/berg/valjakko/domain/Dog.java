package fi.berg.valjakko.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dog {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min=3, max=40, message="Nimen täytyy sisältää 3-40 merkkiä")
	private String name, gender, information;

	
	@NotNull(message = "Mikrosirun numero ei voi olla tyhjä")
	private int microship;
	
	@ManyToOne
	@JoinColumn(name = "kennelid")
	@JsonIgnore
	private Kennel kennel;
	
	public Dog() {
		super();
	}
	
	public Dog(String name, String gender, String information, int microship, Kennel kennel) {
		super();
		this.name = name;
		this.gender = gender;
		this.information = information;
		this.microship = microship;
		this.kennel = kennel;
	}
	
	public Dog(String name, String gender, String information, int microship) {
		super();
		this.name = name;
		this.gender = gender;
		this.information = information;
		this.microship = microship;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public int getMicroship() {
		return microship;
	}
	public void setMicroship(int microship) {
		this.microship = microship;
	}

	public Kennel getKennel() {
		return kennel;
	}
	public void setKennel(Kennel kennel) {
		this.kennel = kennel;
	}
	
	@Override
	public String toString() {
		if (this.kennel != null)
		return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", information=" + information
				+ ", microship=" + microship + ", kennel=" + this.getKennel() + "]";
		else
		return "Dog [id=" + id + ", name=" + name + ", gender=" + gender + ", information=" + information
				+ ", microship=" + microship + "]";
	}

}
