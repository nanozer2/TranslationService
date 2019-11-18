package com.zero.number.translation.service;

import org.springframework.stereotype.Service;

import static com.zero.number.translation.domain.Constants.*;

@Service
public class TranslationService {

    public static String convert(Long number){

        String numberInWords = "";
        boolean isNegative = false;
        int index = 0;

        if (number == null){
            return "Number can not be empty";
        }
        if (number < 0){
            isNegative = true;
            number *= -1;
        }

        if (number == 0){
            numberInWords += TO_NINE[0];
            return changeFirstLetterToUpper(numberInWords.trim());
        }

        do {
            int modNum = (int) (number % 1000);
            if (modNum != 0){
                String strTmp = getThreeDigitNumber(modNum,!(index > 0));
                numberInWords = strTmp + PLACED[index] + numberInWords;
            }
            index++;
            number = number/1000;


        }while (number>0);

        if (numberInWords.startsWith(AND))
            numberInWords = numberInWords.substring(4);

        return isNegative? NEGATIVE + numberInWords.trim()  : changeFirstLetterToUpper(numberInWords).trim();
    }
    private static String changeFirstLetterToUpper(String str){
        if (!str.trim().isEmpty()){
            String firstLetter = "" + str.charAt(0);
            str = firstLetter.toUpperCase() + str.substring(1);
        }

        return str;
    }

    private static String getThreeDigitNumber(int number, boolean isFirstThreeDigit){
        String twoDigitNumber = "";

        int num = number % 100;
        if (num < 10){
            twoDigitNumber += TO_NINE[num];
        }else if (num < 20){
            twoDigitNumber += TO_NINETEEN[num%10];
        }else {
            if (TO_NINE[num%10].contains(TO_NINE[0])){
                twoDigitNumber += TENS[num/10];
            }else {
                twoDigitNumber += TENS[num/10] + TO_NINE[num%10];
            }
        }
        if (number > 99 ){
            String hundredNumber = TO_NINE[number/100] + HUNDRED;
            if (twoDigitNumber.isEmpty() || twoDigitNumber.contains(TO_NINE[0]))
                return hundredNumber;
            else {
                if (isFirstThreeDigit){
                    return hundredNumber + AND + twoDigitNumber;
                }else {
                    return hundredNumber + twoDigitNumber;
                }
            }

        }

        if (isFirstThreeDigit){
            return AND + twoDigitNumber;
        }else {
            return twoDigitNumber;
        }
    }

}
