package company.tothepoint.stsplanner.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Room {
  private String name;
  private int capacity;


  @Override
  public String toString() {
    return "Room(" + "name=" + name +")";
  }
}
