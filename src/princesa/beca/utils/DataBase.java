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

        q = new Question("Qual o fator mais importante para nosso seu relacionamento com seu príncipe, Beca?");
        q.addAnswer("As 24h do dia a dia");
        q.addAnswer("O sentido de rotação da Terra");
        q.addAnswer("A opinião de qualquer pessoas sobre vocês dois");
        q.addAnswer("A aprovação do seu príncipe por parte dos seus pais");
        q.setCorrectAnswer(4);
        questionList.add(q);

        //7:
        q = new Question("Quais os dois principais pilares da tua relação com seu príncipe?");
        q.addAnswer("Glúten e 5% de álcool");
        q.addAnswer("Confiança e liberdade");
        q.addAnswer("Xêros no cangote e nas bochechas");
        q.addAnswer("Ligações diárias e cobranças intensivas");
        q.setCorrectAnswer(2);
        questionList.add(q);

        //TROLL:
        q = new Question("Qual o log10 de 137?");
        q.addAnswer("2.14");
        q.addAnswer("4.23");
        q.addAnswer("3.24");
        q.addAnswer("2.24");
        q.setCorrectAnswer(1);
        questionList.add(q);

        q = new Question("Qual a raiz cúbica de 365?");
        q.addAnswer("7.15");
        q.addAnswer("10.25");
        q.addAnswer("3.75");
        q.addAnswer("9.28");
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
