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
        int result = utils.validadeInpt(utils.setOpt(new String[]{"Sim", "Não"}), 2);
        while (result != 1) {
            System.out.println("Ok! Me avise quando pudermos continuar...");
            result = utils.validadeInpt(utils.setOpt(new String[]{"Podemos continuar...", "Aguarde mais um pouco..."}), 2);
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
        this.totalScore = totalScore;
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
        System.out.println(separator);
        if (totalScore > (questionAmount * .7)) {
            System.out.println("PARABÉNS, Princesa Beca!!!");
            utils.wait(1);
            System.out.println(String.format("\nAo terminar todas estas %d perguntas, Você atingiu um total de %d pontos!",
                    questionAmount, totalScore));
            utils.wait(2);
            System.out.println("E com toda essa pontuação, seu Principe gostaria que Você visualizasse");
            System.out.println("o video que irei abrir para Você daqui a uns segundinhos...");
            utils.wait(1);
            System.out.println("(aperte o \"Play\".)");
            utils.wait(4);
            try {
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI uri = new URI("https://drive.google.com/file/d/1ThDA9ty9ksvhLsKZ-M1boEhU_z0yGUBP/view?usp=sharing");
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //TODO: the "bad path"...
        }
        System.out.println(separator);
    }
}
