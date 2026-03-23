public class PilhaDinamica {

    No topo;

    public PilhaDinamica() {
        this.topo = new No(null);
        System.out.println("Pilha Dinamica:");
    }

    private boolean existeTopo() {
        return this.topo.getConteudo() != null;
    }

    public void adicionarElemento(String conteudo) {
        if (!existeTopo()) {
            this.topo.setConteudo(conteudo);
            System.out.println("Elemento " + conteudo + " adicionado ao topo da pilha.");
        } else {
            No novoNo = new No(conteudo);
            novoNo.setProx(topo);
            topo = novoNo;
            System.out.println("Elemento " + conteudo + " empilhado.");
        }
    }

    public void removerElemento() {

        if (!existeTopo()) {
            System.out.println("Pilha vazia.");
            return;
        }
        String removido = topo.getConteudo();
        topo = topo.getProx();
        if (topo == null) {
            topo = new No(null);
        }
        System.out.println("Elemento " + removido + " removido do topo.");
    }

    public void exibirElementos() {
        if (!existeTopo()) {
            System.out.println("Pilha vazia.");
            return;
        }
        No aux = topo;
        System.out.println("Elementos da pilha:");
        while (aux != null) {
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
        }
    }
}
