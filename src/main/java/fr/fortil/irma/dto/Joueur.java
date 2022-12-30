package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * info du joueur
 */
@ApiModel(description = "info du joueur ")
@Validated
public class Joueur {
	public Joueur() {
		super();
	}

	@JsonProperty("prenom")
	private String prenom = null;

	@JsonProperty("dateNaissance")
	private String dateNaissance = null;

	@JsonProperty("signeAstro")
	private String signeAstro = null;

	public Joueur prenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	/**
	 * prénom du joueur
	 * 
	 * @return prenom
	 **/
	@ApiModelProperty(required = true, value = "prénom du joueur ")
	@NonNull
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Joueur dateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
		return this;
	}

	/**
	 * date de naissance
	 * 
	 * @return dateNaissance
	 **/
	@ApiModelProperty(required = true, value = "date de naissance ")
	@NonNull
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Joueur signeAstro(String signeAstro) {
		this.signeAstro = signeAstro;
		return this;
	}

	/**
	 * signe astrologique du joueur
	 * 
	 * @return signeAstro
	 **/
	@ApiModelProperty(value = "signe astrologique du joueur ")

	public String getSigneAstro() {
		return signeAstro;
	}

	public void setSigneAstro(String signeAstro) {
		this.signeAstro = signeAstro;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Joueur joueur = (Joueur) o;
		return Objects.equals(this.prenom, joueur.prenom) && Objects.equals(this.dateNaissance, joueur.dateNaissance)
				&& Objects.equals(this.signeAstro, joueur.signeAstro);
	}

	@Override
	public int hashCode() {
		return Objects.hash(prenom, dateNaissance, signeAstro);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Joueur {\n");

		sb.append("    prenom: ").append(toIndentedString(prenom)).append("\n");
		sb.append("    dateNaissance: ").append(toIndentedString(dateNaissance)).append("\n");
		sb.append("    signeAstro: ").append(toIndentedString(signeAstro)).append("\n");
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
