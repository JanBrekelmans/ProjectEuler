package projecteuler.problem101_110;

import projecteuler.SolutionTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem102 implements SolutionTemplate {
    public static void main(String[] args) {
        System.out.println(new Problem102().getSolution());
    }

    @Override
    public String getSolution() {
        int total = 0;
        List<List<Point>> trianglePointLists = getTrianglePoints();

        for(List<Point> points: trianglePointLists) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);
            Point p0 = new Point(0,0);

            int doubleTotalArea = doubleAreaOfTriangle(new Triangle(p1,p2,p3));
            int doubleCombinedArea = doubleAreaOfTriangle(new Triangle(p0,p2,p3)) +
                    doubleAreaOfTriangle(new Triangle(p1,p0,p3))+
                    doubleAreaOfTriangle(new Triangle(p1,p2,p0));

            if(doubleTotalArea == doubleCombinedArea) total++;
        }


        return Integer.toString(total);
    }

    private List<List<Point>> getTrianglePoints() {
        List<List<Point>> pointLists = new ArrayList<>();
        try {
            File myObj = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("problem101_110/p102_triangles.txt")).getFile());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                List<Point> pointList = new ArrayList<>();
                String data = myReader.nextLine();
                List<Integer> points = Arrays.stream(data.split(",")).map(Integer::parseInt).toList();

                for(int i = 0; i < 3; i++) {
                    pointList.add(new Point(points.get(2*i), points.get(2*i+1)));
                }

                pointLists.add(pointList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return pointLists;
    }

    private int doubleAreaOfTriangle(Triangle t) {
        Point p1 = t.p1;
        Point p2 = t.p2;
        Point p3 = t.p3;
        return Math.abs(p1.x * (p2.y-p3.y) + p2.x*(p3.y-p1.y) + p3.x*(p1.y - p2.y));
    }

    private record Point(int x, int y) {}
    private record Triangle(Point p1, Point p2, Point p3) {}
}
