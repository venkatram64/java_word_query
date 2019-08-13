package com.venkat.service;

public class NumberAnalysis {

    private String[] unitsPlace = { "zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve","thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen" };

    private String[] tensPlace = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety" };


    public NumberAnalysis(){
    }

    public int wordLength(long number){
        int count = 0;
        while(number > 0){
            count++;
            number /= 10;
        }
        return count;
    }

    public String numberInWords(long number){
        String words = "";

        validateInpu(number);

        if (number == 0) {
            return "zero";
        }

        if ((number / 1000000) > 0) {
            words += numberInWords(number / 1000000) + " million ";
            number %= 1000000;
        }

        if ((number / 1000) > 0) {
            words += numberInWords(number / 1000) + " thousand ";
            number %= 1000;
        }

        if ((number / 100) > 0) {
            words += numberInWords(number / 100) + " hundred and ";
            number %= 100;
        }

        if (number > 0) {

            if (number < 20) {
                words += unitsPlace[(int)number];
            } else {
                words += tensPlace[(int)number / 10];
                words = words.trim();
                if ((number % 10) > 0) {
                    words = words.trim();
                    words += " " + unitsPlace[(int)number % 10];
                }
            }
        }
        return words.replaceAll("\\s+"," ");
    }

    private void validateInpu(long number) {
        if(number < 0){
            throw new RuntimeException("Negative number not valid.");
        }

        if (wordLength(number) > 9){
            throw new RuntimeException("Number is exceeded the limit.");
        }
    }

    public static void main(String[] args) {
        //56945781 = fifty six million nine hundred and forty five thousand seven hundred and eighty one
        NumberAnalysis numberAnalysis = new NumberAnalysis();
        //String words = numberAnalysis.numberToWord(2456789);
        //String words = numberAnalysis.numberToWord(999999999);
        //String words = numberAnalysis.numberInWords(56945781);
        String words = numberAnalysis.numberInWords(999999999);
        System.out.println(words);
    }
}
