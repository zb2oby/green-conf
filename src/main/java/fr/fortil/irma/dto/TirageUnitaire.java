package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * TirageUnitaire
 */

public class TirageUnitaire {
	public TirageUnitaire() {
		super();
	}

	@JsonProperty("tirage")
	private Tirage tirage = null;

	@JsonProperty("joueur")
	private Joueur joueur = null;

	public TirageUnitaire tirage(Tirage tirage) {
		this.tirage = tirage;
		return this;
	}

	/**
	 * tirage d'une carte
	 * 
	 * @return tirage
	 **/
	@ApiModelProperty(required = true, value = "tirage d'une carte ")
	@NonNull
	@Validated
	public Tirage getTirage() {
		return tirage;
	}

	public void setTirage(Tirage tirage) {
		this.tirage = tirage;
	}

	public TirageUnitaire joueur(Joueur joueur) {
		this.joueur = joueur;
		return this;
	}

	/**
	 * le joueur
	 * 
	 * @return joueur
	 **/
	@ApiModelProperty(required = true, value = "le joueur ")
	@NonNull
	@Validated
	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TirageUnitaire tirageUnitaire = (TirageUnitaire) o;
		return Objects.equals(this.tirage, tirageUnitaire.tirage) && Objects.equals(this.joueur, tirageUnitaire.joueur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tirage, joueur);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TirageUnitaire {\n");

		sb.append("    tirage: ").append(toIndentedString(tirage)).append("\n");
		sb.append("    joueur: ").append(toIndentedString(joueur)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
