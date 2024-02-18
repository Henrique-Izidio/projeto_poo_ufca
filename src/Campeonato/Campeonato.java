package Campeonato;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Campeonato.Clube;

@SuppressWarnings("unused")

public class Campeonato {
    ArrayList<Clube> clubes = new ArrayList<Clube>();

    public Campeonato(ArrayList<Clube> clubes){
        this.clubes = clubes;
    }

    public void jogarCampeonato() {
        clubes.forEach((clube_1) -> {

            clubes.forEach((clube_2)-> {

                if(clube_1.nome != clube_2.nome){

                    jogarPartida(clube_1, clube_2);

                }

            });

        });

        return;
    }

    private void jogarPartida(Clube clube_1, Clube clube_2){

        Random rand = new Random();

        int golsClube1 = rand.nextInt(6);
        int golsClube2 = rand.nextInt(6);

        if (golsClube1 > golsClube2) {
            clube_1.ganhar(golsClube1 - golsClube2);

            clube_2.perder(golsClube1 - golsClube2);
            
        }else if (golsClube1 < golsClube2) {
            clube_1.perder(golsClube1 - golsClube2);
            
            clube_2.ganhar(golsClube2 - golsClube1);
            
        }else {
            clube_1.empatar();
            clube_2.empatar();
        }

        return;

    }

    public ArrayList<String> getClassificacao(){

        ordenar(this.clubes);

        ArrayList<String> classifacacao = new ArrayList<String>();

        for (int i = 0; i < clubes.size(); i++) {
            classifacacao.add((i+1) + "º lugar: " + clubes.get(i).nome + "\n");
        }

        return classifacacao;

    }

    private ArrayList<Clube> ordenar(ArrayList<Clube> clubes){

        if(clubes.size() == 1) return clubes;

        List<Clube> listClubes = clubes.subList(0, clubes.size() / 2);
        
        ArrayList<Clube> clubes_e = new ArrayList<Clube>(listClubes);
        
        listClubes = clubes.subList(clubes.size() / 2, clubes.size());
        
        ArrayList<Clube> clubes_d = new ArrayList<Clube>(listClubes);

        clubes_e = ordenar(clubes_e);

        clubes_d = ordenar(clubes_d);

        int counter_e = 0;
        int counter_d = 0;

        ArrayList<Clube> novaOrdem = new ArrayList<Clube>();

        for(int i = 0; i < clubes.size(); i++){

            if (clubes_e.size() == counter_e) {
                novaOrdem.add(clubes_d.get(counter_d));
                counter_d++;
                continue;
            }else if (clubes_d.size() == counter_d) {
                novaOrdem.add(clubes_e.get(counter_e));
                counter_e++;
                continue;
            }
            
            Clube clube_1 = clubes_e.get(counter_e);
            Clube clube_2 = clubes_d.get(counter_d);
            
            if (clube_1.pontos < clube_2.pontos) {

                novaOrdem.add(clube_2);

                counter_d++;
            }else if(clube_1.pontos > clube_2.pontos){
                novaOrdem.add(clube_1);

                counter_e++;                
            }else {

                if (clube_1.saldoGols < clube_2.saldoGols) {

                    novaOrdem.add(clube_2);
    
                    counter_d++;
                }else {
                    novaOrdem.add(clube_1);
    
                    counter_e++;                
                }

            }

        }

        clubes = novaOrdem;

        return clubes;
    }

    public Clube getCampeao(){
        return this.clubes.get(0);
    }
}
