/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam4;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author AnhHieu
 */
public class CreatePoint {

    /**
     * @param args the command line arguments
     */
    static Point A = new Point(800, 800);
    static Point B = new Point(4000, 800);
    static Point C = new Point(2400, 2400);

    public static void main(String[] args) {
//TẠo tập hợp Vector kiểu Point 
        Vector<Point> lst = new Vector<>();

        for (int i = 0; i < 8000; i++) {
            Point p = CreatePoint.create8000Point(1200, 400, 400);
            lst.add(p);
        }
        for (int i = 0; i < 10000; i++) {
            Point p = CreatePoint.create10000Point(4500, 3500, 500);
            lst.add(p);
        }
        for (int i = 0; i < 8000; i++) {
            Point p = CreatePoint.create8000Point(1800, 3000, 600);
            lst.add(p);
        }
        lst.add(A);
        lst.add(B);
        lst.add(C);
//Add các điểm được tạo

    }

    //Tạo điểm với 2  tham số tọa độ random cho phép
    public static Point newPoint(int max, int min) {

        Point point = new Point((int) ((Math.random() * max) + min), (int) ((Math.random() * max) + min));
        return point;
    }

    //TẠo điểm cách điểm A với 2 tham số tọa độ và bán kính
    public static Point create8000Point(int max, int min, int bk) {
        boolean create = true;

        Point point = null;
        // Lặp để tạo được 1 điểm thỏa mãn  yêu cầu cách điểm cũ 1 khoảng
        while (create) {
            point = CreatePoint.newPoint(max, min);
            int x = point.getX();
            int y = point.getY();
            int k = (int) Math.sqrt(Math.pow((x - 800), 2) + (Math.pow((y - 800), 2)));
            if (k <= bk) {

                create = false;
            }
        }

        return point; // Trả về điểm được tạo
    }

//TẠo điểm cách điểm B với 2 tham số tọa độ và bán kính
    public static Point create10000Point(int max, int min, int bk) {
        boolean create = true;

        Point point = null;
        while (create) {
            point = CreatePoint.newPoint(max, min);
            int x = point.getX();
            int y = point.getY();
            int k = (int) Math.sqrt(Math.pow((x - 4000), 2) + (Math.pow((y - 800), 2)));
            if (k <= bk) {

                create = false;
            }
        }

        return point;
    }
//TẠo  điểm cách điểm C  với 2 tham số tọa độ và bán kính

    public static Point create12000Point(int max, int min, int bk) {
        boolean create = true;

        Point point = null;
        while (create) {
            point = CreatePoint.newPoint(max, min);
            int x = point.getX();
            int y = point.getY();
            int k = (int) Math.sqrt(Math.pow((x - 2400), 2) + (Math.pow((y - 2400), 2)));
            if (k <= bk) {

                create = false;
            }
        }

        return point;
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }
}
