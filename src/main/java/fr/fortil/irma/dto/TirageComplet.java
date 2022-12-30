package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * TirageComplet
 */
@Validated
public class TirageComplet   {
  @JsonProperty("tirages")
  private Tirages tirages = null;

  @JsonProperty("joueur")
  private Joueur joueur = null;

  @JsonProperty("conclusion")
  private Conclusion conclusion = null;

  public TirageComplet tirages(Tirages tirages) {
    this.tirages = tirages;
    return this;
  }

  /**
   * tirages complet 
   * @return tirages
  **/
  @ApiModelProperty(required = true, value = "tirages complet ")
  @NonNull
  @Validated
  public Tirages getTirages() {
    return tirages;
  }

  public void setTirages(Tirages tirages) {
    this.tirages = tirages;
  }

  public TirageComplet joueur(Joueur joueur) {
    this.joueur = joueur;
    return this;
  }

  /**
   * le joueur 
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

  public TirageComplet conclusion(Conclusion conclusion) {
    this.conclusion = conclusion;
    return this;
  }

  /**
   * la conclusion du tirage 
   * @return conclusion
  **/
  @ApiModelProperty(required = true, value = "la conclusion du tirage ")
  @NonNull
  @Validated
  public Conclusion getConclusion() {
    return conclusion;
  }

  public void setConclusion(Conclusion conclusion) {
    this.conclusion = conclusion;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TirageComplet tirageComplet = (TirageComplet) o;
    return Objects.equals(this.tirages, tirageComplet.tirages) &&
        Objects.equals(this.joueur, tirageComplet.joueur) &&
        Objects.equals(this.conclusion, tirageComplet.conclusion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tirages, joueur, conclusion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TirageComplet {\n");
    
    sb.append("    tirages: ").append(toIndentedString(tirages)).append("\n");
    sb.append("    joueur: ").append(toIndentedString(joueur)).append("\n");
    sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
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

