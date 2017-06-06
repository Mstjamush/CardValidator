/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcardvalidator;

import java.util.Scanner;

/**
 *
 * @author josphatmuindi@gmail.com
 */
public class CreditCardValidator {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
            
            String input = "";
            
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a String : ");
            input = reader.nextLine();
            
            boolean card = Check(input);
            
            System.out.println("Your Credit Card is " + card );
            
            if(card == true){
                
                System.out.println("Your Credit card is valid");
            }
            else
                System.out.println("Your Credit card is invalid");
            
    }
        public static boolean Check(String ccNumber)
	{
		int sum = 0;
		boolean alternate = false;
                
                //A loop through all the characters of the card numbers
                //Doubles each number in the card number
                //Then sums the result and checks if the sum modulus 10 is equals to zero
                
		for (int i = ccNumber.length() - 1; i >= 0; i--)
		{
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate)
			{
				n *= 2;
				if (n > 9)
				{
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}
}
