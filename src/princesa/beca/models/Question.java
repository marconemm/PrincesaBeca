package princesa.beca.models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private int score, correctAnswer;
    private List<String> answers;

    public Question(String question) {
        this.question = question;
        this.score = 10;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(String answer) {
        answers.add(answers.size(), answer);
    }

    public int getScore() {
        return score;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public boolean isCorrect(int opt) {
        return (opt - 1) == correctAnswer;
    }

    public String getCorrectAnswer() {
        return answers.get(correctAnswer);
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = (correctAnswer - 1);
    }
}
