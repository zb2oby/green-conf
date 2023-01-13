package fr.fortil.irma.service;

import java.util.UUID;

import fr.fortil.irma.dto.Conclusion;
import fr.fortil.irma.dto.InitTirage;
import fr.fortil.irma.dto.Joueur;
import fr.fortil.irma.dto.Tirage;
import fr.fortil.irma.dto.TirageComplet;

public interface ITirageService {
	
	public InitTirage initierTirage(Joueur joueur);
	
	public Tirage getTirageUnique(UUID numTirage, Integer positif);
	
	public TirageComplet getTirageComplet(Joueur joueur);
	
	public Conclusion getConclusion(UUID numTirage);

}
