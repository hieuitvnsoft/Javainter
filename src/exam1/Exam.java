/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author AnhHieu
 */
public class Exam {
//Khai báo tập số

    static TreeSet ts1 = new TreeSet<Integer>();
    static TreeSet ts2 = new TreeSet<Integer>();
    static TreeSet ts3 = new TreeSet<Integer>();
    static TreeSet ts4 = new TreeSet<Integer>();
    Random rd = new Random();

    /**
     * @param args the command line arguments
     */
    private void Create2Treeset() {
// Tạo 2 tập số với các giá trị random
        for (int i = 0; i < 200000; i++) {
            ts1.add(rd.nextInt(200000));
            ts2.add(rd.nextInt(300000));
        }
    }

    private void GetCollection() {
        //Tập hợp  của 2 tập số ts1 và ts2
        ts3.addAll(ts1);
        ts3.addAll(ts2);

    }

    private void tapgiao() {
        for (Iterator iterator = ts1.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            for (Iterator iterator1 = ts2.iterator(); iterator1.hasNext();) {
                Object next1 = iterator1.next();
                if (next.equals(next1)) {
                    ts4.add(next);
                }
            }

        }
    }

    public static void main(String[] args) {
        Exam main = new Exam();
        main.Create2Treeset();

        System.out.println("Chuỗi 1" + ts1);
        System.out.println("Chuỗi 2" + ts2);

        main.GetCollection();
        System.out.println("Chuỗi hợp" + ts3);
        main.tapgiao();
        System.out.println("Chuỗi giao" + ts4);

    }

}
