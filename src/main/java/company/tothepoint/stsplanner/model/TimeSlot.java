package company.tothepoint.stsplanner.model;

import lombok.Getter;
import lombok.Setter;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TimeSlot {

  private LocalDateTime start;
  private LocalDateTime end;

  public TimeSlot(LocalDateTime start, LocalDateTime end) {
    this.start = start;
    this.end = end;
  }


}
