package fr.fortil.irma.service.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Carte;
import fr.fortil.irma.dto.Conclusion;
import fr.fortil.irma.dto.InitTirage;
import fr.fortil.irma.dto.Joueur;
import fr.fortil.irma.dto.Tirage;
import fr.fortil.irma.dto.TirageComplet;
import fr.fortil.irma.service.ICarteService;
import fr.fortil.irma.service.ITirageService;

@Service
public class TirageServiceImpl implements ITirageService {
	
	@Autowired
	private ICarteService carteService;

	@Override
	public InitTirage initierTirage(Joueur joueur) {
		InitTirage init = new InitTirage(joueur);
		init.numTirage(new Random().nextInt(100));
		return init;
	}

	@Override
	public Tirage getTirageUnique(Integer numTirage) {
		Tirage tirage = new Tirage();
		tirage.setNumTirage(numTirage);
		tirage.setCarte(carteService.piocherCarte());
		return tirage;
	}

	@Override
	public TirageComplet getTirageComplet(Joueur joueur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Conclusion getConclusion(Integer numTirage) {
		// TODO Auto-generated method stub
		return null;
	}
}
