package be.vdab.entities;

import java.util.ArrayList;
import java.util.List;

public class Saus {
	private long nummer;
	private String naam;
	private List<String> ingredienten = new ArrayList<>();
	public Saus(long nummer, String naam, List<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
		this.ingredienten.addAll(ingredienten);
	}
	public long getNummer() {
		return nummer;
	}
	public void setNummer(long nummer) {
		this.nummer = nummer;
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
