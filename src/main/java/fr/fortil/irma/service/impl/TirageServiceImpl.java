package fr.fortil.irma.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Conclusion;
import fr.fortil.irma.dto.InitTirage;
import fr.fortil.irma.dto.Joueur;
import fr.fortil.irma.dto.Tirage;
import fr.fortil.irma.dto.TirageComplet;
import fr.fortil.irma.dto.Tirages;
import fr.fortil.irma.service.ICarteService;
import fr.fortil.irma.service.ITirageService;

@Service
public class TirageServiceImpl implements ITirageService {
	
	@Autowired
	private ICarteService carteService;

	@Override
	public InitTirage initierTirage(Joueur joueur) {
		InitTirage init = new InitTirage(joueur);
		init.numTirage(UUID.randomUUID().toString());
		return init;
	}

	@Override
	public Tirage getTirageUnique(String numTirage) {
		Tirage tirage = new Tirage();
		tirage.setNumTirage(numTirage);
		tirage.setCarte(carteService.piocherCarte());
		return tirage;
	}

	@Override
	public TirageComplet getTirageComplet(Joueur joueur) {
		TirageComplet complet = new TirageComplet();
		this.initierTirage(joueur);
		complet.setJoueur(joueur);
		complet.setTirages(this.initierTirageComplet(this.initierTirage(joueur).getNumTirage()));
		return complet;
	}

	private Tirages initierTirageComplet(String numTirage) {
		Tirages tirages = new Tirages();
		tirages.add(this.getTirageUnique(numTirage));
		return tirages;
	}

	@Override
	public Conclusion getConclusion(String numTirage) {
		// TODO Auto-generated method stub
		return null;
	}
}
