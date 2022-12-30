package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * Tirage
 */
@Validated
public class Tirage   {
  public Tirage() {
		super();
	}

@JsonProperty("numTirage")
  private String numTirage = null;

  @JsonProperty("carte")
  private Carte carte = null;

  public Tirage numTirage(String numTirage) {
    this.numTirage = numTirage;
    return this;
  }

  /**
   * numéro du tirage
   * @return numTirage
  **/
  @ApiModelProperty(required = true, value = "numéro du tirage")
  @NonNull
  public String getNumTirage() {
    return numTirage;
  }

  public void setNumTirage(String numTirage) {
    this.numTirage = numTirage;
  }

  public Tirage carte(Carte carte) {
    this.carte = carte;
    return this;
  }

  /**
   * la carte tirée 
   * @return carte
  **/
  @ApiModelProperty(required = true, value = "la carte tirée ")
  @NonNull
  @Validated
  public Carte getCarte() {
    return carte;
  }

  public void setCarte(Carte carte) {
    this.carte = carte;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tirage tirage = (Tirage) o;
    return Objects.equals(this.numTirage, tirage.numTirage) &&
        Objects.equals(this.carte, tirage.carte);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numTirage, carte);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tirage {\n");
    
    sb.append("    numTirage: ").append(toIndentedString(numTirage)).append("\n");
    sb.append("    carte: ").append(toIndentedString(carte)).append("\n");
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

