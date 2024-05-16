package app;

import lib.ArvoreBinaria;

import java.io.Console;
import java.util.Scanner;

public class Aplicativo {

    //Inicializando árvores binárias
    ArvoreBinaria<Aluno> alunos = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorMatricula());
    ArvoreBinaria<Disciplina> disciplinas = new ArvoreBinaria<>(new ComparadorDisciplinaCodigo());

    //Método para cadastrar aluno
    public void CadastrarAluno() {
        //Inicializando input
        Scanner alunoInfos = new Scanner(System.in);

        try {
            //Solicitando nome do aluno
            System.out.println("Digite o nome do aluno:");
            String nomeAluno = alunoInfos.nextLine();

            //Solicitando matrícula do aluno
            System.out.println("Digite a matrícula do aluno:");
            int matriculaAluno = alunoInfos.nextInt();

            //Criando aluno
            Aluno aluno = new Aluno(matriculaAluno, nomeAluno);

            //Armazenando aluno
            alunos.adicionar(aluno);

            //Informando que cadastro foi feito com sucesso
            System.out.println("Aluno " + nomeAluno + " cadastrado com sucesso!");
        } catch (Exception e) {
            //Informando erro ao cadastrar aluno
            System.out.println("Erro ao preencher os dados");
        }
    }

    //Método para cadastrar disciplina
    public void CadastrarDisciplina() {
        //Inicializando input
        Scanner disciplinaInfos = new Scanner(System.in);

        try {
            //Solicitando nome da disciplina
            System.out.println("Digite o nome da disciplina:");
            String nomeDisciplina = disciplinaInfos.nextLine();

            //Solicitando carga horária da disciplina
            System.out.println("Digitea carga horária da disciplina:");
            int chDisciplina = disciplinaInfos.nextInt();

            //Solicitando código da disciplina
            System.out.println("Digite o código da disciplina:");
            int codigoDisciplina = disciplinaInfos.nextInt();

            //Criando disciplina
            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, chDisciplina);

            //Armazenando disciplina
            disciplinas.adicionar(disciplina);

            //Informando que disciplina foi cadastrada com sucesso
            System.out.println("Disciplina " + nomeDisciplina + " cadastrada com sucesso!");
        } catch (Exception e) {
            //Informando erro ao cadastrar disciplina
            System.out.println("Erro ao preencher os dados.");
        }
    }

    //Método para cadastrar pré-requisitos
    public void CadastrarPreRequisito() {
        //Exibindo disciplinas cadastradas
        System.out.println("Disciplinas cadastradas: \n");
        System.out.println(disciplinas.caminharEmNivel());

        //Inicializando input
        Scanner disciplina = new Scanner(System.in);
        try {
            //Solicitando código da disciplina que eu quero adicionar um pré-requisito
            System.out.println("Digite o código da disciplina que você deseja cadastrar um novo pré-requisito:");
            int codDisciplinaSelecionada = disciplina.nextInt();

            //Solicitando código da disciplina que eu quero cadastrar como pré-requisito da primeira
            System.out.println("Digite o código da disciplina que você deseja cadastrar como pré-requisito da primeira escolhida:");
            int codPreRequisito = disciplina.nextInt();

            //Verificando se códigos são iguais
            if (codDisciplinaSelecionada != codPreRequisito) {
                /*
                * Se não forem, se encontra a primeira disciplina
                * Se encontra a segunda disciplina
                * Cadastra a segunda como pré-requisito da primeira
                */
                Disciplina disciplinaSelecionada = disciplinas.pesquisar(new Disciplina(codDisciplinaSelecionada, "", 0));
                Disciplina preRequisito = disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0));
                disciplinaSelecionada.addPreRequisito(preRequisito);
            } else {
                //Se forem iguais, lança um erro
                throw new RuntimeException();
            }
        } catch (Exception e) {
            //Informando erro ao cadastrar pré-requisito
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

    //Método para exibir menu
    public void menu() {
        //Exibindo opções
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Disciplina");
        System.out.println("3 - Cadastrar pré-requisito");
        System.out.println("4 - Informar disciplina cursada");
        System.out.println("5 - Consultar Aluno");
        System.out.println("6 - Excluir Aluno");
        System.out.println("0 - Sair");

        //Inicializando input
        Scanner s = new Scanner(System.in);

        //Verificando opção selecionada
        switch (s.nextLine()) {
            //Cadastro de aluno
            case "1":
                CadastrarAluno();
                menu();
                break;

            //Cadastro de disciplina
            case "2":
                CadastrarDisciplina();
                menu();
                break;

            //Cadastro de pré-requisito
            case "3":
                CadastrarPreRequisito();
                menu();
                break;

            //Informa se disciplina foi cursada pelo aluno
            case "4":
                InformaDisciplina();
                menu();
                break;

            //Consulta aluno
            case "5":
                ConsultarAluno();
                menu();
                break;

            //Exclui aluno
            case "6":
                ExcluirAluno();
                menu();
                break;

            //Saí do aplicativo
            case "0":
                System.out.println("Obrigado por usar o sistema!");
                break;

            //Opção digitada inválida
            default:
                System.out.println("Opção inválida, por favor digite novamente.");
                menu();
        }
    }

    //Método main
    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        app.menu();
    }
}
