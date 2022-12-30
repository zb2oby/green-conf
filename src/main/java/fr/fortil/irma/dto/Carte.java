package fr.fortil.irma.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

/**
 * Carte
 */
@Validated
public class Carte   {
  public Carte() {
		super();
	}

@JsonProperty("idCarte")
  private Integer idCarte = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("categorie")
  private String categorie = null;

  @JsonProperty("scoreBonheur")
  private Integer scoreBonheur = null;

  public Carte idCarte(Integer idCarte) {
    this.idCarte = idCarte;
    return this;
  }

  /**
   * id de la carte
   * @return idCarte
  **/
  @NonNull
  public Integer getIdCarte() {
    return idCarte;
  }

  public void setIdCarte(Integer idCarte) {
    this.idCarte = idCarte;
  }

  public Carte image(String image) {
    this.image = image;
    return this;
  }

  /**
   * nom de l'image de la carte
   * @return image
  **/
  @NonNull
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Carte description(String description) {
    this.description = description;
    return this;
  }

  /**
   * le commentaire de la carte 
   * @return description
  **/  
  @NonNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Carte categorie(String categorie) {
    this.categorie = categorie;
    return this;
  }

  /**
   * Catégorie de la carte 
   * @return categorie
  **/
  public String getCategorie() {
    return categorie;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public Carte scoreBonheur(Integer scoreBonheur) {
    this.scoreBonheur = scoreBonheur;
    return this;
  }

  /**
   * scode du bonheur de la carte  
   * @return scoreBonheur
  **/
  public Integer getScoreBonheur() {
    return scoreBonheur;
  }

  public void setScoreBonheur(Integer scoreBonheur) {
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
    Carte carte = (Carte) o;
    return Objects.equals(this.idCarte, carte.idCarte) &&
        Objects.equals(this.image, carte.image) &&
        Objects.equals(this.description, carte.description) &&
        Objects.equals(this.categorie, carte.categorie) &&
        Objects.equals(this.scoreBonheur, carte.scoreBonheur);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCarte, image, description, categorie, scoreBonheur);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Carte {\n");
    
    sb.append("    idCarte: ").append(toIndentedString(idCarte)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    categorie: ").append(toIndentedString(categorie)).append("\n");
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

