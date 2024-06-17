package lib;

import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T> {

    public ArvoreAVL(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    protected No<T> adicionarFilho(No<T> raiz, No<T> filho) {
        raiz = super.adicionarFilho(raiz, filho);

        if (raiz.fatorBalanceamento() > 1) {
            if (raiz.getFilhoDireita().fatorBalanceamento() > 0) {
                raiz = this.rotacaoEsquerda(raiz);
            } else {
                raiz = this.rotacaoDireitaEsquerda(raiz);
            }
        } else if (raiz.fatorBalanceamento() < -1) {
            if (raiz.getFilhoEsquerda().fatorBalanceamento() < 0) {
                raiz = this.rotacaoDireita(raiz);
            } else {
                raiz = this.rotacaoEsquerdaDireita(raiz);
            }
        }

        return raiz;
    }

    @Override
    protected No<T> removerRecursivo(No<T> raiz, T valor, No<T> noRemovido) {
        raiz = super.removerRecursivo(raiz, valor, new No<>(null));

        if (raiz != null) {
            if (raiz.fatorBalanceamento() > 1) {
                if (raiz.getFilhoDireita().fatorBalanceamento() > 0) {
                    raiz = this.rotacaoEsquerda(raiz);
                } else {
                    raiz = this.rotacaoDireitaEsquerda(raiz);
                }
            } else if (raiz.fatorBalanceamento() < -1) {
                if (raiz.getFilhoEsquerda().fatorBalanceamento() < 0) {
                    raiz = this.rotacaoDireita(raiz);
                } else {
                    raiz = this.rotacaoEsquerdaDireita(raiz);
                }
            }
        }

        return raiz;
    }

    private No<T> rotacaoEsquerda(No<T> r) {
        No<T> fd = r.getFilhoDireita();
        r.setFilhoDireita(fd.getFilhoEsquerda());
        fd.setFilhoEsquerda(r);

        return fd;
    }

    private No<T> rotacaoDireita(No<T> r) {
        //Parte do Arthur (modificar retorno)
        return r;
    }

    private No<T> rotacaoDireitaEsquerda(No<T> r) {
        //Parte do Arthur (modificar retorno)
        return r;
    }

    private No<T> rotacaoEsquerdaDireita(No<T> r) {
        r.setFilhoEsquerda(rotacaoEsquerda(r.getFilhoEsquerda()));

        return rotacaoDireita(r);
    }
}
