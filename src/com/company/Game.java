package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private int correctAnswers = 0, noOfAnswers = 0;
    private int level = 1;
    private int randomNumber1, randomNumber2, result;
    private String name = "";
    private int currentStrike = 0;

    public void home() {
        System.out.println("Educational Game");
        System.out.println("_______________________________________");
        System.out.println("    WELCOME\n      to\n  THE EDU GAME");
        System.out.println("_______________________________________");
        System.out.println("Do you want to master math?!");
        System.out.println("_______________________________________");
        System.out.println("Press S to start the game");
        System.out.println("Press V to view the highest score");
        System.out.println("Press H for help");
        System.out.println("Press Q to quit");
        System.out.print("Please enter your choice here: ");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().toLowerCase().charAt(0);
        while (choice != 'q') {
            switch (choice) {
                case 's':
                    resetGame();
                    System.out.print("Please enter your name: ");
                    name = scanner.next();
                    for (int i = 0; i < 20; i++) {
                        generateQuestions();
                        int answer = scanner.nextInt();
                        checkAnswerAndEditScore(answer);
                    }
                    showScore();
                    break;
                case 'v':
                    showScore();
                    break;
                case 'h':
                    help();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
            System.out.println("Press S to start the game");
            System.out.println("Press V to view the highest score");
            System.out.println("Press H for help");
            System.out.println("Press Q to quit");
            System.out.print("Please enter your choice here: ");
            choice = scanner.next().toLowerCase().charAt(0);
        }

    }

    private void help() {
        System.out.println("This game has 3 levels of difficulty:" +
                "\nThe program starts with questions of low difficulty level (1 digit)." +
                "\nThe difficulty level moves to the medium level (2 digits) when you manage to answer 3 questions correctly in a row." +
                "\nFinally, you move to the hard level (3 digits) when you answer 3 questions correctly in a row.");
    }

    private void showScore() {
        double percentage;
        percentage = (double)correctAnswers / noOfAnswers * 100;
        System.out.println(name + " has the highest score: " + percentage + "%");
        if (percentage >= 75)
            System.out.println("Congratulations, you are ready to go to the next level!");
        else
            System.out.println("Please ask your teacher for extra help.");
    }

    private void generateQuestions() {
        if(level == 1) {
            int min = 1;
            int max = 9;
            Random random = new Random();
            randomNumber1 = random.nextInt(max - min + 1) + min;
            randomNumber2 = random.nextInt(max - min + 1) + min;
        }

        else if (level == 2) {
            int min = 10;
            int max = 99;
            Random random = new Random();
            randomNumber1 = random.nextInt(max - min + 1) + min;
            randomNumber2 = random.nextInt(max - min + 1) + min;
        }
        else if (level == 3) {
            int min = 100;
            int max = 999;
            Random random = new Random();
            randomNumber1 = random.nextInt(max - min + 1) + min;
            randomNumber2 = random.nextInt(max - min + 1) + min;
        }
        System.out.println("How much is " + randomNumber1 + " times " + randomNumber2);
        result = randomNumber1 * randomNumber2;
    }

    private void checkAnswerAndEditScore(int answer) {
        if (answer == result) {
            correctAnswers++;
            currentStrike ++;
            String[] messages = {
                    "Very good!",
                    "Excellent!",
                    "Nice work!",
                    "Keep up the good work!"
            };
            Random random = new Random();
            int randomIndex = random.nextInt(messages.length);
            System.out.println(messages[randomIndex]);
            System.out.println();
        }
        else {
            currentStrike = 0;
            String[] messages = {
                    "No. Please try again.",
                    "Wrong. Try once more.",
                    "Don't give up!",
                    "No. Keep trying."
            };
            Random random = new Random();
            int randomIndex = random.nextInt(messages.length);
            System.out.println(messages[randomIndex]);
            System.out.println();
        }
        noOfAnswers++;
        if (currentStrike == 3 && level < 3){
            currentStrike = 0;
            level++;
        }
    }

    private void resetGame(){
        correctAnswers = 0;
        noOfAnswers = 0;
        level = 1;
        currentStrike = 0;
        name = "";
    }

}
