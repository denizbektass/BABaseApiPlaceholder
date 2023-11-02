package com.bilgeadam.BABaseApiPlaceholder.utility;

public class Helpers {
    public static String handleTurkish(String input) {
        char [] turkishLetter= {'İ', 'ı', 'ş', 'Ş', 'ç', 'Ç', 'ğ', 'Ğ', 'ü','Ü','ö','Ö'};
        char [] englishLetter= {'I', 'i', 's', 'S', 'c', 'C', 'g', 'G', 'u','U','o','O'};
        for (int count = 0; count < englishLetter.length; count++) {
            input=input.replace(turkishLetter[count], englishLetter[count]);
        }
        return input;
    }
}
