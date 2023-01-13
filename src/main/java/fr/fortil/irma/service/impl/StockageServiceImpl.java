package fr.fortil.irma.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import fr.fortil.irma.dto.Carte;
import fr.fortil.irma.dto.Stockage;
import fr.fortil.irma.service.IStockageService;

@Service
public class StockageServiceImpl implements IStockageService {

	@Autowired
	private Stockage stockage;

	/**
	 * renvoie true si la carte est nouvelle
	 * false si la carte a déjà été tirée
	 */
	@Override
	public Boolean checkCarteDejaTiree(UUID numTirage, Carte carte) {
		// nouveau tirage
		if(!stockage.getTirageEncours().containsKey(numTirage)) {
			List<Carte> listeCartes = new ArrayList<>();
			listeCartes.add(carte);
			stockage.getTirageEncours().put(numTirage, listeCartes);
			return Boolean.TRUE;
		}else {
			List<Carte> listeCarte = stockage.getTirageEncours().get(numTirage);
			//la carte est déjà tirée
			if(!CollectionUtils.isEmpty(listeCarte) && listeCarte.contains(carte)){				
				return Boolean.FALSE;
			}else {  // nouvelle carte
				listeCarte.add(carte);
				return Boolean.TRUE;
			}
		}
		
	}

	/**
	 * return true si le tirage contient 6 cartes
	 */
	@Override
	public Boolean isTirageComplet(UUID numTirage) {
		if(stockage.getTirageEncours().containsKey(numTirage)) {
			List<Carte> listeCarte = stockage.getTirageEncours().get(numTirage);			
			if(listeCarte.size() > 5){	
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

}
