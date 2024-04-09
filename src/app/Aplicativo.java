package app;

import lib.ArvoreBinaria;

import java.util.Scanner;

public class Aplicativo {

    ArvoreBinaria alunos = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorMatricula());
    ArvoreBinaria disciplinas = new ArvoreBinaria<>();

    public void menu() {


        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Disciplina");
        System.out.println("3 - Consultar Aluno");
        System.out.println("4 - Excluir Aluno");

        Scanner s = new Scanner(System.in);
        switch (s) {
            case 1:
                Alun

        }
    }
    public static void main(String[] args) {

    }
}
