package fr.dawan.locationsalles.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Identifiant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private int id;
	

	public Identifiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Identifiant(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
