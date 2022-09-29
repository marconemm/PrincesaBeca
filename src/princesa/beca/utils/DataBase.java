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

        q = new Question("Em que dia Você deu de cara com seu Príncipe pela primeira vez?");
        q.addAnswer("18/08/2022");
        q.addAnswer("18/09/2022");
        q.addAnswer("18/10/2022");
        q.addAnswer("22/08/2022");
        q.setCorrectAnswer(2);
        questionList.add(q);

        q = new Question("Princesa Beca, com quantos beijos seu Príncipe costuma se despedir de Você?");
        q.addAnswer("Incontáveis...");
        q.addAnswer("10");
        q.addAnswer("4 (Beijo, beijo, beijo, beijo!)");
        q.addAnswer("2");
        q.setCorrectAnswer(3);
        questionList.add(q);

        q = new Question("Em que dia Você deu de cara com seu Príncipe pela primeira vez?");
        q.addAnswer("18/08/2022");
        q.addAnswer("18/09/2022");
        q.addAnswer("18/10/2022");
        q.addAnswer("22/08/2022");
        q.setCorrectAnswer(2);
        questionList.add(q);

        q = new Question("Qual o perfume que o CoNe usava na note que Você o conheceu?");
        q.addAnswer("Quiééé, Mulher!? Surtada!!!");
        q.addAnswer("Escândalo");
        q.addAnswer("Essencial Oud");
        q.addAnswer("Essência de Scandal");
        q.setCorrectAnswer(3);
        questionList.add(q);

        //TROLL:
        q = new Question("Qual o log10 de 137?");
        q.addAnswer("2.1367205671564");
        q.addAnswer("4.2267205671564");
        q.addAnswer("3.2367205671564");
        q.addAnswer("2.2367205671564");
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
