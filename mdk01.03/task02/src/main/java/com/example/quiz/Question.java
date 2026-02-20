package com.example.quiz;

public class Question {
    private String quest;
    private String[] answer;
    private int correct;

    public Question(String quest, String[] answer, int correct) {
        this.quest = quest;
        this.answer = answer;
        this.correct = correct;
    }

    public String getQuest() {
        return quest;
    }

    public String[] getAnswer() {
        return answer;
    }

    public int getCorrect() {
        return correct;
    }
}
