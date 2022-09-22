package princesa.beca.utils;

import princesa.beca.models.Question;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    final private List<Question> questionList;

    public DataBase() {
        questionList = new ArrayList<>();
        Question q = new Question("Qual deve ser a cor dos olhos de nossos filhos?");
        q.addAnswer("Azuis");
        q.addAnswer("Tanto faz");
        q.addAnswer("Verdes");
        q.addAnswer("Castanhos");
        q.setCorrectAnswer(2);
        questionList.add(q);

        q = new Question("Quando o seu Principe percebeu que poderia obter o seu primeiro \"sim\"?");
        q.addAnswer("Na nossa primeira dança");
        q.addAnswer("Dando ouvidos ao Sean");
        q.addAnswer("Fazendo uma leitura das estrelas");
        q.addAnswer("Tentando a sorte");
        q.setCorrectAnswer(1);
        questionList.add(q);
    }

    public List<Question> getRandomQuestions(int amount) {
        final List<Question> result = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            final int randomIndex = Math.max((int) Math.round(Math.random() * (questionList.size() - 1)), 0);

            result.add(questionList.get(randomIndex));
            questionList.remove(randomIndex);
        }

        return result;
    }

    public int getMaxQuestions() {
        return questionList.size();
    }
}
