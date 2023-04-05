package ru.sharipov.Interfaces;

import ru.sharipov.Classes.Answer;
import ru.sharipov.Enum.GameStatus;

public interface GameInterface {

    void start(Integer wordSize, Integer attempts);

    Answer inputValue(String value);

    GameStatus getGameStatus();

}
