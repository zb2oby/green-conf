package fr.fortil.irma.service;

import fr.fortil.irma.dto.Categorie;
import fr.fortil.irma.dto.Categories;

import java.util.Map;

public interface ICategorieService {
	
	public Map<String, String> getAllComplete();

	public Categories getAll();

	public Categorie getByCode(String code);

}
