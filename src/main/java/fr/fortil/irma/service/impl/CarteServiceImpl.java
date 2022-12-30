package fr.fortil.irma.service.impl;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import fr.fortil.irma.dto.Categorie;
import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Carte;
import fr.fortil.irma.dto.Cartes;
import fr.fortil.irma.service.ICarteService;

import java.util.Random;
import java.util.UUID;

@Service
public class CarteServiceImpl implements ICarteService {

	@Override
	public Carte piocherCarte() {
		Lorem lorem = LoremIpsum.getInstance();
		Carte carte = new Carte();
		carte.setIdCarte(UUID.randomUUID().toString());
		carte.setCategorie(Categorie.randomCategorieValue());
		carte.setImage(String.format("%s_0%s.jpeg", Categorie.getName(carte.getCategorie()), new Random().nextInt(2) + 1 ));
		carte.setDescription(lorem.getParagraphs(1, 2));
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
