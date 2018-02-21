/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author AnhHieu
 */
public class NewMain {

    private String readTextStream() throws FileNotFoundException, IOException {
        String filename = "src/input.txt";

        FileInputStream fis = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        StringBuffer sb = new StringBuffer();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        System.out.println(sb.toString());
        br.close();
        return sb.toString();
    }

    private String countText(String str) {
        String ak[] = str.split(" ");
        String key = "";
        Integer value;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < ak.length; i++) {
            key = ak[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, new Integer(1));
            }
        }
        Set set = map.keySet();
        Iterator i = set.iterator();
        String out = null;
        while (i.hasNext()) {
            key = (String) i.next();
            String is = "Từ" + key + "xuất hiện " + map.get(key) + " lần";
            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
            out = out + "" + is;

        }

        return out;
    }

    private void Savetext(String out) throws FileNotFoundException, IOException {

        String outf = "src/out.txt";
        // Ghi dữ liệu
        FileOutputStream fos = new FileOutputStream(outf, true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        bw.write(out);
        bw.close();
        fos.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        NewMain nm = new NewMain();
        String n = nm.readTextStream();

        String k = nm.countText(n);
        nm.Savetext(k);
    }
}
