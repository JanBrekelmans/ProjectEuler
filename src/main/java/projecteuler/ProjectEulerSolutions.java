package projecteuler;

import org.junit.jupiter.api.Test;
import projecteuler.problem001_010.*;
import projecteuler.problem011_020.*;
import projecteuler.problem021_030.Problem021;
import projecteuler.problem021_030.Problem022;
import projecteuler.problem021_030.Problem023;
import projecteuler.problem101_110.Problem102;
import projecteuler.problem101_110.Problem107;
import projecteuler.problem121_130.Problem125;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectEulerSolutions {
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
    @Test public void testProblem011() {assertEquals(new Problem011().getSolution(), "70600674");}
    @Test public void testProblem012() {assertEquals(new Problem012().getSolution(), "76576500");}
    @Test public void testProblem013() {assertEquals(new Problem013().getSolution(), "5537376230");}
    @Test public void testProblem014() {assertEquals(new Problem014().getSolution(), "837799");}
    @Test public void testProblem015() {assertEquals(new Problem015().getSolution(), "137846528820");}
    @Test public void testProblem016() {assertEquals(new Problem016().getSolution(), "1366");}
    @Test public void testProblem017() {assertEquals(new Problem017().getSolution(), "21124");}
    @Test public void testProblem018() {assertEquals(new Problem018().getSolution(), "1074");}
    @Test public void testProblem019() {assertEquals(new Problem019().getSolution(), "171");}
    @Test public void testProblem020() {assertEquals(new Problem020().getSolution(), "648");}

    // Problems 011-020
    @Test public void testProblem021() {assertEquals(new Problem021().getSolution(), "31626");}
    @Test public void testProblem022() {assertEquals(new Problem022().getSolution(), "871198282");}
    @Test public void testProblem023() {assertEquals(new Problem023().getSolution(), "4179871");}

    // Problems 101-110
    @Test public void testProblem102(){assertEquals(new Problem102().getSolution(), "228");}
    @Test public void testProblem107(){assertEquals(new Problem107().getSolution(), "259679");}

    // Problems 121-130
    @Test public void testProblem125(){assertEquals(new Problem125().getSolution(), "2906969179");}
}
