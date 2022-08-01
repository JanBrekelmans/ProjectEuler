package projecteuler;

import org.junit.jupiter.api.Test;
import projecteuler.problem001_010.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EulerTests {
    // Problems 001-010
    @Test public void testProblem001() {assertEquals(new Problem001().getSolution(), "233168");}
    @Test public void testProblem002() {assertEquals(new Problem002().getSolution(), "4613732");}
    @Test public void testProblem003() {assertEquals(new Problem003().getSolution(), "6857");}
    @Test public void testProblem004() {assertEquals(new Problem004().getSolution(), "906609");}
    @Test public void testProblem005() {assertEquals(new Problem005().getSolution(), "232792560");}
    @Test public void testProblem006() {assertEquals(new Problem006().getSolution(), "25164150");}
    @Test public void testProblem007() {assertEquals(new Problem007().getSolution(), "104743");}
    @Test public void testProblem008() {assertEquals(new Problem008().getSolution(), "23514624000");}
    @Test public void testProblem009() {assertEquals(new Problem009().getSolution(), "31875000");}
    @Test public void testProblem010() {assertEquals(new Problem010().getSolution(), "142913828922");}
}
