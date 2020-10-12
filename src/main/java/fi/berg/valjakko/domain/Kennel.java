package fi.berg.valjakko.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kennel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kennelid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kennel")
	private List<Dog> dogs;
	
	public Kennel() {
		super();
	}
	
	public Kennel(String name) {
		super();
		this.name = name;
	}

	public Long getKennelid() {
		return kennelid;
	}

	public void setKennelid(Long kennelid) {
		this.kennelid = kennelid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	@Override
	public String toString() {
		return "Kennel [kennelid=" + kennelid + ", name=" + name + "]";
	}
	
}
