package company.tothepoint.stsplanner;

import company.tothepoint.stsplanner.model.StsPlanningProblem;
import company.tothepoint.stsplanner.model.TalkParticipation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.optaplanner.core.api.solver.Solver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

import static company.tothepoint.stsplanner.TestData.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlanningTest {


  @Autowired
  private Solver<StsPlanningProblem> stsPlanningProblemSolver;


  @Test
  public void testOneTopicAttractsEveryOne() {

    StsPlanningProblem problem = stsPlanningProblemSolver.solve(new StsPlanningProblem(
        TestData.fivePointers(),
        Arrays.asList(ROOM_1, ROOM_2),
        TestData.allWantKajsTalk(),
        Arrays.asList(KAJS_TALK, KOENS_TALK),
        LocalDateTime.now().minusHours(3),
        LocalDateTime.now()));

    System.out.println(problem);

    System.out.println(problem.getTalkParticipations().stream()
        .map(TalkParticipation::toString)
        .collect(Collectors.joining("\n")));

  }

}
