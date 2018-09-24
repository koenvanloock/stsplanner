package company.tothepoint.stsplanner.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Preference {
  private Pointer pointer;
  private Topic topic;
}
