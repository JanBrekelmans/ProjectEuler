package projecteuler.library.pells_equation;

import projecteuler.library.Util;

public class PellsEquationsSolver {
    public final long x1, y1;
    public long xk, yk;
    public long k = 1;
    public final long n;

    public PellsEquationsSolver(long x1, long y1, long n) {
        this.x1 = x1;
        this.y1 = y1;
        this.n = n;

        reset();
    }

    public Util.Pair<Long, Long> nextSolution() {
        if(k++ == 1){
            return new Util.Pair<>(x1, y1);
        }
        long xt = xk, yt = yk;
        xk = x1*xt + n*y1*yt;
        yk = x1*yt + y1*xt;
        return new Util.Pair<>(xk, yk);
    }

    public void reset() {
        k = 1;
        xk = x1;
        yk = y1;
    }
}
