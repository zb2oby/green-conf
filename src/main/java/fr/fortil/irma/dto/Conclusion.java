package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * conclusion du tirage
 */
@ApiModel(description = "conclusion du tirage ")
@Validated
public class Conclusion {
	public Conclusion() {
		super();
	}

	@JsonProperty("numTirage")
	private Integer numTirage = null;

	@JsonProperty("analyse")
	private String analyse = null;

	@JsonProperty("scoreBonheur")
	private String scoreBonheur = null;

	public Conclusion numTirage(Integer numTirage) {
		this.numTirage = numTirage;
		return this;
	}

	/**
	 * numéro du tirage
	 * 
	 * @return numTirage
	 **/
	@ApiModelProperty(value = "numéro du tirage ")

	public Integer getnumTirage() {
		return numTirage;
	}

	public void setnumTirage(Integer numTirage) {
		this.numTirage = numTirage;
	}

	public Conclusion analyse(String analyse) {
		this.analyse = analyse;
		return this;
	}

	/**
	 * conclusion du tirage
	 * 
	 * @return analyse
	 **/
	@ApiModelProperty(required = true, value = "conclusion du tirage ")
	@NonNull
	public String getAnalyse() {
		return analyse;
	}

	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	public Conclusion scoreBonheur(String scoreBonheur) {
		this.scoreBonheur = scoreBonheur;
		return this;
	}

	/**
	 * score bonheur général du tirage
	 * 
	 * @return scoreBonheur
	 **/
	@ApiModelProperty(value = "score bonheur général du tirage ")

	public String getScoreBonheur() {
		return scoreBonheur;
	}

	public void setScoreBonheur(String scoreBonheur) {
		this.scoreBonheur = scoreBonheur;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Conclusion conclusion = (Conclusion) o;
		return Objects.equals(this.numTirage, conclusion.numTirage)
				&& Objects.equals(this.analyse, conclusion.analyse)
				&& Objects.equals(this.scoreBonheur, conclusion.scoreBonheur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numTirage, analyse, scoreBonheur);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Conclusion {\n");

		sb.append("    numTirage: ").append(toIndentedString(numTirage)).append("\n");
		sb.append("    analyse: ").append(toIndentedString(analyse)).append("\n");
		sb.append("    scoreBonheur: ").append(toIndentedString(scoreBonheur)).append("\n");
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
