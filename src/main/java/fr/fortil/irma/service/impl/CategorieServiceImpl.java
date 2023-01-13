package fr.fortil.irma.service.impl;

import org.springframework.stereotype.Service;

import fr.fortil.irma.dto.Categorie;
import fr.fortil.irma.dto.Categories;
import fr.fortil.irma.service.ICategorieService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Service
public class CategorieServiceImpl implements ICategorieService {

	@Override
	public Categories getAll() {
		return new Categories(new ArrayList<>(Arrays.asList(Categorie.values())));
	}
	@Override
	public Map<String, String> getAllComplete() {
		return Categorie.toMap();
	}

	@Override
	public Categorie getByCode(String code) {
		return Categorie.fromCode(code);
	}

}
