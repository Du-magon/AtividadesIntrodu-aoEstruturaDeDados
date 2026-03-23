public class PilhaSimplesMain {

    public static void main(String[] args) {

        System.out.println("Pilha Simples: ");

        PilhaSimples p = new PilhaSimples(5);

        p.adicionarElemento(10);
        p.adicionarElemento(20);
        p.adicionarElemento(30);

        p.exibirPilha();
        p.removerElemento();
        p.exibirPilha();
        p.removerElemento();
        p.exibirPilha();
    }
}