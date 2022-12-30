package fr.fortil.irma.service.impl;

import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Categorie;
import fr.fortil.irma.dto.Categories;
import fr.fortil.irma.service.ICategorieService;

@Service
public class CategorieServiceImpl implements ICategorieService {

	@Override
	public Categories getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getByCode(String code) {
		return Categorie.fromCode(code);
	}

}
