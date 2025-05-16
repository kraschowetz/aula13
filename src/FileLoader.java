import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FileLoader {

    Scanner scan = null;
    HashMap<String, Clube> clubes = new HashMap<String, Clube>();

    public List<Clube> loadFromFile(String path) {
        File file;

        file = new File(path);
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        var lista = new ArrayList<Clube>();
        scan.nextLine();

        int i = 0;
        while(scan.hasNextLine()) {
            String s = scan.nextLine();

            lista.add(new Clube(s.split(",")[1]));
            lista.get(i).addGolsPro(Integer.parseInt(s.split(",")[7]));
            lista.get(i).addVitorias(Integer.parseInt(s.split(",")[4]));
            lista.get(i).addDerrotas(Integer.parseInt(s.split(",")[6]));
            lista.get(i).addEmpates(Integer.parseInt(s.split(",")[5]));
            if(i == 0) {
                lista.get(i).addTitulo();
            }

            i++;
        }

        return lista;
    }

    public FileLoader(SortMethod metodo) {

        for(int i = 2003; i < 2024; i++) {
            var lista = loadFromFile(String.format("dados/%d.txt", i));       

            for(Clube c : lista) {
                if(clubes.get(c.getNome()) == null) {
                    clubes.put(c.getNome(), c);
                }
                else {
                    clubes.get(c.getNome()).addGolsPro(c.getGolsPro());
                    if(c.getTitulos() > 0) {
                        clubes.get(c.getNome()).addTitulo();
                    }
                }
            }
        }

        List<Clube> _clubes = new ArrayList<Clube>(clubes.values());

        switch(metodo) {
            case GOLS:
                _clubes.sort(Comparator.comparing(Clube::getGolsPro));
                break;
            case TITULOS:            
                _clubes.sort(Comparator.comparing(Clube::getTitulos));
                break;
            case VITORIAS:
                _clubes.sort(Comparator.comparing(Clube::getVitorias));
                break;
            case EMPATES:
                _clubes.sort(Comparator.comparing(Clube::getEmpates));
                break;
            case DERROTAS:
                _clubes.sort(Comparator.comparing(Clube::getDerrotas));
                break;

        }

        Collections.reverse(_clubes);
        for(Clube c : _clubes) {
            System.out.println(c);
        }
    }
}
