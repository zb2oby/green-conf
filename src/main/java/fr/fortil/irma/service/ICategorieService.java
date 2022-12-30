package fr.fortil.irma.service;

import fr.fortil.irma.dto.Categorie;
import fr.fortil.irma.dto.Categories;

public interface ICategorieService {
	
	public Categories getAll();
	
	public Categorie getByCode(String code);

}
