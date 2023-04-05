package ru.sharipov.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Answer {
    private String userInput;
    private Integer cows;
    private Integer bulls;
    private Integer attemptsValue;



}
