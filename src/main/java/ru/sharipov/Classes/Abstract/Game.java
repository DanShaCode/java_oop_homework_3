package ru.sharipov.Classes.Abstract;

import lombok.Data;
import ru.sharipov.Classes.Answer;
import ru.sharipov.Enum.GameStatus;
import ru.sharipov.Interfaces.GameInterface;

import java.util.List;
import java.util.Random;

@Data
public abstract class Game implements GameInterface {
    private Integer wordSize;
    private Integer attempts;
    private String word;
    GameStatus gameStatus = GameStatus.INIT;

    @Override
    public void start(Integer wordSize, Integer attempts) {
        this.wordSize = wordSize;
        this.attempts = attempts;
        word = generateWord();
        this.gameStatus = GameStatus.START;
    }

    public void lose(){
        gameStatus = GameStatus.LOSE;
    }

    public void win(){
        gameStatus = GameStatus.WIN;
    }

    @Override
    public Answer inputValue(String value) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < word.length(); i++) {
            if(value.charAt(i) == word.charAt(i)){
                bulls++;
            }
            Character character = value.charAt(i);
            if (word.contains(character.toString())){
                cows++;
            }
        }
        attempts--;
        return new Answer(value, cows, bulls, attempts);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    private String generateWord(){
        Random random = new Random();
        List<String> charList = generateCharList();
        String resWord = "";
        for (int i = 0; i < wordSize; i++) {
            int randomIndex = random.nextInt(charList.size());
            resWord = resWord.concat(charList.get(randomIndex));
            charList.remove(randomIndex);
        }
        return resWord;
    }
    public abstract List<String> generateCharList();

}
