public class Clube {
    private int titulos = 0;
    private int golsPro = 0, golsContra;
    private String nome;
    private int vitorias, empates, derrotas;
    
    Clube( String nome ){
        this.nome = nome;
    }
    
    public void addTitulo(){
        this.titulos++;
    }
    
    public void addGolsPro( int gols ){
        this.golsPro += gols;
    }
    
    public int getTitulos(){
        return this.titulos;
    }
    
    public int getGolsPro(){
        return this.golsPro;
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getGolsContra() {
        return this.golsContra;
    }

    public void addGolContra(int golsContra) {
        this.golsContra += golsContra;
    }

    public void addVitorias(int vitorias) {
        this.vitorias += vitorias;
    }

    public void addDerrotas(int derrotas) {
        this.derrotas += derrotas;
    }

    public void addEmpates(int empates) {
        this.empates += empates;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    @Override
    public String toString() {
        return String.format(
            "%s, %d títulos, %d gols, %d vitórias, %d empates, %d derrotas, %d gols contra",
            nome, titulos, golsPro, vitorias, empates, derrotas, golsContra
        );
    }

}