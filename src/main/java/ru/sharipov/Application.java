package ru.sharipov;

import ru.sharipov.Classes.Abstract.Game;
import ru.sharipov.Classes.Answer;
import ru.sharipov.Classes.GameTypes.EnGame;
import ru.sharipov.Classes.GameTypes.NumberGame;
import ru.sharipov.Classes.GameTypes.RuGame;
import ru.sharipov.Enum.GameStatus;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("============== Добро пожаловать в игру Быки и Коровы ==============");
        System.out.println();
        System.out.println("Выберите тип игры: ");
        System.out.println();
        System.out.println("Введите 1 для игры с числами.");
        System.out.println();
        System.out.println("Введите 2 для игры с русскими словами.");
        System.out.println();
        System.out.println("Введите 3 для игры с английскими словами.");
        System.out.println();
        System.out.print("Введите значение сюда: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        while (input < 1 || input > 3){
            System.out.print("Введите пожалуйста цифру от 1 до 3: ");
            input = scanner.nextInt();
            scanner.nextLine();
        }
        Game game = null;
        int wordSize = 0;
        int attempts = 0;
        switch (input) {
            case 1:
                game = new NumberGame();
                System.out.println();
                System.out.println("============== Настройки игры ==============");
                System.out.println();
                System.out.print("Введите длину числа: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            case 2:
                game = new RuGame();
                System.out.println();
                System.out.println("============== Настройки игры ==============");
                System.out.println();
                System.out.print("Введите длину слова: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            case 3:
                game = new EnGame();
                System.out.println();
                System.out.println("============== Настройки игры ==============");
                System.out.println();
                System.out.print("Введите длину слова: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            default:
                System.out.println("Такую игру еще не создали!");
        }
        game.start(wordSize, attempts);
        int attemptCount = 1;
        while (game.getGameStatus().equals(GameStatus.START)) {
            System.out.println();
            System.out.println("====================");
            System.out.println("     Попытка " + attemptCount++);
            System.out.println();
            System.out.print("Введите значение: ");
            String answer = scanner.nextLine();
            while (answer.length() != game.getWordSize()){
                System.out.println();
                System.out.print("Введите пожалуйста значение длиной " + game.getWordSize() +  " символов(а): ");
                answer = scanner.nextLine();
            }
            if (answer.equals(game.getWord())) {
                game.win();
                System.out.println();
                System.out.println("Вы Победили! Значение, которое загадал компьютер: " + game.getWord());
            }
            Answer answerGame = game.inputValue(answer);
            if (game.getAttempts() == 0 && game.getGameStatus() == GameStatus.START) {
                game.lose();
                System.out.println();
                System.out.println("Игра окончена! Вы использовали все попытки!");
            } else if (game.getGameStatus() != GameStatus.WIN
                    && game.getGameStatus() != GameStatus.LOSE) {
                System.out.println();
                System.out.println("Коров: " + answerGame.getCows());
                System.out.println("Быков: " + answerGame.getBulls());
            }
        }
        scanner.close();
    }
}

