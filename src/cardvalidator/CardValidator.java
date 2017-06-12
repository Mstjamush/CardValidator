/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardvalidator;

import java.util.Scanner;

/**
 *
 * @author josphatmuindi@gmail.com
 */
public class CardValidator {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
            
            String input = "";
            
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a Card Number : ");
            input = reader.nextLine();
            
            try{
                
                boolean card = Check(input);
            
                if(card == true){
                
                    System.out.println("Your Credit card is valid");
                }
                else
                    System.out.println("Your Credit card is invalid");
                
                
            }catch (NumberFormatException e){
                    System.out.println("Entered number cannot be a Card Number");
            }
    }
        public static boolean Check(String cardNumber)
	{
                boolean nextNumber = false;
		int total = 0;
                
                //A loop through all the characters of the card numbers
                //Doubles each number in the card number
                //Then sums the result and checks if the sum modulus 10 is equals to zero
                
		for (int i = cardNumber.length() - 1; i >= 0; i--)
		{
			int cardDigit = Integer.parseInt(cardNumber.substring(i, i + 1));
			if (nextNumber)
			{
				cardDigit *= 2;
				if (cardDigit > 9)
				{
					cardDigit = (cardDigit % 10) + 1;
				}
			}
			total += cardDigit;
			nextNumber = !nextNumber;
		}
		return (total % 10 == 0);
	}
}
