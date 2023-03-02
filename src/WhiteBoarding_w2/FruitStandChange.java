// At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

    // Note that you do not have any change in hand at first.
    
    // Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
    
     
    // Example 1:
    // Input: bills = [5,5,5,10,20]
    // Output: true
    // Explanation: 
    // From the first 3 customers, we collect three $5 bills in order.
    // From the fourth customer, we collect a $10 bill and give back a $5.
    // From the fifth customer, we give a $10 bill and a $5 bill.
    // Since all customers got correct change, we output true.
    
    // Example 2:
    // Input: bills = [5,5,10,10,20]
    // Output: false
    // Explanation: 
    // From the first two customers in order, we collect two $5 bills.
    // For the next two customers in order, we collect a $10 bill and give back a $5 bill.
    // For the last customer, we can not give the change of $15 back because we only have two $10 bills.
    // Since not every customer received the correct change, the answer is false.
    
     
    // Constraints:
    //     1 <= bills.length <= 105
    //     bills[i] is either 5, 10, or 20.

    
package WhiteBoarding_w2;

import java.util.HashMap;

public class FruitStandChange {
    public static void main(String[] args) {
        int[] pmts1 = {5,5,5,10,20};
        int[] pmts2 = {5,5,10,10,20};
        System.out.println(canMakeChange(pmts1)); 
        System.out.println(canMakeChange(pmts2)); 
    }

    
    public static boolean canMakeChange(int[] array) {
        // if the first one is not 5, return false
        // else create a dictionary of denomination as key and the quantity of such bill as value <Integer, Integer>
        // and start with the first 5 (key) dollar bill at quantity (value) 1
        // for every single bill received, if it's 5, increase 5 dollar bill quantity by 1
        // if it's not 5, then first see if there is exact single bill change available 
            // (single bill) such as receive 10 and make change 5
        // if no exact single bill change available, 
            // find possible combo to make change.  
            // since bills denominations are 5 10 15, the only possible non-single change is 15
            // so the possible combination is [10, 5] and [5, 5, 5];

        if(array[0] != 5) 
            return false;
        
        HashMap<Integer, Integer> bills = new HashMap<>();
        // first $5 bill
        bills.put(5, 1);
        int tempValue;
        for(int i = 1; i < array.length; i++){
            switch(array[i]) {
                case 5:
                    tempValue = bills.get(5);
                    bills.put(5, tempValue + 1);
                    break;
                case 10:
                    if(bills.containsKey(10)) {
                        tempValue = bills.get(10);
                        bills.put(10, tempValue + 1 );
                    } else {
                        bills.put(10, 1);
                    }

                    if(bills.get(5) > 0) {
                        tempValue = bills.get(5);
                        bills.put(5, tempValue - 1);
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if(bills.containsKey(20)) {
                        tempValue = bills.get(20);
                        bills.put(20, tempValue + 1);
                    } else {
                        bills.put(20, 1);
                    }
                    if(bills.get(5) >= 3) {
                        tempValue = bills.get(5);
                        bills.put(5, tempValue - 3);
                    } else if(bills.get(5) >= 1 && bills.get(10) >= 1) {
                        tempValue = bills.get(5);
                        bills.put(5, tempValue - 1);
                        tempValue = bills.get(10);
                        bills.put(10, tempValue - 1);
                    } else {
                        return false;
                    }

                    break;
            }

            
        }
        
        return true;

    }
        
    

}





