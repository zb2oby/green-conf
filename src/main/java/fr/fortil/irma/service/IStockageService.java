package fr.fortil.irma.service;

import java.util.UUID;

import fr.fortil.irma.dto.Carte;

public interface IStockageService {
	
	public Boolean checkCarteDejaTiree(UUID numTirage, Carte carte);
	
	public Boolean isTirageComplet(UUID numTirage);

}
