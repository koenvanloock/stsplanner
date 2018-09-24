package company.tothepoint.stsplanner.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
public class Pointer {

  private String firstName;
  private String lastName;

  @Override
  public String toString() {
    return "Pointer(" + firstName + " " + lastName + ")";
  }
}
