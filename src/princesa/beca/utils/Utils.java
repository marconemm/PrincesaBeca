package princesa.beca.utils;

import princesa.beca.models.Question;

import java.util.Scanner;

public class Utils {

    private final Scanner scanner;

    public Utils() {
        this.scanner = new Scanner(System.in);
    }

    public int setOpt(String[] optList) {
        try {
            printOpts(optList);
            int result = Integer.parseInt(scanner.nextLine());

            if (result > optList.length || result < 0)
                throw new NumberFormatException();

            return result;
        } catch (NumberFormatException nfe) {
            System.out.println("Opção inválida. Por favor, informe uma opção válida.");
            return setOpt(optList);
        }
    }

    public int setOpt() {
        try {
            int result = Integer.parseInt(scanner.nextLine());

            if (result > new DataBase().getMaxQuestions() || result < 1)
                throw new NumberFormatException();

            return result;
        } catch (NumberFormatException nfe) {
            System.out.println("Opção inválida. Por favor, informe uma opção válida.");
            return setOpt();
        }
    }

    public int validadeInput(int opt, int edge) {
        if (opt < edge)
            return opt;

        return -1;
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean showNextQuestion(Question q) {
        printQuestion(q.getQuestion());
        final int opt = setOpt(q.getAnswers().toArray(new String[4]));

        return q.isCorrect(opt);
    }

    public void slowPrint(String txt, int delay) {
        System.out.println(txt);
        wait(delay);
    }

    private void printQuestion(String question) {
        question = String.format("%s", question);
        System.out.println(question);
    }

    private void printOpts(String[] optList) {
        System.out.println("\n_ _ _ _");
        for (int i = 0; i < optList.length; i++)
            System.out.println(String.format("%d-) %s", i + 1, optList[i]));
    }
}
