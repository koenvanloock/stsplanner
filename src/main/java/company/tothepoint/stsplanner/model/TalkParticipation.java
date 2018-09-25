package company.tothepoint.stsplanner.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import static java.util.Optional.ofNullable;

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

  public TimeSlot getTimeSlot() {
    return timeSlot;
  }

  @PlanningVariable(valueRangeProviderRefs = {"pointers"}, nullable = true)
  public Pointer getPointer() {
    return pointer;
  }

  @PlanningVariable(valueRangeProviderRefs = {"topics"}, nullable = true)
  public Topic getTopic() {
    return topic;
  }

  @Override
  public String toString() {
    return "TalkParticipation(topic=" +
        ofNullable(topic).map(Topic::getSubject).orElse("Empty") + " pointer=" +
        " room=" + room + " spotNr=" + spotNr +
        " " + ofNullable(pointer).map(Pointer::toString).orElse("no-one") + ")";
  }
}
