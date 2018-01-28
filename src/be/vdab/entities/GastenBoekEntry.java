package be.vdab.entities;

import java.time.LocalDateTime;

public class GastenBoekEntry {
	private long id;
	private final String naam;
	private final LocalDateTime datumTijd;
	private final String bericht;
	public GastenBoekEntry(String naam, String bericht) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		if (!isBerichtValid(bericht)) {
			throw new IllegalArgumentException();
		}
		// id is autoincrement
		this.naam = naam;
		this.datumTijd = LocalDateTime.now();
		this.bericht = bericht;
	}
	public GastenBoekEntry(long id, String naam, LocalDateTime datumTijd, String bericht) {
		this.id = id;
		this.naam = naam;
		this.datumTijd = datumTijd;
		this.bericht = bericht;
	}
	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.trim().isEmpty();
	}
	public static boolean isBerichtValid(String bericht) {
		return bericht != null && !bericht.trim().isEmpty();
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public LocalDateTime getDatumTijd() {
		return datumTijd;
	}
	public String getBericht() {
		return bericht;
	}
	
}
