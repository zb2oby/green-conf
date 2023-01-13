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
import fr.fortil.irma.service.IStockageService;
import fr.fortil.irma.service.ITirageService;

@Service
public class TirageServiceImpl implements ITirageService {

	@Autowired
	private ICarteService carteService;

	@Autowired
	private IStockageService stockageService;

	@Override
	public InitTirage initierTirage(Joueur joueur) {
		InitTirage init = new InitTirage(joueur);
		init.numTirage(UUID.randomUUID().toString());
		return init;
	}

	@Override
	public Tirage getTirageUnique(UUID numTirage, Integer positif) {
		Tirage tirage = new Tirage();
		tirage.setNumTirage(numTirage.toString());
		tirage.setCarte(carteService.piocherCarte(positif));
		if(stockageService.isTirageComplet(numTirage)) {
			return null;
		}
		if (!stockageService.checkCarteDejaTiree(numTirage, tirage.getCarte())) {
			tirage = this.getTirageUnique(numTirage, positif);
		}
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
		for (int i = 0; i < 6; i++) {
			tirages.add(this.getTirageUnique(UUID.fromString(numTirage), 2));
		}
		return tirages;
	}

	@Override
	public Conclusion getConclusion(UUID numTirage) {
		// TODO Auto-generated method stub
		return new Conclusion();
	}
}
