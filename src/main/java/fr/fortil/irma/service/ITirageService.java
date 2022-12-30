package fr.fortil.irma.service;

import fr.fortil.irma.dto.Conclusion;
import fr.fortil.irma.dto.InitTirage;
import fr.fortil.irma.dto.Joueur;
import fr.fortil.irma.dto.Tirage;
import fr.fortil.irma.dto.TirageComplet;

public interface ITirageService {
	
	public InitTirage initierTirage(Joueur joueur);
	
	public Tirage getTirageUnique(String numTirage);
	
	public TirageComplet getTirageComplet(Joueur joueur);
	
	public Conclusion getConclusion(String numTirage);

}
