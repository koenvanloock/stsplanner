package company.tothepoint.stsplanner.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Topic {

  private Pointer speaker;
  private String subject;
}
