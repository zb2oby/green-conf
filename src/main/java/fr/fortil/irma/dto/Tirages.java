package fr.fortil.irma.dto;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import org.springframework.validation.annotation.Validated;

/**
 * comprend un tirage complet
 */
@ApiModel(description = "comprend un tirage complet")
@Validated
public class Tirages extends ArrayList<Tirage>  {

  /**
	 * 
	 */
	private static final long serialVersionUID = 6965978572695612259L;

@Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tirages {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

