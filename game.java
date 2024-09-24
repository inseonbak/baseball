package com.example.numply;

import javax.swing.*;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
            System.out.println("1. 게임 시작하기");
            System.out.println("2. 게임 기록 보기");
            System.out.println("3. 종료하기");
            System.out.print("선택: ");

            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    startGame(scanner);
                    break;
                case "2":
                    System.out.println("이 기능은 아직 구현하지 못했습니다.");
                    break;
                case "3":
                    System.out.println("게임 종료");
                    break;
                default:
                    System.out.println("올바르지 않은 선택입니다. 다시 입력해주세요");
            }
        }
    }

    private static void startGame(Scanner scanner) {
        int[] randomNumbers = RandomNum.generate();
        int attempts = 0;
        boolean isCorrect = false;

        System.out.println("숫자 야구 게임을 시작합니다. 1부터 9까지의 숫자 중에서 3자리 숫자를 맞춰보세요");

        while (!isCorrect) {
            System.out.println("숫자 3자리를 입력하세요 (예: 123):");
            String input = scanner.nextLine();

        // 입력값이 숫자로만 이루어졌는지 확인
        if (!InputValidator.isNumeric(input)) {
            System.out.println("올바르지 않은 입력값입니다 다시 시도해주세요");
            continue;
        }
        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = input.charAt(i) - '0';
        }

        // 중복 숫자 체크
        if (InputValidator.hasDuplicateNumbers(userNumbers)) {
            System.out.println("중복된 숫자가 있습니다. 다시 입력해주세요.");
        }

            attempts++;

            int[] result = checkStrikeBallOut(randomNumbers, userNumbers);
            int strike = result[0];
            int ball = result[1];
            int out = result[2];

            if (strike == 0 && ball == 0) {
                System.out.println("아웃입니다!");
            } else {
                System.out.println("스트라이크: " + strike + ", 볼: " + ball);
            }

            if (strike == 3) {
                isCorrect = true;
                System.out.println("정답입니다! 총 시도 횟수: " + attempts);
            }
        }
    }

    // 스트라이크, 볼, 아웃을 계산하는 함수
    public static int[] checkStrikeBallOut(int[] randomNumbers, int[] userNumbers) {
        int strike = 0;
        int ball = 0;
        int out = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumbers[i] == userNumbers[i]) {
                strike++;
            } else if (RandomNum.contains(randomNumbers, userNumbers[i])) {
                ball++;
            }
        }

        // 스트라이크와 볼이 모두 0일 경우 아웃
        if (strike == 0 && ball == 0) {
            out = 1; // 아웃 처리
        }

        return new int[]{strike, ball, out};
    }
}

