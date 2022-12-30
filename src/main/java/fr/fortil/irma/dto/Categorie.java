package fr.fortil.irma.dto;

import java.util.Objects;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;


/**
 * Categorie
 */
@Validated
public class Categorie   {
  public Categorie() {
		super();
	}

/**
   * code de la categorie. 
   */
  public enum CodeEnum {
    _01("code_01"),
    
    _02("code_02"),
    
    _03("code_03"),
    
    _04("code_04"),
    
    _05("code_05"),
    
    _06("code_06"),
    
    _07("code_07"),
    
    _08("code_08");

    private String value;

    CodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CodeEnum fromValue(String text) {
      for (CodeEnum b : CodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("code")
  private CodeEnum code = null;

  /**
   * nom de la categorie. 
   */
  public enum LibelleEnum {
    MORT("MORT"),
    
    ARGENT("ARGENT"),
    
    AMOUR("AMOUR"),
    
    MOBILITE("MOBILITE"),
    
    SANTE("SANTE"),
    
    RENCONTRE("RENCONTRE"),
    
    TRAVAIL("TRAVAIL"),
    
    FAMILLE("FAMILLE");

    private String value;

    LibelleEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LibelleEnum fromValue(String text) {
      for (LibelleEnum b : LibelleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("libelle")
  private LibelleEnum libelle = null;

  public Categorie code(CodeEnum code) {
    this.code = code;
    return this;
  }

  /**
   * code de la categorie. 
   * @return code
  **/
  @NonNull
  public CodeEnum getCode() {
    return code;
  }

  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public Categorie libelle(LibelleEnum libelle) {
    this.libelle = libelle;
    return this;
  }

  /**
   * nom de la categorie. 
   * @return libelle
  **/
  @ApiModelProperty(value = "nom de la categorie. ")
  public LibelleEnum getLibelle() {
    return libelle;
  }

  public void setLibelle(LibelleEnum libelle) {
    this.libelle = libelle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Categorie categorie = (Categorie) o;
    return Objects.equals(this.code, categorie.code) &&
        Objects.equals(this.libelle, categorie.libelle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, libelle);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Categorie {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    libelle: ").append(toIndentedString(libelle)).append("\n");
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

