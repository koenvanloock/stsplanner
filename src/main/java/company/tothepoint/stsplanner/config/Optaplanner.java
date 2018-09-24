package company.tothepoint.stsplanner.config;

import company.tothepoint.stsplanner.model.StsPlanningProblem;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Optaplanner {

  @Bean
  public Solver<StsPlanningProblem> stsSolver() {
    SolverFactory<StsPlanningProblem> solverFactory = SolverFactory.createFromXmlResource("stsplannerconfig.xml");
    return solverFactory.buildSolver();
  }

}