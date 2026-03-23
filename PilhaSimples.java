class PilhaSimples {

    private int[] elementos;
    private int topo;
    private int tamanho;

    public PilhaSimples(int tamanho) {
        this.tamanho = tamanho;
        elementos = new int[tamanho];
        topo = -1;
    }

    public boolean pilhaCheia() {
        return topo == tamanho - 1;
    }

    public boolean pilhaVazia() {
        return topo == -1;
    }

    public void adicionarElemento(int valor) {
        if (pilhaCheia()) {
            System.out.println("Pilha cheia!");
            return;
        }
        topo++;
        elementos[topo] = valor;
        System.out.println("Elemento inserido: " + valor);
    }

    public void removerElemento() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia!");
            return;
        }
        int removido = elementos[topo];
        topo--;
        System.out.println("Elemento removido: " + removido);
    }

    public void exibirPilha() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia");
            return;
        }
        System.out.println("Pilha:");
        for (int i = topo; i >= 0; i--) {
            System.out.println(elementos[i]);
        }
    }
}