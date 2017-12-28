package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import be.vdab.entities.Saus;

public class SausRepository {
	private static final Map<Long, Saus> SAUZEN = new ConcurrentHashMap<>();
	
	static {
		SAUZEN.put(11L, new Saus(11, "cocktail", Arrays.asList("room", "ketchup", "paprikapoeder", "sherry", "cognac", "gembersiroop")));
		SAUZEN.put(12L, new Saus(12, "mayonaise", Arrays.asList("eidooier", "olie", "azijn", "mosterd", "suiker", "kruiden", "peper", "zout")));
		SAUZEN.put(22L, new Saus(22, "mosterd", Arrays.asList("mosterzaden", "water", "azijn", "suiker", "zout", "kruiden", "rozemarijn")));
		SAUZEN.put(13L, new Saus(13, "tartare", Arrays.asList("mayonaise", "peterselie", "ei", "uitjes")));
		SAUZEN.put(14L, new Saus(14, "vinaigrette", Arrays.asList("olijfolie", "wijnazijn", "zout", "peper", "kruiden")));
	}
	
	public List<Saus> findAll() {
		return new ArrayList<>(SAUZEN.values());
	}
	
	public Optional<Saus> read(long id) {
		Saus saus = SAUZEN.get(id);
		return Optional.ofNullable(saus);
	}
	
	public void create(Saus saus) {
		saus.setId(Collections.max(SAUZEN.keySet()) + 1);
		SAUZEN.put(saus.getId(), saus);
	}
	
	public List<Saus> findByIngredient(String ingredient) {
		 return SAUZEN.values().stream()
		 .filter(saus -> saus.getIngredienten().contains(ingredient))
		 .collect(Collectors.toList());
	}
	
	public void delete(Set<Long> idStream) {
		 idStream.forEach(id -> SAUZEN.remove(id));
	}
}
