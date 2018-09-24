package company.tothepoint.stsplanner.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
@Setter
@NoArgsConstructor
public class TalkParticipation {

  private Room room;
  private int spotNr;
  private Pointer pointer;
  private Topic topic;
  private TimeSlot timeSlot;


  public TalkParticipation(Room room, TimeSlot timeSlot, int spotNr) {
    this.room = room;
    this.timeSlot = timeSlot;
    this.spotNr = spotNr;
  }

  @PlanningVariable(valueRangeProviderRefs = {"pointers"})
  public Pointer getPointer() {
    return pointer;
  }

  @PlanningVariable(valueRangeProviderRefs = {"topics"})
  public Topic getTopic() {
    return topic;
  }

  @Override
  public String toString() {
    return "TalkParticipation(topic=" +
        topic.getSubject() + " pointer=" +
        " room=" + room + " spotNr=" + spotNr +
        " " + pointer + ")";
  }
}
