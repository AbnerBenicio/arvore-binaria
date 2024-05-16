package app;

import lib.ArvoreBinaria;

import java.io.Console;
import java.util.Scanner;

public class Aplicativo {

    ArvoreBinaria<Aluno> alunos = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorMatricula());
    ArvoreBinaria<Disciplina> disciplinas = new ArvoreBinaria<>(new ComparadorDisciplinaCodigo());

    public void CadastrarAluno() {
        Scanner alunoInfos = new Scanner(System.in);

        try {
            System.out.println("Digite o nome do aluno:");
            String nomeAluno = alunoInfos.nextLine();
            System.out.println("Digite a matrícula do aluno:");
            int matriculaAluno = alunoInfos.nextInt();
            Aluno aluno = new Aluno(matriculaAluno, nomeAluno);
            alunos.adicionar(aluno);
            System.out.println("Aluno " + nomeAluno + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao preencher os dados. Digite de novo");
            CadastrarAluno();
        }
    }

    public void CadastrarDisciplina() {
        Scanner disciplinaInfos = new Scanner(System.in);
        try {
            System.out.println("Digite o nome da disciplina:");
            String nomeDisciplina = disciplinaInfos.nextLine();
            System.out.println("Digitea carga horária da disciplina:");
            int chDisciplina = disciplinaInfos.nextInt();
            System.out.println("Digite o código da disciplina:");
            int codigoDisciplina = disciplinaInfos.nextInt();
            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, chDisciplina);
            System.out.println(disciplina.toString());
            disciplinas.adicionar(disciplina);
            System.out.println("Disciplina " + nomeDisciplina + " cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao preencher os dados. Digite de novo");
            CadastrarDisciplina();
        }
    }

    public void CadastrarPreRequisito() {
        System.out.println("Disciplinas cadastradas: \n");
        System.out.println(disciplinas.caminharEmNivel());

        Scanner disciplina = new Scanner(System.in);
        try {
            System.out.println("Digite o código da disciplina que você deseja cadastrar um novo pré-requisito:");
            int codDisciplinaSelecionada = disciplina.nextInt();
            System.out.println("Digite o código da disciplina que você deseja cadastrar como pré-requisito da primeira escolhida:");
            int codPreRequisito = disciplina.nextInt();

            Disciplina disciplinaSelecionada = disciplinas.pesquisar(new Disciplina(codDisciplinaSelecionada, "", 0));
            Disciplina preRequisito = disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0));
            disciplinaSelecionada.addPreRequisito(preRequisito);
            for (Disciplina d : disciplinaSelecionada.getPreRequisitos()) {
                System.out.println(d.toString());
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher os dados");
        }


    }

    public void InformaDisciplina() {
        //Escrever método
    }

    public void ConsultarAluno() {
        //Escrever método
    }

    public void ExcluirAluno() {
        //Escrever método
    }

    public void menu() {
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Disciplina");
        System.out.println("3 - Cadastrar pré-requisito");
        System.out.println("4 - Informar disciplina cursada");
        System.out.println("5 - Consultar Aluno");
        System.out.println("6 - Excluir Aluno");
        System.out.println("0 - Sair");

        Scanner s = new Scanner(System.in);
        switch (s.nextLine()) {
            case "1":
                CadastrarAluno();
                menu();
                break;
            case "2":
                CadastrarDisciplina();
                menu();
                break;
            case "3":
                CadastrarPreRequisito();
                menu();
                break;
            case "4":
                InformaDisciplina();
                menu();
                break;
            case "5":
                ConsultarAluno();
                menu();
                break;
            case "6":
                ExcluirAluno();
                menu();
                break;
            case "0":
                System.out.println("Obrigado por usar o sistema!");
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente.");
                menu();
        }
    }
    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        app.menu();
    }
}
