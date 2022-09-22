import princesa.beca.models.Game;
import princesa.beca.models.Question;
import princesa.beca.utils.DataBase;
import princesa.beca.utils.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final Utils utils = new Utils();
        final Game game = new Game();
        final DataBase db = new DataBase();
        int opt = 0;

        while (opt >= 0) {
            System.out.println("\n\nOlá!, Princesa Beca! =)\nVamos jogar um pouco?");
            opt = utils.validadeInpt(utils.setOpt(new String[]{"Sim", "Não"}), 2);

            if (opt < 0)
                System.out.println("Que pena que Você não aceitou. =(\nAté uma próxima!");
            else {

                utils.slowPrint("Que bom que aceitou! Deixe-me te explicar o jogo...\n", 1);
                utils.slowPrint(String.format("Bem, tenho um banco de perguntas aqui com %d perguntas de onde escolherei o " +
                        "número de perguntas que Você desejar responder.", db.getMaxQuestions()), 1);
                utils.slowPrint("Ao responde-las corretamente, acumularás pontos. =)", 1);
                utils.slowPrint("Se errar, os perderá. =(", 2);
                utils.slowPrint(String.format("\nSendo assim, me diga um número entre 4 e %d de perguntas que desejas " +
                        "responder:", db.getMaxQuestions()), 1);
                opt = utils.setOpt();
                utils.slowPrint(String.format("\nÓtimo! Então deixe-me escolher suas %d perguntas...", opt), 2);
                utils.slowPrint("Pronto!", 1);
                utils.slowPrint("Há! Saiba que suas respostas influenciarão no fim do jogo.", 1);
                utils.slowPrint("Logo, pense bem antes de cada resposta...\n", 1);

                if (game.gameStart() == 1) {
                    final List<Question> selectedQuestionsList = db.getRandomQuestions(2);

                    for (int i = 0; i <= selectedQuestionsList.size(); i++) {
                        System.out.println(String.format("\nPergunta %d:", i + 1));
                        final boolean isCorrect = utils.showNextQuestion(selectedQuestionsList);

                        if (isCorrect) {
                            game.setTotalScore(game.getTotalScore() + selectedQuestionsList.get(0).getScore());
                            game.congrats();

                        } else {
                            game.setTotalScore(game.getTotalScore() - (selectedQuestionsList.get(0).getScore() - 5));
                            game.sorry();
                        }

                        selectedQuestionsList.remove(0);
                    }

                    game.finish(2);
                    opt = -1; //Finish the game.
                }
            }
        }
    }
}
