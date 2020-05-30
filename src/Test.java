

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;
import sun.rmi.runtime.Log;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */


public class Test {
    static class node {
        int x;
        int y;

        public node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        TreeMap<Double, LinkedList<node>> map = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            double sq = Math.sqrt((Math.abs(points[i][0])*Math.abs(points[i][0]))+(Math.abs(points[i][1])*Math.abs(points[i][1]))) ;
            if (map.get(sq) == null) {
                LinkedList<node> list = new LinkedList<>();
                list.add(new node(points[i][0], points[i][1]));
                map.put(sq, list);
            } else {
                map.get(sq).add(new node(points[i][0], points[i][1]));
            }
        }
        int c = 0;
        int ans[][] = new int[k + 1][2];
        for (Map.Entry<Double, LinkedList<node>> x : map.entrySet()) {

            for (node l : x.getValue()) {
                if (c >= k) {
                    return ans;
                }
                ans[c][0] = l.x;
                ans[c][1] = l.y;
                c++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}