public class PilhaDinamicaMain {

    public static void main(String[] args) {

        PilhaDinamica p = new PilhaDinamica();

        p.adicionarElemento("30");
        p.adicionarElemento("20");
        p.adicionarElemento("10");

        p.exibirElementos();
        p.removerElemento();
        p.exibirElementos();
    }
}