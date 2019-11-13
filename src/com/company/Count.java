package com.company;

public class Count {

    // Function to count how many appearances of String A is in String B
    public int howMany(String stringa, String stringb){
        int count = 0;
        int appearance = stringb.indexOf(stringa);

        // Return how many times the strings appearse
        if(appearance == -1){
            return count;
        } else {
            while(appearance != -1){
                count++;
                int newIndex = appearance + stringa.length();
                appearance = stringb.indexOf(stringa, newIndex);
            }
            return count;
        }
    }

    // Function to count how many times the characters C and G is represented in a string
    public double cgRatio(String dnaString){
        String dna = dnaString.toLowerCase();
        int countC = 0;
        int countG = 0;

        // Loop throught the string and start counting C's and G's
        for(int i = 0; i < dna.length(); i++){
            String character = dna.substring(i, i+1);

            // Count if C
            if(character.equals("c")){
                countC++;
            }

            // Count if G
            if(character.equals("g")){
                countG++;
            }
        }

        // Convert the number to a float before returning the ratio
        return (float) (countC + countG) / dna.length();
    }
}
