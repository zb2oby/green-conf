package fr.fortil.irma.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fortil.irma.dto.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fr.fortil.irma.service.ICarteService;
import fr.fortil.irma.service.ICategorieService;
import fr.fortil.irma.service.ITirageService;
import io.swagger.annotations.ApiParam;

@Controller
public class TirageApiController implements TirageApi {

	private static final Logger log = LoggerFactory.getLogger(TirageApiController.class);

	private final ObjectMapper objectMapper;

	@Autowired
	private ITirageService tirageService;

	@Autowired
	private ICarteService carteService;

	@Autowired
	private ICategorieService categorieService;

	@org.springframework.beans.factory.annotation.Autowired
	public TirageApiController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ResponseEntity<Cartes> getAllCartes() {
		return new ResponseEntity<Cartes>(carteService.getAll(),
				HttpStatus.OK);
	}

	public ResponseEntity<Categories> getAllCategories() {
		return new ResponseEntity<Categories>(categorieService.getAll(),
				HttpStatus.OK);
	}

	public ResponseEntity<Categorie> getByCodeCategorie(
			@NonNull @ApiParam(value = "code de la catégorie", required = true) @Validated @RequestParam(value = "code", required = true) Integer code) {
		return new ResponseEntity<Categorie>(categorieService.getByCode(),
				HttpStatus.OK);
	}

	public ResponseEntity<Carte> getByIdCarte(
			@NonNull @ApiParam(value = "identifiant de la carte souhaitée", required = true) @Validated @RequestParam(value = "id_carte", required = true) Integer idCarte) {
		return new ResponseEntity<Carte>(carteService.getyId(null), HttpStatus.OK);
	}

	public ResponseEntity<Conclusion> getConclusionTirage(
			@NonNull @ApiParam(value = "numero du tirage en cours", required = true) @Validated @RequestParam(value = "num_tirage", required = true) String numTirage) {
		return new ResponseEntity<Conclusion>(tirageService.getConclusion(numTirage), HttpStatus.OK);
	}

	public ResponseEntity<TirageComplet> getTirageComplet(
			@ApiParam(value = "info du joueur", required = true) @Validated @RequestBody Joueur joueur) {
		return new ResponseEntity<TirageComplet>(tirageService.getTirageComplet(joueur), HttpStatus.OK);

		// return new ResponseEntity<TirageComplet>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Tirage> getTirageUnique(
			@NonNull @ApiParam(value = "numero du tirage en cours", required = true) @Validated @RequestParam(value = "num_tirage", required = true) String numTirage) {
		return new ResponseEntity<Tirage>(tirageService.getTirageUnique(numTirage), HttpStatus.OK);
	}

	public ResponseEntity<InitTirage> initierTirage(
			@ApiParam(value = "info du joueur", required = true) @Validated @RequestBody Joueur joueur) {
		return new ResponseEntity<InitTirage>(tirageService.initierTirage(joueur), HttpStatus.OK);

		// return new ResponseEntity<InitTirage>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Categorie> getByCodeCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Carte> getByIdCarte() {
		// TODO Auto-generated method stub
		return null;
	}

}
