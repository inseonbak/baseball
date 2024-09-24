package com.example.numply;

public class InputValidator {

    // 입력값이 숫자로만 이루어졌는지 확인하는 함수
    public static boolean isNumeric(String input) {
        if (input.length() != 3) {
            return false; // 3자리 숫자가 아니면 false
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false; // 숫자가 아닌 문자가 있으면 false
            }
        }
        return true; // 모두 숫자면 true
    }

    // 중복된 숫자가 있는지 확인하는 함수
    public static boolean hasDuplicateNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true; // 중복된 숫자가 있으면 true
                }
            }
        }
        return false; // 중복된 숫자가 없으면 false
    }
}