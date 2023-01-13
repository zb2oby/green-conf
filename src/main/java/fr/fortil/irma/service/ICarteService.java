package fr.fortil.irma.service;

import fr.fortil.irma.dto.Carte;
import fr.fortil.irma.dto.Cartes;

public interface ICarteService {
	
	public Carte piocherCarte(Integer positif);
	
	public Cartes getAll();
	
	public Carte getyId(Integer idCarte);

}
