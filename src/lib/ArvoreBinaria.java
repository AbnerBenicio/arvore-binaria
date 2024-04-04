/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Comparator;

/**
 *
 * @author abner, filipe moura, joão marcos, vinicius
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    
    protected No<T> raiz = null;
    protected Comparator<T> comparador; 
  
    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    //Método de adicionar elemento na arvore
    @Override
    public void adicionar(T novoValor) {
        //Instanciando nó
        No<T> filho = new No<T>(novoValor);
        //Verificando se a árvore está vazia
        if (this.raiz == null) {
            //Adicionando elemento na árvore vazia
            this.raiz = filho;
        } else {
            //Adicionando elemento em árvore com elementos
            adicionarFilho(raiz, filho);
        }
    }

    //Método auxiliar para adicionar elementos
    private void adicionarFilho(No<T> raiz, No<T> filho) {
        //Verificando se deve ser adicionando à esquerda ou à direita
        if (comparador.compare(raiz.getValor(), filho.getValor()) > 0) {
            //Adicionando à esquerda
            if (raiz.getFilhoEsquerda() == null) {
                raiz.setFilhoEsquerda(filho);
            } else {
                adicionarFilho(raiz.getFilhoEsquerda(), filho);
            }
            //Adicionando filho à direita
        } else {
            if (raiz.getFilhoDireita() == null) {
                raiz.setFilhoDireita(filho);
            } else {
                adicionarFilho(raiz.getFilhoDireita(), filho);
            }
        }
    }


    //Método de pesquisar elemento
    @Override
    public T pesquisar(T valor) {
        return encontrarFilho(raiz, valor);
    }

    //Método auxiliar para pesquisar elemento
    private T encontrarFilho(No<T> raiz, T valor) {
        //Verificando se a raiz é nula
        if (raiz == null) {
            return null;
        } else {
            //Verificando se elemento foi encontrado
            if (comparador.compare(raiz.getValor(), valor) == 0) {
                return raiz.getValor();
            } else {
                //Procurando elemento na direita
                if (comparador.compare(raiz.getValor(), valor) < 0) {
                    return encontrarFilho(raiz.getFilhoDireita(), valor);
                //Procurando elemento na esquerda
                } else {
                    return encontrarFilho(raiz.getFilhoEsquerda(), valor);
                }
            }
        }

    }


    @Override
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Método de remoçao
    @Override
    public T remover(T valor) {
        No<T> noRemovido = new No<T>(null);
        noRemovido = removerRecursivo(raiz, valor, noRemovido);
        //Retornando valor do nó removido
        return noRemovido.getValor();
    }

    //Método auxiliar para remover elemento
    private No<T> removerRecursivo(No<T> raiz, T valor, No<T> noRemovido) {
        // Se a raiz é nula, retorna nulo
        if (raiz == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, raiz.getValor());
        if (comparacao < 0) {
            raiz.setFilhoEsquerda(removerRecursivo(raiz.getFilhoEsquerda(), valor, noRemovido));
        }
        else if (comparacao > 0) {
            raiz.setFilhoDireita(removerRecursivo(raiz.getFilhoDireita(), valor, noRemovido));
        }
        else {
            // O nó não tem filhos:
            if (raiz.getFilhoEsquerda() == null && raiz.getFilhoDireita() == null) {
                noRemovido.setValor(raiz.getValor());
                return null;
            }
            // O nó tem 1 filho:
            else if (raiz.getFilhoEsquerda() == null) {
                noRemovido.setValor(raiz.getValor());
                return raiz.getFilhoDireita();
            } else if (raiz.getFilhoDireita() == null) {
                noRemovido.setValor(raiz.getValor());
                return raiz.getFilhoEsquerda();
            }
            // O nó tem dois filhos
            else {
                No<T> menor = encontrarMenor(raiz.getFilhoDireita());
                noRemovido.setValor(raiz.getValor());
                raiz.setValor(menor.getValor());
                raiz.setFilhoDireita(removerRecursivo(raiz.getFilhoDireita(), menor.getValor(), noRemovido));
            }
        }
        return raiz;
    }

    //Método auxiliar para encontrar menor elemento
    private No<T> encontrarMenor(No<T> raiz) {
        while (raiz.getFilhoEsquerda() != null) {
            raiz = raiz.getFilhoEsquerda();
        }
        //Retornando menor nó
        return raiz;
    }


    //Método para encontrar altura
    @Override
    public int altura() {
        //Retornando altura
        return calcularAltura(raiz);
    }

    //Método auxiliar para encontrar altura
    private int calcularAltura(No<T> r) {
        //Verificando se raiz existe
        if (r == null) {
            return 0;
        //Verificando se nó tem filhos
        } else if (r.getFilhoEsquerda() == null && r.getFilhoDireita() == null) {
            return 0;
        } else {
            //Retornando altura
            return 1 + Math.max(calcularAltura(r.getFilhoDireita()), calcularAltura(r.getFilhoEsquerda()));
        }
    }
       
    
    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String caminharEmNivel() {
        /**
         * Decorator para o verdadeiro método adicionando os colchetes no início do retorno
         * @return Retorna uma string contendo os valores visitados.
         */
        StringBuilder result = new StringBuilder();
        result.append("[\n");
        caminharEmNivel(raiz, result);
        result.append("]\n");
        return result.toString().trim();
    }

    private void caminharEmNivel(No<T> raiz, StringBuilder result) {
        /**
         * Método que faz a busca em profundidade, começa printando os valores do nó raíz,
         * aplica o método recursivamente na sub-árvore esquerda (se houver)
         * e depois na sub-árvore direita (se houver
         * @return Nada, apenas altera a variável result.
         */

        if (raiz == null)
            return;
        // Adiciona valor do nó atual
        result.append(raiz.getValor()).append(" \n ");

        // Chama a função recursivamente para os filhos
        caminharEmNivel(raiz.getFilhoEsquerda(), result);
        caminharEmNivel(raiz.getFilhoDireita(), result);
    }


    @Override
    public String caminharEmOrdem() {
        /*
         * Decorator para o verdadeiro método adicionando os colchetes no início do retorno
         * @return Retorna uma string contendo os valores visitados.
         */
        StringBuilder result = new StringBuilder();
        result.append("[\n");
        caminharEmOrdem(raiz, result);
        result.append("]\n");
        return result.toString().trim();
    }

    private void caminharEmOrdem(No<T> raiz, StringBuilder result) {
        /*
         * Método que faz a busca em ordem, começa a busca pela sub-árvore esquerda,
         * após isso vai para o nó raíz e termina pela sub-árvore direita
         * @return Nada, apenas altera a variável result.
         */
        if (raiz != null) {
            caminharEmOrdem(raiz.getFilhoEsquerda(), result);
            result.append(raiz.getValor()).append(" \n ");
            caminharEmOrdem(raiz.getFilhoDireita(), result);
        }
    }
}
