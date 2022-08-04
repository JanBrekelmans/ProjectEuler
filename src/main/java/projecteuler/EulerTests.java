package projecteuler;

import org.junit.jupiter.api.Test;
import projecteuler.problem001_010.*;
import projecteuler.problem011_020.Problem012;
import projecteuler.problem011_020.Problem016;
import projecteuler.problem011_020.Problem020;
import projecteuler.problem101_110.Problem102;
import projecteuler.problem121_130.Problem125;

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

    // Problems 011-020
    @Test public void testProblem012() {assertEquals(new Problem012().getSolution(), "76576500");}
    @Test public void testProblem016() {assertEquals(new Problem016().getSolution(), "1366");}
    @Test public void testProblem020() {assertEquals(new Problem020().getSolution(), "648");}

    // Problems 101-110
    @Test public void testProblem102(){assertEquals(new Problem102().getSolution(), "228");}

    // Problems 121-130
    @Test public void testProblem125(){assertEquals(new Problem125().getSolution(), "2906969179");}
}
