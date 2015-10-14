/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author piecar
 */
public class partB {

    /**
     * @param args the command line arguments
     */
    static final int MAXDIGITS = 7;
    public static void main(String[] args) throws FileNotFoundException {
        
        class Node {
            private int key;
            private String val;
            
            Node(int key, String val){
                this.key = key;
                this.val = val;
            }
            
            int getKey(){
                return key;
            }
            String getVal(){
                return val;
            }
        }
        
        System.out.print("STDIN: ");
        //Scanner scan = new Scanner(System.in);   
        Scanner scan = new Scanner(new File("SampleInput.txt"));
        int numItems = scan.nextInt();
        Node[] input = new Node[numItems];
        Node[] output = new Node[numItems];
        int[] count = new int[MAXDIGITS];
        
        // place input into array, populate the counter
        for(int i=0; i<numItems;i++){
            int key = scan.nextInt();
            String val = scan.next();
            
            
            Node curr = new Node(key, val);
            input[i] = curr;
            count[key]++;
        }
        
        //Accumilate the counter items
        for(int i=1; i<MAXDIGITS;i++){
            count[i] = count[i] + count[i-1];
        }
        
        //Place inputs into output array according to counter accumulator
        for(int i = numItems-1; i>=0; i--){
            int key = input[i].getKey();
            int index = count[key];
            output[index-1] = input[i];
            count[key]--;
        }
        
        System.out.println("OUT: \n");
        for(int i=0; i<numItems;i++){
            System.out.print( output[i].getVal() + " ");
        }
    }    
}
