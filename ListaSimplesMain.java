public class ListaSimplesMain {

    public static void main(String[] args) {

        ListaSimples lista = new ListaSimples(7);

        lista.adicionarElemento("Arroz");
        lista.adicionarElemento("Feijão");
        lista.adicionarElemento("Batata");
        lista.adicionarElemento("Arroz");

        lista.exibirElementos();

        lista.contar();

        lista.obter(1);

        lista.inserir(2, "Carne");
        lista.exibirElementos();

        lista.removerPorIndice(3);
        lista.exibirElementos();

        lista.substituir("Arroz", "Macarrão");
        lista.exibirElementos();

        String[] novos = {"Leite", "Frango", "Cenoura"};
        lista.adicionarVarios(novos);
        lista.exibirElementos();

        lista.removerTodas("Macarrão");
        lista.exibirElementos();

        lista.contarOcorrencias("Leite");

        lista.ultimoIndiceDe("Leite");

        lista.limpar();
        lista.exibirElementos();
    }
}