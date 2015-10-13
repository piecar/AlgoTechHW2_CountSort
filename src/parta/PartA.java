/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pieca
 */
public class PartA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> answers = new ArrayList<>();
        int acc =0;
        
        System.out.print("STDIN: ");
        Scanner scan = new Scanner(System.in);   
        int numTests = scan.nextInt();
        
        //Goes through Tests
        for(int i=1; i<=numTests; i++){
            int numOfValues = scan.nextInt();     
            int[] values = new int[numOfValues];
            int[] accArray = new int[10];
            
            //places inputs into an array & accumalates
            for(int j=1; j<=numOfValues; j++){
                int currVal = scan.nextInt();
                values[j-1] = currVal;
                accArray[currVal-1]++;
            }    
            //calculates the total number of pairs
            for(int k=0; k<accArray.length; k++){
                acc += accArray[k] * (accArray[k]-1);                
            }
            answers.add(acc);
            acc = 0;
        }
          
        for(int i=1; i<=numTests; i++){
            System.out.println("OUT " + i +": " + answers.get(i-1));        
        }
        
    }
    
}
