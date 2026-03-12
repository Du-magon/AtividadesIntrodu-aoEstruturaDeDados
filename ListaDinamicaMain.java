public class ListaDinamicaMain {

    public static void main(String[] args) {

        ListaDinamica lista = new ListaDinamica();

        lista.adicionarElemento("Arroz");
        lista.adicionarElemento("Feijão");
        lista.adicionarElemento("Batata");
        lista.adicionarElemento("Frango");
        lista.exibirElementos();

        lista.removerTodas("Batata");
        lista.exibirElementos();

        lista.contar();

        String[] comidas = {"Carne", "Leite", "Cenoura"};
        lista.adicionarVarios(comidas);
        lista.exibirElementos();

        lista.obter(2);

        lista.inserir(1, "Batata");
        lista.exibirElementos();

        lista.removerPorIndice(3);
        lista.exibirElementos();

        lista.limpar();
        lista.exibirElementos();

        lista.adicionarElemento("Arroz");
        lista.adicionarElemento("Feijão");
        lista.adicionarElemento("Batata");
        lista.adicionarElemento("Arroz");
        lista.exibirElementos();

        lista.ultimoIndiceDe("Arroz");

        lista.contarOcorrencias("Arroz");

        lista.substituir("Batata", "Cenoura");
        lista.exibirElementos();
    }
}