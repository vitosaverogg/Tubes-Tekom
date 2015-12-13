/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tekom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vitosaverogg
 */
public class Tahap1 {

    /**
     * @param args the command line arguments
     */
    private ArrayList<String> string = new ArrayList<>();
    private ArrayList<Integer> tokenLexic = new ArrayList<>();
    private ArrayList<String> besaranLexic = new ArrayList<>();

    public void reset() {
        string.clear();
        tokenLexic.clear();
        besaranLexic.clear();
    }

    public ArrayList<String> getString() {
        return string;
    }

    public void setString(ArrayList<String> string) {
        this.string = string;
    }

    public ArrayList<Integer> getTokenLexic() {
        return tokenLexic;
    }

    public void setTokenLexic(ArrayList<Integer> tokenLexic) {
        this.tokenLexic = tokenLexic;
    }

    public ArrayList<String> getBesaranLexic() {
        return besaranLexic;
    }

    public void setBesaranLexic(ArrayList<String> besaranLexic) {
        this.besaranLexic = besaranLexic;
    }

    public void proses(String input) {
        // TODO code application logic here

        int a, i, j;
        String temp = new String();
        String b;

        String state = "q0";
        for (i = 0; i < input.length(); i++) {

            switch (state) {
                case "q0":
                    if ((int) input.toLowerCase().charAt(i) >= 97 && (int) input.toLowerCase().charAt(i) <= 122) {
                        state = "q1";
                    } else if ((int) input.charAt(i) >= 48 && (int) input.charAt(i) <= 57) {
                        state = "q2";
                    } else if (input.charAt(i) == '+') {
                        state = "q3";
                    } else if (input.charAt(i) == '-') {
                        state = "q4";
                    } else if (input.charAt(i) == '/') {
                        state = "q5";
                    } else if (input.charAt(i) == '*') {
                        state = "q6";
                    } else if (input.charAt(i) == '(') {
                        state = "q7";
                    } else if (input.charAt(i) == ')') {
                        state = "q8";
                    } else {
                        state = "q12";
                    }
                    i--;
                    break;
                case "q1":
                    temp = temp + input.charAt(i);
                    if (i + 1 < input.length()) {
                        j = i + 1;
                        i++;
//                        System.out.println("nilai j: " + j);
                        while (j < input.length() && ((int) input.toLowerCase().charAt(j) >= 97 && (int) input.toLowerCase().charAt(j) <= 122 || (int) input.charAt(j) >= 48
                                && (int) input.charAt(j) <= 57 || input.charAt(j) == '_')) {
                            temp = temp + (input.charAt(j));
                            j++;
                            i++;
                        }
                        i--;
                    }
                    a = 1;
                    tokenLexic.add(a);
//                    System.out.println(a);
                    string.add(temp);
                    b = "Operand";
                    besaranLexic.add(b);
                    temp = "";

                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q2":
                    temp = temp + input.charAt(i);
                    if (i + 1 < input.length()) {
                        j = i + 1;
                        i++;
                        while (j < input.length() && ((int) input.charAt(j) >= 48 && (int) input.charAt(j) <= 57)) {
                            temp = temp + (input.charAt(j));
                            j++;
                            i++;
                        }
                        if (i < input.length()) {
                            if (input.charAt(i) == 'E') {
                                state = "q9";
                            } else if (input.charAt(i) == ',' || input.charAt(i) == '.') {
                                state = "q10";
                            }
                        }

                        i--;
                    }
                    if (state == "q2") {
                        a = 3;
                        for (int x = 0; x < temp.length(); x++) {
                            if (temp.charAt(x) == ',' || temp.charAt(x) == 'E' || temp.charAt(x) == '.') {
                                a = 2;
                            }
                        }
                        tokenLexic.add(a);
                        string.add(temp);
                        b = "Operand";
                        besaranLexic.add(b);
                        temp = "";
                    }
                    if (i + 1 < input.length() && (state != "q9" && state != "q10")) {
                        state = "q0";
                    }
                    break;
                case "q3":
                    temp = "" + input.charAt(i);
                    a = 6;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Operator";
                    besaranLexic.add(b);
                    temp = "";
                    if (i < input.length()) {
                        state = "q0";

                    }
                    if (i + 1 < input.length()) {
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q4":
                    temp = "" + input.charAt(i);
                    a = 7;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Operator";
                    besaranLexic.add(b);
                    temp = "";
                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q5":
                    temp = "" + input.charAt(i);
                    a = 9;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Operator";
                    besaranLexic.add(b);
                    temp = "";
                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q6":
                    temp = "" + input.charAt(i);
                    a = 8;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Operator";
                    besaranLexic.add(b);
                    temp = "";
                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q7":
                    temp = "" + input.charAt(i);
                    a = 4;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Grouping Symbol";
                    besaranLexic.add(b);
                    temp = "";
                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q8":
                    temp = "" + input.charAt(i);
                    a = 5;
                    tokenLexic.add(a);
                    string.add(temp);
                    b = "Grouping Symbol";
                    besaranLexic.add(b);
                    temp = "";
                    if (i + 1 < input.length()) {
                        state = "q0";
                        if (input.charAt(i + 1) == 'E' || input.charAt(i + 1) == ',' || input.charAt(i + 1) == '.') {
                            state = "q12";
                        }
                    }

                    break;
                case "q9":
                    temp = temp + input.charAt(i);
                    if (i + 1 < input.length()) {
                        if ((int) input.charAt(i + 1) >= 48 && (int) input.charAt(i + 1) <= 57) {
                            state = "q2";
                        } else if (input.charAt(i + 1) == '+' || input.charAt(i+1) == '-') {
                            state = "q11";
                        } else if (input.charAt(i + 1) == ')') {
                            state = "q8";
                            a = 2;
                            string.add(temp);
                            tokenLexic.add(a);
                            b = "Operand";
                            besaranLexic.add(b);
                            temp = "";
                        } else if (input.charAt(i + 1) == '*') {
                            state = "q6";
                            a = 2;
                            string.add(temp);
                            tokenLexic.add(a);
                            b = "Operand";
                            besaranLexic.add(b);
                            temp = "";
                        } else if (input.charAt(i + 1) == '/') {
                            state = "q5";
                            a = 2;
                            string.add(temp);
                            tokenLexic.add(a);
                            b = "Operand";
                            besaranLexic.add(b);
                            temp = "";
                        } else {
                            state = "q12";
                        }
                    } else {
                        a = 2;
                        tokenLexic.add(a);
                        string.add(temp);
                        b = "Operand";
                        besaranLexic.add(b);
                        temp = "";
                    }

                    break;
                case "q10":
                    temp = temp + input.charAt(i);
                    if (i + 1 < input.length()) {
                        if ((int) input.charAt(i + 1) >= 48 && (int) input.charAt(i + 1) <= 57) {
                            state = "q2";
                        } else {
                            state = "q12";
                        }
                    } else {
                        string.add(temp);
                        b = "error";
                        besaranLexic.add(b);
                        a = 0;
                        tokenLexic.add(a);
                    }

                    break;
                case "q11":
                    temp = temp + input.charAt(i);

                    if (i + 1 < input.length() && ((int) input.charAt(i + 1) >= 48 && (int) input.charAt(i + 1) <= 57)) {
                        state = "q2";
                    } else {
                        string.add(temp);
                        b = "error";
                        besaranLexic.add(b);
                        a = 0;
                        tokenLexic.add(a);
                    }
                    break;
                case "q12":
                    temp = "" + input.charAt(i);
                    a = 0;
                    tokenLexic.add(a);
                    string.add(temp);

                    b = "Error";
                    besaranLexic.add(b);
                    i = input.length();
                    break;

            }
        }
    }
}
