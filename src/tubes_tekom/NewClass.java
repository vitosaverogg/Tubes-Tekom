/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_tekom;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vitosaverogg
 */
public class NewClass {
    public static void main(String[] args) {
        Tahap1 tahap1 = new Tahap1();
        Tahap2 tahap2 = new Tahap2();
        
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        tahap1.proses(string);
        System.out.println(tahap2.readToken(tahap1.getTokenLexic()));
        for (int i = 0; i < tahap1.getTokenLexic().size() ;i++){
            System.out.println(tahap1.getString().get(i) +"\t"+ tahap1.getBesaranLexic().get(i) +" \t" + tahap1.getTokenLexic().get(i));
        }
        
       
    }
}
