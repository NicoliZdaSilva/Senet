package Model;

public class peca {

    String cor;
    int posicao;
    String nome;

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if (cor.equals("Preto") || cor.equals("Cinza")) {
            this.cor = cor;
        } else {
            System.out.println("Cor inválida");
        }
    }
        public void peca(String cor,int posicao){
            if (cor.equals("Preto") || cor.equals("Cinza")) {
                this.cor = cor;
            } else {
                System.out.println("Cor inválida");
            }
        }
    }