package fr.fortil.irma.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class Stockage {
	
	private Map<UUID, List<Carte>> tirageEncours;

	public Map<UUID, List<Carte>> getTirageEncours() {
		if(null == tirageEncours) {
			tirageEncours = new HashMap<>();
		}
		return tirageEncours;
	}

	public void setTirageEncours(Map<UUID, List<Carte>> tirageEncours) {
		this.tirageEncours = tirageEncours;
	}

}
