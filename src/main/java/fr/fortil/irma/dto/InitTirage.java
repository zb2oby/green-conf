package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * InitTirage
 */
@Validated
public class InitTirage {
	public InitTirage() {
		super();
	}

	@JsonProperty("numTirage")
	private String numTirage = null;

	@JsonProperty("joueur")
	private Joueur joueur = null;

	public InitTirage(Joueur joueur) {
		this.joueur = joueur;
	}

	public InitTirage numTirage(String string) {
		this.numTirage = string;
		return this;
	}

	/**
	 * num du tirage
	 * 
	 * @return numTirage
	 **/
	@ApiModelProperty(required = true, value = "num du tirage ")
	@NonNull
	public String getNumTirage() {
		return numTirage;
	}

	public void setNumTirage(String numTirage) {
		this.numTirage = numTirage;
	}

	public InitTirage joueur(Joueur joueur) {
		this.joueur = joueur;
		return this;
	}

	/**
	 * le joueur
	 * 
	 * @return joueur
	 **/
	@ApiModelProperty(value = "le joueur ")
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
		InitTirage initTirage = (InitTirage) o;
		return Objects.equals(this.numTirage, initTirage.numTirage) && Objects.equals(this.joueur, initTirage.joueur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numTirage, joueur);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InitTirage {\n");

		sb.append("    numTirage: ").append(toIndentedString(numTirage)).append("\n");
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
