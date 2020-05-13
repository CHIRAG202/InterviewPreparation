

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.regexp.internal.RE;
import netscape.security.UserTarget;
import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.MARSHAL;


import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

import static BinarySearch.IsPerfectSquare.isPerfectSquare;

/**
 * Created by RajeshAatrayan|InterviewPreparation|PACKAGE_NAME|null.java| on Oct,2019
 * Happy Coding :)
 */
public class Test {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < num.length() && k > 0) {

            if (stack.isEmpty()) {
                stack.push(Integer.parseInt(num.charAt(i++) + ""));
                continue;
            }

            if (stack.peek() > Integer.parseInt(num.charAt(i) + "")) {

                while (k > 0 && !stack.isEmpty() && stack.peek() > Integer.parseInt(num.charAt(i) + "")) {
                    k--;
                    stack.pop();
                }
                stack.push(Integer.parseInt(num.charAt(i++) + ""));

            } else {
                stack.push(Integer.parseInt(num.charAt(i++) + ""));
            }

        }
        while (k>0){
            stack.pop();
            k--;
        }

        String str = "";

        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }

        while (!str.isEmpty() && str.charAt(0) == '0') {
            if (str.length() > 1)
                str = str.substring(1);
            else str = "";
        }

        while (i < num.length()) str += num.charAt(i++);
        if (str.isEmpty()) return "0";
        return str;

    }

    public static void main(String[] args) {
        System.out.println(new Test().removeKdigits("65899", 2));
    }
}