package be.vdab.entities;

import java.util.ArrayList;
import java.util.List;

public class Saus {
	private long id;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();
	public Saus(long id, String naam, List<String> ingredienten) {
		this.id = id;
		this.naam = naam;
		this.ingredienten.addAll(ingredienten);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public List<String> getIngredienten() {
		return ingredienten;
	}
	public void addIngredient(String ingredient) {
		ingredienten.add(ingredient);
	}
}
