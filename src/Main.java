import java.util.ArrayList;
import java.util.Scanner;

import Campeonato.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Clube> clubes = new ArrayList<Clube>();

        while (true) {
            
            System.out.println("Insira o nome do clube para inscreve-lo no campeonato:");
            System.out.println("(Digite 0 para parar de inserir clubes)");

            String clubeNome = scan.nextLine();

            if(clubeNome.equals("0")) break;
            
            clubes.add(new Clube(clubeNome));

        }

        scan.close();

        Campeonato campeonato = new Campeonato(clubes);

        boolean jogou = campeonato.jogarCampeonato();

        if(!jogou) return;

        ArrayList<String> classificacao = campeonato.getClassificacao();

        Clube campeao = campeonato.getCampeao();

        System.out.println("===========================");
        System.out.println("!!!PARABENS AO VENCEDOR!!!");
        System.out.println(campeao.nome);
        System.out.println("Pontos: " + campeao.pontos);
        System.out.println("Saldo de Gols: " + campeao.saldoGols);

        System.out.println("===========================");
        System.out.println("====== Classificação ======");
        System.out.println("===========================");

        classificacao.forEach((item) -> {
            System.out.println(item);
        });

        return;
        
    }
}
