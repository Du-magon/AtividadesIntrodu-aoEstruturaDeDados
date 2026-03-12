public class ListaDinamica implements ListaOperacoes {

    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {

        if (!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
            System.out.println("Elemento " + conteudo + " adicionado no início.");
        } else {

            No novoNo = new No(conteudo);
            No aux = this.inicio;

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novoNo);
            System.out.println("Elemento " + conteudo + " adicionado ao final da lista.");
        }
    }

    private boolean existeInicio() {
        return this.inicio.getConteudo() != null;
    }

    public void exibirElementos() {

        if (existeInicio()) {

            No aux = this.inicio;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }

        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {

        if (!existeInicio()) {
            System.out.println("Lista vazia.");
            return;
        }

        if (inicio.getConteudo().equals(elemento)) {
            inicio = inicio.getProx();
            System.out.println("Elemento " + elemento + " removido.");
            return;
        }

        No aux = inicio;

        while (aux.getProx() != null) {

            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                System.out.println("Elemento " + elemento + " removido.");
                return;
            }

            aux = aux.getProx();
        }

        System.out.println("Elemento não encontrado.");
    }

    public boolean buscarElemento(String elemento) {

        No aux = this.inicio;

        while (aux != null) {

            if (aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }

            aux = aux.getProx();
        }

        System.out.println("Elemento " + elemento + " não encontrado.");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        while (inicio != null && inicio.getConteudo() != null && inicio.getConteudo().equals(elemento)) {
            System.out.println("\nRemovendo elemento: " + elemento);
            inicio = inicio.getProx();
            removidos++;
        }
        No aux = inicio;
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                System.out.println("Removendo elemento: " + elemento);
                aux.setProx(aux.getProx().getProx());
                removidos++;
            } else {
                aux = aux.getProx();
            }
        }
        System.out.println("Total removidos: " + removidos);
        return removidos;
    }
    @Override
    public int contar() {
        int cont = 0;
        No aux = inicio;
        while (aux != null && aux.getConteudo() != null) {
            cont++;
            aux = aux.getProx();
        }
        System.out.println("Total de elementos na lista: " + cont);
        return cont;
    }
    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;
        for (String e : elementos) {
            adicionarElemento(e);
            System.out.println("Elemento adicionado: " + e);
            adicionados++;
        }
        return adicionados;
    }
    @Override
    public String obter(int indice) {
        int i = 0;
        No aux = inicio;
        while (aux != null) {
            if (i == indice) {
                System.out.println("\nElemento encontrado no índice " + indice + ": " + aux.getConteudo());
                return aux.getConteudo();
            }
            aux = aux.getProx();
            i++;
        }
        System.out.println("Índice inválido.");
        return null;
    }
    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice == 0) {
            No novo = new No(elemento);
            novo.setProx(inicio);
            inicio = novo;
            System.out.println("Elemento inserido: " + elemento + " na posição " + indice);
            return true;
        }
        int i = 0;
        No aux = inicio;
        while (aux != null) {
            if (i == indice - 1) {
                No novo = new No(elemento);
                novo.setProx(aux.getProx());
                aux.setProx(novo);
                System.out.println("Elemento inserido: " + elemento + " na posição " + indice);
                return true;
            }
            aux = aux.getProx();
            i++;
        }
        System.out.println("Índice inválido.");
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (indice == 0) {
            String removido = inicio.getConteudo();
            inicio = inicio.getProx();
            System.out.println("\nElemento removido: " + removido);
            return removido;
        }
        int i = 0;
        No aux = inicio;
        while (aux.getProx() != null) {
            if (i == indice - 1) {
                String removido = aux.getProx().getConteudo();
                aux.setProx(aux.getProx().getProx());
                System.out.println("\nElemento removido: " + removido);
                return removido;
            }
            aux = aux.getProx();
            i++;
        }
        System.out.println("Índice inválido.");
        return null;
    }
    @Override
    public void limpar() {
        inicio = new No(null);
        System.out.println("\nTodos os elementos foram removidos da lista.");
    }
    @Override
    public int ultimoIndiceDe(String elemento) {
        int indice = 0;
        int ultimo = -1;
        No aux = inicio;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                ultimo = indice;
            }
            aux = aux.getProx();
            indice++;
        }
        System.out.println("\nÚltimo índice de " + elemento + ": " + ultimo);
        return ultimo;
    }
    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        No aux = inicio;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                cont++;
            }
            aux = aux.getProx();
        }
        System.out.println("\nOcorrências de " + elemento + ": " + cont);
        return cont;
    }
    @Override
    public int substituir(String antigo, String novo) {
        int substituidos = 0;
        No aux = inicio;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                System.out.println("\nSubstituindo " + antigo + " por " + novo);
                aux.setConteudo(novo);
                substituidos++;
            }
            aux = aux.getProx();
        }
        System.out.println("Total de substituições: " + substituidos);
        return substituidos;
    }
}