/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.validatecheckdigits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author siphoesihle
 */
public class ValidateCheckDigits {

    public static void main(String[] args) {
       try{
          
           File file = new File("AccountNumbers.txt");
           Scanner input = new Scanner(file);
           
           PrintWriter output = new PrintWriter("ValidNumbers.txt");
           
           String accountNumber = input.nextLine().trim();
           
           if(accountNumber.matches("6")){
               int sum = 0;
               
               
            for (int i = 0; i < 5; i++) {
            sum = sum + Character.getNumericValue(accountNumber.charAt(i));
            
           }
           int remainder = sum %10;
           
           int lastDigit = Character.getNumericValue(accountNumber.charAt(5));
          
               
               if(remainder == lastDigit){
                   System.out.println(accountNumber + " Valid ");
                   output.println(accountNumber);
               }else{
                   System.out.println(accountNumber + " Invalid ");
                   
               }
           }
           
           input.close();
           output.close();
           
           System.out.println("Valid Numbers have been saved on ValidNumbers.txt");
               
       }catch(FileNotFoundException e) {   
            System.out.println("File Not Found");
           }
    }
}
