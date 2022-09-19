/**
 * the method PrintTheDifference 
 * Author Bolormaa
 */

package assignment1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
       /**
        * Scanner to input the time
        */
        System.out.print("Please enter the first time: ");
        String f_time = sc.next();

        if (validation(f_time)) { 
        	/**
        	 * // Validating first enters time
        	 */
            System.out.print("Please enter the second time: ");
            String s_time = sc.next();
            if (validation(s_time))
            /**
             *  Validating second entered time
             */
                printTimeDifference(f_time, s_time);
        }
        sc.close();
    }

    /**
     * Function extracts hours from hhmm time format
     */ 
    public static int extract_hour(String mil_time) {
        return Integer.parseInt(mil_time.substring(0, 2));
    }
    /**
     * Function extracts minutes from hhmm time format
     */ 
    
    public static int extract_minute(String mil_time) {
        return Integer.parseInt(mil_time.substring(2));
    }
    /**
     * Method to validate the time
     */ 
     
    public static boolean validation(String mil_time) {
        int hour_val, minute_val;
        try {
        	/**
             *  Tries parsing the format into hours and minutes
             * Throws error if the time could not be parsed
             */ 
            
            hour_val = extract_hour(mil_time);
            minute_val = extract_hour(mil_time);
            
            /**
             * Returns false if the hours and minutes are invalid
             */ 
            
            if (hour_val < 0 || hour_val >= 24 || minute_val < 0 || minute_val >= 60) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) { 
        	 /**
             *  All exceptions are caught and invalid input message is printed
             */ 
           
            System.out.println("Invalid input! Program terminated!");
            return false;
        }
    }
    /**
     *  finds and prints the time difference from the two hhmm format times
     */
    
    public static boolean printTimeDifference(String first_time, String second_time) {

    	/**
         *  Converting the time to minutes
         */
    	
        int first_total_minutes = extract_hour(first_time) * 60 + extract_minute(first_time);
        int second_total_minutes = extract_hour(second_time) * 60 + extract_minute(second_time);
        /**
         *  Finding the absolute difference between the total minutes
         */
        
        int difference_time = Math.abs(first_total_minutes - second_total_minutes);

        /**
         * Converting the total minutes to hours and remaining time to minutes
         */
        
        int hours = Math.floorDiv(difference_time, 60);
        int minutes = difference_time % 60;
        System.out.println(hours + " hour(s) " + minutes + "minute(s)");
        return true;
    }
}



