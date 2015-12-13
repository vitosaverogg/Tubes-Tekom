/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tekom;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Tahap2 {

    public String readToken(ArrayList<Integer> token) {
        String n = " ";
        Byte x;
        int s = 0;
        Character state;
        int temp = 0;
        Character a;
        String var;
        int i = 0;
        String status = "valid";
        String table[][] = new String[3][10];
        table[0][0] = "A";
        table[0][1] = "A";
        table[0][2] = "A";
        table[0][3] = "A";
        table[0][4] = "error";
        table[0][5] = "error";
        table[0][6] = "error";
        table[0][7] = "error";
        table[0][8] = "error";
        table[0][9] = "error";
        table[1][0] = "1B";
        table[1][1] = "2B";
        table[1][2] = "3B";
        table[1][3] = "4A5B";
        table[1][4] = "error";
        table[1][5] = "error";
        table[1][6] = "error";
        table[1][7] = "error";
        table[1][8] = "error";
        table[1][9] = "error";
        table[2][0] = "error";
        table[2][1] = "error";
        table[2][2] = "error";
        table[2][3] = "error";
        table[2][4] = "lamda";
        table[2][5] = "6A";
        table[2][6] = "7A";
        table[2][7] = "8A";
        table[2][8] = "9A";
        table[2][9] = "lamda";
        ArrayList<Character> stack = new ArrayList<>();
        int literator = 1;
        state = 'i';
        a = '#';
        stack.add(a);
        state = 'p';
        a = 'S';
        stack.add(a);
        state = 'q';

        if (token.get(token.size() - 1) == 0) {
            status = "tidak valid";
        } else {
            while (stack.get(stack.size() - 1) != '#') {                
                if (stack.get(stack.size() - 1) == 'A' || stack.get(stack.size() - 1) == 'S' || stack.get(stack.size() - 1) == 'B') {
                    if (stack.get(stack.size() - 1) == 'S') {
                        s = 0;
                    } else if (stack.get(stack.size() - 1) == 'A') {
                        s = 1;
                    } else {
                        s = 2;
                    };

                    if (literator == token.size()+1){
                        var = table[s][9];
                    }
                    else{
                        var = table[s][token.get(i) - 1];
                    }
                    
                    if (var.equals("error")) {
                        status = "tidak valid";
                        break;
                    } else if (var.equals("lamda")) {
                        stack.remove(stack.size() - 1);
                    } else {
                        stack.remove(stack.size() - 1);
                        for (int j = var.length()-1; j >= 0; j--) {
                            stack.add(var.charAt(j));
                        }
                    }
                } else if ((int) stack.get(stack.size() - 1) >= 48 && (int) stack.get(stack.size() - 1) <= 57) {
                    stack.remove(stack.size() - 1);
                    literator++;
                    if (i + 1 < token.size()) {
                        i++;
                    }
                    
                }
            }
            if (literator < token.size() + 1) {
                status = "tidak valid";
            } else if (stack.get(stack.size() - 1) == '#') {
                status = "valid";
            }
            
            state = 'f';
            stack.remove(stack.size() - 1);
        }
        return status;
    }

}
