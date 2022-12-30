package fr.fortil.irma.dto;
import org.springframework.validation.annotation.Validated;

import java.util.Random;


/**
 * Categorie
 */
@Validated
public enum Categorie   {

    MORT("CODE_01"),
    
    ARGENT("CODE_02"),
    
    AMOUR("CODE_03"),

    MOBILITE("CODE_04"),
    
    SANTE("CODE_05"),
    
    RENCONTRE("CODE_06"),
    
    TRAVAIL("CODE_07"),
    
    FAMILLE("CODE_08");

    private final String code;

    private static final Random PRNG = new Random();

    Categorie(String code) {
      this.code = code;
    }

    public static Categorie fromCode(String code) {
      for (Categorie b : Categorie.values()) {
        if (String.valueOf(b.code).equals(code)) {
          return b;
        }
      }
      return null;
    }

    public static String getName(String code) {
        for (Categorie b : Categorie.values()) {
            if (String.valueOf(b.code).equals(code)) {
                return b.name();
            }
        }
        return null;
    }

    public static String randomCategorieValue()  {
        Categorie[] directions = values();
        return directions[PRNG.nextInt(directions.length)].code;
    }
  }

