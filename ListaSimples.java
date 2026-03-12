public class ListaSimples implements ListaOperacoes {
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento) {
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if (buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if (!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if (this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                System.out.println("Removendo elemento: " + lista[i] + " da posição " + i);
                lista[i] = null;
                removidos++;
            }
        }
        System.out.println("\nTotal de elementos removidos: " + removidos);
        return removidos;
    }
    @Override
    public int contar() {
        int cont = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                cont++;
            }
        }
        System.out.println("\nTotal de elementos na lista: " + cont);
        return cont;
    }
    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (int i = 0; i < elementos.length; i++) {
            if (!estaCheia()) {
                int pos = encontrarPosicaoVazia();
                lista[pos] = elementos[i];
                System.out.println("Elemento " + elementos[i] + " adicionado na posição " + pos);
                adicionados++;
            }
        }
        System.out.println("\nTotal de elementos adicionados: " + adicionados);
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }
        System.out.println("\nElemento encontrado na posição " + indice + ": " + lista[indice]);
        return lista[indice];
    }
    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= lista.length) {
            System.out.println("\nÍndice inválido.");
            return false;
        }
        if (estaCheia()) {
            return false;
        }
        for (int i = lista.length - 1; i > indice; i--) {
            lista[i] = lista[i - 1];
        }
        lista[indice] = elemento;
        System.out.println("Elemento " + elemento + " inserido na posição " + indice);
        return true;
    }
    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= lista.length) {
            System.out.println("Índice inválido.");
            return null;
        }
        String removido = lista[indice];
        lista[indice] = null;
        System.out.println("Elemento " + removido + " removido da posição " + indice);
        return removido;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = null;
        }
        System.out.println("\nTodos os elementos da lista foram removidos.");
    }
    @Override
    public int ultimoIndiceDe(String elemento) {
        int ultimo = -1;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                ultimo = i;
            }
        }
        if (ultimo >= 0) {
            System.out.println("\nÚltima ocorrência de " + elemento + " encontrada na posição: " + ultimo);
        } else {
            System.out.println("\nElemento " + elemento + " não encontrado.");
        }
        return ultimo;
    }
    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                contador++;
            }
        }
        System.out.println("\nO elemento " + elemento + " aparece " + contador + " vez(es) na lista.");
        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null && lista[i].equals(antigo)) {
                System.out.println("Substituindo " + antigo + " por " + novo + " na posição " + i);
                lista[i] = novo;
                substituidos++;
            }
        }
        System.out.println("\nTotal de substituições realizadas: " + substituidos);
        return substituidos;
    }
}