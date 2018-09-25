package company.tothepoint.stsplanner.filter;

import company.tothepoint.stsplanner.model.StsPlanningProblem;
import company.tothepoint.stsplanner.model.TalkParticipation;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.impl.heuristic.selector.move.generic.ChangeMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

public class ParticipationSelectionMoveFilter implements SelectionFilter<StsPlanningProblem, ChangeMove> {
  @Override
  public boolean accept(ScoreDirector<StsPlanningProblem> scoreDirector, ChangeMove selection) {
    TalkParticipation talkParticipation = (TalkParticipation)selection.getEntity();
    switch (selection.getVariableName()) {
      case "pointer":
          return hasNoPointerOccurenceInThisTimeSlot(scoreDirector.getWorkingSolution(), talkParticipation);
      case "topic":
          return hasNoTopicOccurence(scoreDirector.getWorkingSolution(), talkParticipation);
        default:
          return false;
    }
  }

  private boolean hasNoTopicOccurence(StsPlanningProblem workingSolution, TalkParticipation talkParticipation) {
    return talkParticipation.getTopic() == null || workingSolution.getTalkParticipations().stream().noneMatch(t -> t.getTopic() != null && t.getTopic().equals(talkParticipation.getTopic()));
  }

  private boolean hasNoPointerOccurenceInThisTimeSlot(StsPlanningProblem workingSolution, TalkParticipation talkParticipation) {
    return talkParticipation.getPointer() == null ||  workingSolution.getTalkParticipations().stream().filter(talkpart -> talkpart.getTimeSlot().getStart().equals(talkParticipation.getTimeSlot().getStart()))
        .noneMatch(talkPart -> talkPart.getPointer() != null && talkPart.getPointer().equals(talkParticipation.getPointer()));
  }
}
