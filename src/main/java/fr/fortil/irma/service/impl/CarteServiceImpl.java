package fr.fortil.irma.service.impl;

import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Carte;
import fr.fortil.irma.dto.Cartes;
import fr.fortil.irma.service.ICarteService;

@Service
public class CarteServiceImpl implements ICarteService {
	
	@Override
	public Carte piocherCarte() {
		Carte carte = new Carte();
		carte.setIdCarte(123456);
		carte.setImage("sang.jpeg");
		carte.setDescription("9a circule, voyage, déplacement");
		carte.setCategorie("CODE_04");
		return carte;
	}

	@Override
	public Cartes getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte getyId(Integer idCarte) {
		// TODO Auto-generated method stub
		return null;
	}

}
