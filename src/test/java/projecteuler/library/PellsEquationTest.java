package projecteuler.library;

import org.junit.jupiter.api.Test;
import projecteuler.library.pells_equation.PellsEquationsSolver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PellsEquationTest {
    private final List<Util.Pair<Long, Long>> solutionPairs = new ArrayList<>() {{
        add(new Util.Pair<>(8L,3L));
        add(new Util.Pair<>(127L,48L));
        add(new Util.Pair<>(2024L,765L));
        add(new Util.Pair<>(32257L,12192L));
        add(new Util.Pair<>(514088L,194307L));
    }};

    @Test
    public void pellsEquationTest() {
        int x1 = 8;
        int y1 = 3;
        int n = 7;

        PellsEquationsSolver pellsEquationsSolver = new PellsEquationsSolver(x1, y1, n);
        for (Util.Pair<Long, Long> solutionPair: solutionPairs){
            Util.Pair<Long, Long> nextSolution = pellsEquationsSolver.nextSolution();
            assertEquals(nextSolution, solutionPair);
        }
    }
}
