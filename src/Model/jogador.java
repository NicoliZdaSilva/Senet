package Model;

import java.util.ArrayList;

public class jogador {
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    ArrayList<peca> pecas = new ArrayList<>();

    public void addPeca (peca peca){
        if (pecas.size() <= 5) {
            pecas.add(peca);
        }
        else{
            System.out.println ("O jogador já recebeu 5 peças");
        }
    }
    public void removePeca(peca peca){
        if (!pecas.isEmpty()){
            pecas.remove(peca);
        }
        else {
            System.out.println("Todas as peças  estão fora do jogo");
        }
    }

}
