package Campeonato;

public class Clube {
    public String nome;
    public int pontos = 0;
    public int saldoGols = 0;

    public Clube(String nome){
        this.nome = nome;
    }

    public void ganhar(int saldoPartida){

        this.pontos += 3;

        this.saldoGols += saldoPartida;

        return;
    }

    public void empatar(){
        this.pontos += 1;

        return;
    }

    public void perder(int saldoPartida){

        this.saldoGols += saldoPartida;

        return;
    }
}