package com.example.numply;

import java.util.*;

public class RandomNum {
    public static int[] generate(){
        Set<Integer> newAnswer = new HashSet<>(); // 랜덤으로 숫자를 중복 안 되게 담아줌
        while (newAnswer.size() < 3){
            int randomNum = (int) (Math.random()*9+1); // 랜덤으로 1 ~ 9 사이의 숫자 얻기
            newAnswer.add(randomNum);
        }
        int[] answer = new int[3];
         int i = 0;
        for (int num : newAnswer){
            answer[i++] = num;
        }
        return answer;
    }
    //배열 안에 특정 숫자가 있는지 확인하는 함수
    public static boolean contains(int[] arr, int num){
        for (int n : arr){
            if (n == num){
                return true;
            }
        }
        return false;
    }

}
