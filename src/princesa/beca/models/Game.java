package princesa.beca.models;

import princesa.beca.utils.Utils;

import java.awt.*;
import java.net.URI;

public class Game {
    private Utils utils;
    private int totalScore;
    private final String separator;

    public Game() {
        utils = new Utils();
        separator = "###";
    }

    public int gameStart() {
        System.out.println("Podemos continuar?");
        int result = utils.validadeInput(utils.setQuestionsAmount(new String[]{"Sim", "Não"}), 2);
        while (result != 1) {
            System.out.println("Ok! Me avise quando pudermos continuar...");
            result = utils.validadeInput(utils.setQuestionsAmount(new String[]{"Podemos continuar...", "Aguarde mais um pouco..."}), 2);
        }
        System.out.println(separator);
        System.out.println("Então vamos começar. Boa sorte, Princesa Beca!");
        System.out.println(String.format("Sou Placar atual é: %d pontos", getTotalScore()));
        System.out.println(separator);

        return result;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = Math.max(totalScore, 0);
    }

    public void congrats() {
        System.out.println(separator);
        System.out.println("Certa resposta, Beca!");
        System.out.println(String.format("Seu placar atual é: %d pontos", getTotalScore()));
        System.out.println(separator);
    }

    public void sorry() {
        System.out.println(separator);
        System.out.println("Ahhh... Você errou essa, Beca. =(");
        System.out.println(String.format("Seu placar atual é: %d pontos", getTotalScore()));
        System.out.println(separator);
    }

    public void finish(int questionAmount) {
        final int delay1 = 1, delay2 = 3;
        final int minScore = (int) ((questionAmount * .7) * new Question("").getScore());

        System.out.println(separator);

        if (totalScore >= minScore) {
            utils.slowPrint("PARABÉNS, Princesa Beca!!!", delay1);
            utils.slowPrint(String.format("\nAo terminar todas estas %d perguntas, Você atingiu um total de %d pontos!",
                    questionAmount, totalScore), delay2);

            utils.slowPrint("\nE com toda essa pontuação, seu Príncipe gostaria que Você visualizasse", delay2);

        } else {
            utils.slowPrint("QUE PENA, Princesa Beca!!!", delay1);
            utils.slowPrint(String.format("\nInfelizmente, ao terminar todas estas %d perguntas, Você atingiu apenas %d pontos!",
                    questionAmount, totalScore), delay2);
            utils.slowPrint("\nMas, dizem por aí que quem procura perfeição nas pessoas, vive frustrado(a), neh?", delay2);
            utils.slowPrint("\nE mesmo com essa pontuação, seu Príncipe gostaria que Você visualizasse", delay2);
        }

        openFinalVideo();
        System.out.println(separator);
    }

    private void openFinalVideo() {
        utils.slowPrint("o video que irei abrir para Você daqui a uns segundinhos...", 1);
        utils.slowPrint("(aperte o \"Play\".)", 8);

        try {
            final Desktop desktop = java.awt.Desktop.getDesktop();
            final URI uri = new URI("https://drive.google.com/file/d/1ThDA9ty9ksvhLsKZ-M1boEhU_z0yGUBP/view?usp=sharing");

            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
