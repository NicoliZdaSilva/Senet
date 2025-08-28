package Controller;
import Model.peca;

import java.util.ArrayList;
import java.util.Collections;

public class tabuleiroController {

    private ArrayList<peca> tabuleiro;
    private final int TAMANHO_TABULEIRO = 30;

    public void addPeca (peca peca){
        this.tabuleiro.add(peca);
    }

    public tabuleiroController() {
        this.tabuleiro = new ArrayList<peca>(Collections.nCopies(TAMANHO_TABULEIRO, null));

        for (int i = 0; i < 10; i++) {
            peca novaPeca;
            if (i % 2 != 0) {
                peca peca = new peca();
                peca.setCor("preto");
                peca.setPosicao(i + 1);
                addPeca(peca);

                peca.setNome("peca" + i);
            } else {
                peca peca1 = new peca();
                peca1.setCor("Cinza");
                peca1.setPosicao(i + 1);
                addPeca(peca1);

                peca1.setNome("peca" + i);
            }
        }
    }
        public int geraNumero() {
            int min = 1;
            int max = 5;
            int numeroAleatorio = (int) (Math.random() * (max - min + 1) + min);
            return numeroAleatorio;
        }

        public boolean mover(peca peca, int numeroAleatorio) {
            int posicaoInicial = peca.getPosicao() - 1;
            int posicaoFinal = posicaoInicial + numeroAleatorio;
            String minhaCor = peca.getCor();


            if (posicaoFinal >= TAMANHO_TABULEIRO || posicaoFinal < 0) {
                System.out.println("A peça saiu do jogo");
                return true;
            }

            if (tabuleiro.get(posicaoFinal) != null) {
                if (tabuleiro.get(posicaoFinal).getCor().equals(minhaCor)) {
                    System.out.println("Movimento inválido: A posição de destino já está ocupada por uma peça da sua cor.");
                    return false;
                }

                boolean pecaOponenteAnterior = false;
                if (posicaoFinal - 1 >= 0 && tabuleiro.get(posicaoFinal - 1) != null) {
                    if (!tabuleiro.get(posicaoFinal - 1).getCor().equals(minhaCor)) {
                        pecaOponenteAnterior = true;
                    }
                }

                boolean pecaOponentePosterior = false;
                if (posicaoFinal + 1 < TAMANHO_TABULEIRO && tabuleiro.get(posicaoFinal + 1) != null) {
                    if (!tabuleiro.get(posicaoFinal + 1).getCor().equals(minhaCor)) {
                        pecaOponentePosterior = true;
                    }
                }

                if (pecaOponenteAnterior || pecaOponentePosterior) {
                    System.out.println("Movimento inválido: Não é possível mover para essa posição por causa de uma peça do oponente adjacente.");
                    return false;
                }
            }

            this.tabuleiro.set(posicaoInicial, null);


            this.tabuleiro.set(posicaoFinal, peca);

            return true;
    }
}
//Falta a lógica de não poder passar quando há três peças e quando está nas últimas casas

