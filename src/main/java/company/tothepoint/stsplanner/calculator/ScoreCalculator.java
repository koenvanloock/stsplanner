package company.tothepoint.stsplanner.calculator;

import company.tothepoint.stsplanner.model.StsPlanningProblem;
import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

public class ScoreCalculator implements EasyScoreCalculator<StsPlanningProblem> {
  @Override
  public Score calculateScore(StsPlanningProblem planningProblem) {
    return HardSoftScore.valueOf(0, 0);
  }
}
