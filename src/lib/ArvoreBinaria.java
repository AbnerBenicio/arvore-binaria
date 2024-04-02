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
        //Adicionar qntdNos++
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
            //Adicionando à direita
        } else {
            if (raiz.getFilhoDireita() == null) {
                raiz.setFilhoDireita(filho);
            } else {
                adicionarFilho(raiz.getFilhoDireita(), filho);
            }
        }
    }

    //Método de pesquisa de elementos
    @Override
    public T pesquisar(T valor) {
        //Chamando método auxiliar para encontrar elemento
        return encontrarFilho(raiz, valor);
    }

    //Método auxiliar para encontrar elemento
    private T encontrarFilho(No<T> raiz, T valor) {
        //Verificando se nó é nulo
        if (raiz == null) {
            return null;
        } else {
            //Verificando se achei o elemento
            if (comparador.compare(raiz.getValor(), valor) == 0) {
                return raiz.getValor();
            } else {
                //Buscando elemento à direita
                if (comparador.compare(raiz.getValor(), valor) < 0) {
                    return encontrarFilho(raiz.getFilhoDireita(), valor);
                //Buscando elemento à esquerda
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

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
    
    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }
        
}
