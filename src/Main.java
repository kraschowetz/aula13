
/******************************************************************************

OBSERVAÇÃO:
A aula de hoje estávamos em uma sala sem IDE. Portanto tive que utilizar um compilador online,
que não oferece forma de leitura de arquivos. Por isso criamos as strings gigantes nesta classe.
Quero deixar claro que isso não é uma boa prática, apenas foi necessário pra podermos fazer a
aula de hoje. Aula que vem se tudo voltar ao normal vamos adaptar este código pra leitura de arquivos,
tornando ele mais flexível e escalável.

*******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileLoader l = new FileLoader(SortMethod.VITORIAS);
        System.exit(0);

        String string2003 = "Pos.,Equipes,P,J,V,E,D,GP,GC,SG,%\n" +
                "1,Cruzeiro,100,46,31,7,8,102,47,55,72\n" +
                "2,Santos,87,46,25,12,9,93,60,33,63\n" +
                "3,São Paulo,78,46,22,12,12,81,67,14,56\n" +
                "4,São Caetano,742,46,19,14,13,53,37,16,53\n" +
                "5,Coritiba,73,46,21,10,15,67,58,9,52\n" +
                "6,Internacional,721,46,20,10,16,59,57,2,52\n" +
                "7,Atlético Mineiro,72,46,19,15,12,76,62,14,52\n" +
                "8,Flamengo,66,46,18,12,16,66,73,–7,47\n" +
                "9,Goiás,65,46,18,11,17,78,63,15,47\n" +
                "10,Paraná,65,46,18,11,17,85,75,10,47\n" +
                "11,Figueirense,65,46,17,14,15,62,54,8,47\n" +
                "12,Atlético Paranaense,61,46,17,10,19,67,72,–5,44\n" +
                "13,Guarani,61,46,17,10,19,64,72,–8,44\n" +
                "14,Criciúma,60,46,17,9,20,57,69,–12,43\n" +
                "15,Corinthians,592,46,15,12,19,61,63,–2,42\n" +
                "16,Vitória,56,46,15,11,20,50,64,–14,40\n" +
                "17,Vasco da Gama,54,46,13,15,18,57,69,–12,39\n" +
                "18,Juventude,531,46,12,14,20,55,70,–15,38\n" +
                "19,Fluminense,522,46,13,11,22,52,77,–25,37\n" +
                "20,Grêmio,50,46,13,11,22,54,68,–12,36\n" +
                "21,Ponte Preta,501,2,46,11,18,17,63,73,–10,36\n" +
                "22,Paysandu,492,46,15,12,19,74,77,–3,35\n" +
                "23,Fortaleza,49,46,12,13,21,58,74,–16,35\n" +
                "24,Bahia,46,46,12,10,24,59,92,–33,33";

        String string2004 = "Pos.,Equipes,P,J,V,E,D,GP,GC,SG,%\n" +
                "1,Santos,89,46,27,8,11,103,58,45,64\n" +
                "2,Atlético Paranaense,86,46,25,11,10,93,56,37,62\n" +
                "3,São Paulo,82,46,24,10,12,78,43,35,59\n" +
                "4,Palmeiras,79,46,22,13,11,72,47,25,57\n" +
                "5,Corinthians,74,46,20,14,12,54,54,0,53\n" +
                "6,Goiás,72,46,21,9,16,81,68,13,52\n" +
                "7,Juventude,70,46,20,10,16,60,66,-6,51\n" +
                "8,Internacional,67,46,20,7,19,66,59,7,48\n" +
                "9,Fluminense,67,46,18,13,15,65,68,-3,48\n" +
                "10,Ponte Preta,64,46,19,7,20,43,73,-30,46\n" +
                "11,Figueirense,63,46,17,12,17,57,59,-2,46\n" +
                "12,Coritiba,62,46,15,17,14,53,48,-5,45\n" +
                "13,Cruzeiro,56,46,16,8,22,69,81,-12,40\n" +
                "14,Paysandu,56,46,14,14,18,56,76,-20,40\n" +
                "15,Paraná,54,46,15,9,22,52,73,-21,39\n" +
                "16,Vasco da Gama,54,46,14,12,20,64,68,-4,39\n" +
                "17,Flamengo,54,46,13,15,18,51,53,-2,39\n" +
                "18,São Caetano,532,46,23,8,15,65,49,15,38\n" +
                "19,Atlético Mineiro,53,46,12,17,17,60,66,-6,38\n" +
                "20,Botafogo,51,46,11,18,17,62,71,-9,37\n" +
                "21,Criciúma,50,46,13,11,22,61,78,-17,36\n" +
                "22,Guarani,49,46,11,16,19,43,55,-12,35\n" +
                "23,Vitória,48,46,13,9,24,68,87,-19,35\n" +
                "24,Grêmio,39,46,9,12,25,60,80,-20,28\n";

        String string2005 = "Pos.,Equipes,P,J,V,E,D,GP,GC,SG,%\n" +
                "1,Corinthians,81,42,24,9,9,87,59,28,64\n" +
                "2,Internacional,78,42,23,9,10,72,49,23,61\n" +
                "3,Goiás,74,42,22,8,12,68,51,17,59\n" +
                "4,Palmeiras,70,42,20,10,12,81,65,16,55\n" +
                "5,Fluminense,68,42,19,11,12,79,70,9,54\n" +
                "6,Atlético Paranaense,61,42,18,7,17,76,67,9,48\n" +
                "7,Paraná,61,42,17,10,15,59,51,8,48\n" +
                "8,Cruzeiro,60,42,17,9,16,73,72,1,47\n" +
                "9,Botafogo,59,42,17,8,17,57,56,1,47\n" +
                "10,Santos,59,42,16,11,15,68,71,–3,47\n" +
                "11,São Paulo,58,42,16,10,16,77,67,10,46\n" +
                "12,Vasco da Gama,56,42,15,11,16,74,84,–10,44\n" +
                "13,Fortaleza,55,42,16,7,19,58,64,–6,44\n" +
                "14,Juventude,55,42,15,10,17,66,72,–6,44\n" +
                "15,Flamengo,55,42,14,13,15,56,60,–4,44\n" +
                "16,Figueirense,53,42,14,11,17,65,72,–7,42\n" +
                "17,São Caetano,52,42,14,10,18,54,60,–6,41\n" +
                "18,Ponte Preta,51,42,15,6,21,63,80,–17,40\n" +
                "19,Coritiba,49,42,13,10,19,51,60,–9,39\n" +
                "20,Atlético Mineiro,47,42,13,8,21,54,59,–5,37\n" +
                "21,Paysandu,41,42,12,5,25,63,92,–29,32\n" +
                "22,Brasiliense,41,42,10,11,21,47,67,–20,32\n";

        // --Rodando 2003
        Map<String, Clube> mapaDeTimes = new HashMap<String, Clube>();

        String[] todosOsAnos = {
                string2003,
                string2004,
                string2005
        };

        for (String stringDoAno : todosOsAnos) {

            String[] linhas = stringDoAno.split("\n");
            int i = 0;
            for (String linha : linhas) {

                if (i > 0) {

                    String[] dados = linha.split(",");
                    int colocacao = Integer.valueOf(dados[0]);
                    String nomeDoTime = dados[1];
                    int gols = Integer.valueOf(dados[7]);

                    if (!mapaDeTimes.containsKey(nomeDoTime)) {
                        Clube novoClube = new Clube(nomeDoTime);
                        mapaDeTimes.put(nomeDoTime, novoClube);
                    }
                    Clube c = mapaDeTimes.get(nomeDoTime);
                    if (colocacao == 1) {
                        c.addTitulo();
                    }
                    c.addGolsPro(gols);
                }

                i++;
            }

        }

        // System.out.println(mapaDeTimes);

        List<Clube> listaDeClubes = new ArrayList<Clube>(mapaDeTimes.values());

        listaDeClubes.sort(Comparator.comparing(Clube::getGolsPro));
        // listaDeClubes.sort( Comparator.comparing(Clube::getTitulos) );
        Collections.reverse(listaDeClubes);

        for (Clube clube : listaDeClubes) {
            System.out.println(
                    clube.getNome() + " - gols = " + clube.getGolsPro()
            // clube.getNome() + " - títulos = " + clube.getTitulos()
            );
        }

    }
}