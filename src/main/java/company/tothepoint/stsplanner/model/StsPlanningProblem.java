package company.tothepoint.stsplanner.model;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@PlanningSolution
public class StsPlanningProblem {


  private List<Pointer> pointerList;
  private List<Preference> preferences;
  private List<Topic> topics;
  private HardSoftScore score;
  private List<TalkParticipation> talkParticipations;

  public StsPlanningProblem() {
  }

  public StsPlanningProblem(List<Pointer> pointerList, List<Room> rooms, List<Preference> preferences, List<Topic> topics, LocalDateTime start, LocalDateTime end) {
    this.pointerList = pointerList;
    this.preferences = preferences;
    this.topics = topics;
    List<TimeSlot> timeSlots = calculateTimeslots(start, end);
    this.talkParticipations = calculateParticipations(timeSlots, rooms);
  }

  private List<TalkParticipation> calculateParticipations(List<TimeSlot> timeSlots, List<Room> rooms) {
    return timeSlots.stream()
        .flatMap(timeSlot -> rooms.stream()
            .flatMap(room -> IntStream.range(0, room.getCapacity())
                .mapToObj(spotNr -> new TalkParticipation(room, timeSlot, spotNr))))
        .collect(Collectors.toList());
  }

  private List<TimeSlot> calculateTimeslots(LocalDateTime start, LocalDateTime end) {
    return getRoomTimeslots(start, end, new ArrayList<>());
  }

  private List<TimeSlot> getRoomTimeslots(LocalDateTime start, LocalDateTime end, List<TimeSlot> slotsUntilNow) {
    if (start.plus(30, ChronoUnit.MINUTES).isBefore(end)) {
      slotsUntilNow.add(new TimeSlot(start, start.plusMinutes(30)));
      return getRoomTimeslots(start.plusMinutes(30), end, slotsUntilNow);
    } else {
      return slotsUntilNow;
    }
  }

  @ValueRangeProvider(id = "pointers")
  @ProblemFactCollectionProperty
  public List<Pointer> getPointerList() {
    return pointerList;
  }

  @ValueRangeProvider(id = "topics")
  @ProblemFactCollectionProperty
  public List<Topic> getTopics() {
    return topics;
  }


  public List<Preference> getPreferences() {
    return preferences;
  }

  @PlanningEntityCollectionProperty
  public List<TalkParticipation> getTalkParticipations(){
    return talkParticipations;
  }

  @PlanningScore
  private HardSoftScore getScore() {
    return score;
  }

  public void setScore(HardSoftScore score) {
    this.score = score;
  }
}
