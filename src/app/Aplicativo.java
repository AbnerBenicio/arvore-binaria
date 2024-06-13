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
        Scanner inputCadastroAluno = new Scanner(System.in);

        try {
            //Solicitando nome do aluno
            System.out.println("Digite o nome do aluno:");
            System.out.print(">> ");
            String nomeAluno = inputCadastroAluno.nextLine();

            //Solicitando matrícula do aluno
            System.out.println("Digite a matrícula do aluno:");
            System.out.print(">> ");
            int matriculaAluno = inputCadastroAluno.nextInt();

            //Criando aluno
            Aluno aluno = new Aluno(matriculaAluno, nomeAluno);

            //verificando se não há erros
            if (nomeAluno.equals(""))
                throw new RuntimeException("Erro: O nome do aluno não pode ser vazio.");
            if (String.format("" + matriculaAluno).equals(""))
                throw new RuntimeException("Erro: A matrícula do aluno não pode ser vazio.");
            if (alunos.pesquisar(new Aluno(matriculaAluno, "")) != null)
                throw new RuntimeException("Erro: O aluno já foi cadastrado anteriormente.");

            //Armazenando aluno
            alunos.adicionar(aluno);

            //Informando que cadastro foi feito com sucesso
            System.out.println("Aluno " + nomeAluno + " cadastrado com sucesso!");
        } catch (Exception e) {
            //Informando erro ao cadastrar aluno
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
            else
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
            System.out.print(">> ");
            String nomeDisciplina = disciplinaInfos.nextLine();

            //Solicitando carga horária da disciplina
            System.out.println("Digite a carga horária da disciplina:");
            System.out.print(">> ");
            int chDisciplina = disciplinaInfos.nextInt();

            //Solicitando código da disciplina
            System.out.println("Digite o código da disciplina:");
            System.out.print(">> ");
            int codigoDisciplina = disciplinaInfos.nextInt();

            //Criando disciplina
            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, chDisciplina);

            //verificando se não há erros
            if (nomeDisciplina.equals(""))
                throw new RuntimeException("Erro: O nome da disciplina não pode ser vazio.");
            if (String.format("" + codigoDisciplina).equals(""))
                throw new RuntimeException("Erro: O código da disciplina não pode ser vazio.");
            if (disciplinas.pesquisar(new Disciplina(codigoDisciplina, "", 0)) != null)
                throw new RuntimeException("Erro: A disciplina já foi cadastrado anteriormente.");

            //Armazenando disciplina
            disciplinas.adicionar(disciplina);

            //Informando que disciplina foi cadastrada com sucesso
            System.out.println("Disciplina " + nomeDisciplina + " cadastrada com sucesso!");
        } catch (Exception e) {
            //Informando erro ao cadastrar disciplina
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
            else
                System.out.println("Erro ao preencher os dados.");
        }
    }

    //Método para cadastrar pré-requisitos
    public void CadastrarPreRequisito() {
        //Exibindo disciplinas cadastradas
        System.out.println("Disciplinas cadastradas: \n");
        System.out.println(disciplinas.caminharEmOrdem());

        //Inicializando input
        Scanner InputDisciplina = new Scanner(System.in);
        try {
            //Solicitando código da disciplina que eu quero adicionar um pré-requisito
            System.out.println("Digite o código da disciplina para a qual você deseja cadastrar um novo pré-requisito:");
            System.out.print(">> ");
            int codDisciplinaSelecionada = InputDisciplina.nextInt();

            //verificando se não há erro
            if(disciplinas.pesquisar(new Disciplina(codDisciplinaSelecionada, "", 0)) == null)
                throw new RuntimeException("Erro: Disciplina inexistente.");

            //Solicitando código da disciplina que eu quero cadastrar como pré-requisito da primeira
            System.out.println("Digite o código da disciplina que será pré-requisito da primeira escolhida:");
            System.out.print(">> ");
            int codPreRequisito = InputDisciplina.nextInt();

            //verificando se não há erro
            if(disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0)) == null)
                throw new RuntimeException("Erro: Disciplina inexistente.");

            for (Disciplina disciplina: disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0)).getPreRequisitos())
                if(disciplina.getCodigo() == codDisciplinaSelecionada)
                    throw new RuntimeException("Erro: A disciplina que você está tentando adicionar como pré-requisito da disciplina 1" +
                        "tem a disciplina 1 como pré-requisito.");


            //Verificando se códigos são iguais
            if (codDisciplinaSelecionada != codPreRequisito) {
                /*
                * Se não forem, se encontra a primeira disciplina
                * Se encontra a segunda disciplina
                * Cadastra a segunda como pré-requisito da primeira
                */
                Disciplina disciplinaSelecionada = disciplinas.pesquisar(new Disciplina(codDisciplinaSelecionada, "", 0));
                Disciplina preRequisito = disciplinas.pesquisar(new Disciplina(codPreRequisito, "", 0));
                if (!disciplinaSelecionada.getPreRequisitos().contains(preRequisito)) {
                    System.out.println("Pré-requisito cadastrado com sucesso");
                    disciplinaSelecionada.addPreRequisito(preRequisito);
                } else {
                    System.out.println("A disciplina já possui esse pré-requisito");
                }
            } else {
                //Se forem iguais, lança um erro
                throw new RuntimeException("Uma disciplina não pode ser pré-requisito de si mesma");
            }
        } catch (Exception e) {
            //Informando erro ao cadastrar pré-requisito
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
            else
                System.out.println("Erro ao preencher a informação");
        }

    }

    //Método para informar se aluno cursou a disciplina
    public void InformaDisciplinaCursada() {
        //Inicializando input
        Scanner input = new Scanner(System.in);

        try {
            //Informando alunos cadastrados
            System.out.println("Alunos cadastradas: \n");
            System.out.println(alunos.caminharEmOrdem());

            //Solicitando matrícula do aluno
            System.out.println("Digite a matrícula do aluno que você deseja verificar:");
            System.out.print(">> ");
            int matAluno = input.nextInt();

            //verificando se não há erro
            if (alunos.pesquisar(new Aluno(matAluno, "")) == null)
                throw new RuntimeException("Erro: Não há aluno cadastrado com esse código.");

            //Informando disciplinas cadastradas
            System.out.println("Disciplinas cadastradas: \n");
            System.out.println(disciplinas.caminharEmOrdem());

            //Solicitando código da disciplina
            System.out.println("Digite o código da disciplina que você deseja verificar:");
            System.out.print(">> ");
            int codDisciplina = input.nextInt();

            //Informando disciplinas cadastradas
            if (disciplinas.pesquisar(new Disciplina(codDisciplina, "", 0)) == null)
                throw new RuntimeException("Erro: Não há disciplina cadastrada com esse código.");

            //Buscando disciplina
            Disciplina disciplina = disciplinas.pesquisar(new Disciplina(codDisciplina, "", 0));
            //Buscando aluno
            Aluno aluno = alunos.pesquisar(new Aluno(matAluno, ""));
            //Verificando se aluno cursou a disciplina
            if (disciplina.getPreRequisitos().isEmpty()) {
                System.out.println("O aluno de matrícula " + matAluno + " cursou a disciplina de código " + codDisciplina);
                //Adicionando disciplina
                if (!aluno.getDisciplinasCursadas().contains(disciplina)) {
                    aluno.addDisciplinaCursada(disciplina);
                }
            } else if (aluno.getDisciplinasCursadas().containsAll(disciplina.getPreRequisitos())) {
                System.out.println("O aluno de matrícula " + matAluno + " cursou a disciplina de código " + codDisciplina);
                for (Disciplina d : aluno.getDisciplinasCursadas()) {
                    System.out.println(d.toString());
                }
                //Adicionando disciplina
                if (!aluno.getDisciplinasCursadas().contains(disciplina)) {
                    aluno.addDisciplinaCursada(disciplina);
                }
            } else {
                //Informando que aluno não cursou a disciplina
                System.out.println("O aluno de matrícula " + matAluno + " não cursou a disciplina de código " + codDisciplina);
            }
        } catch (Exception e) {
            //Informando erro ao verificar
            if(e.getMessage() != null)
                System.out.println(e.getMessage());
            else
                System.out.println("Erro ao verificar");
        }

    }

    //Função para consultar aluno
    public void ConsultarAluno() {
        //Inicializando input
        Scanner input = new Scanner(System.in);

        //Solicitando forma de consulta
        System.out.println("Como você deseja consultar o aluno?");
        System.out.println("1 - Matrícula");
        System.out.println("2 - Nome");
        System.out.print(">> ");

        //Criando objeto aluno
        Aluno aluno;
        try {
            //Verificando opção
            switch (input.nextLine()) {
                //Cosnulta por matrícula
                case "1":
                    //Solicitando matrícula do aluno
                    System.out.println("Digite a matrícula do aluno:");
                    System.out.print(">> ");
                    int codAluno = input.nextInt();
                    aluno = alunos.pesquisar(new Aluno(codAluno, ""));
                    //Exibindo informações do aluno
                    System.out.println(aluno.toString());
                    System.out.println("Disciplinas cursadas:");
                    for (Disciplina disciplina : aluno.getDisciplinasCursadas()) {
                        System.out.println(disciplina.toString());
                    }
                    break;
                //Consulta por nome
                case "2":
                    //Solicitando nome do aluno
                    System.out.println("Digite o nome do aluno:");
                    System.out.print(">> ");
                    String nomeAluno = input.nextLine();
                    aluno = alunos.pesquisar(new Aluno(0, nomeAluno), new ComparadorAlunoPorNome());
                    //Exibindo informações do aluno
                    System.out.println(aluno.toString());
                    System.out.println("Disciplinas cursadas:");
                    for (Disciplina disciplina : aluno.getDisciplinasCursadas()) {
                        System.out.println(disciplina.toString());
                    }
                    break;
                default:
                    //Informando opção inválida escolhida
                    System.out.println("Opção inválida");
            }
        } catch (Exception e) {
            //Informando erro ao consultar aluno
            System.out.println("Erro ao consultar aluno");
        }

    }

    //Método para excluir aluno
    public void ExcluirAluno() {
        //Inicialiando input
        Scanner input = new Scanner(System.in);

        //Exibindo alunos cadastrados
        System.out.println("Alunos cadastradas: \n");
        System.out.println(alunos.caminharEmOrdem());
        try {
            //Solicitando matrícula do aluno
            System.out.println("Digite a matrícula do aluno que você deseja excluir:");
            System.out.print(">> ");
            int codAluno = input.nextInt();
            Aluno aluno = alunos.pesquisar(new Aluno(codAluno, ""));
            //Verificando se aluno existe
            if (aluno != null) {
                //Removendo aluno
                alunos.remover(aluno);
                //Informando remoção
                System.out.println("Aluno " + aluno.getNome() + " removido com sucesso.");
            } else {
                //Informando que aluno não foi encontrado
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            //Informando erro ao excluir
            System.out.println("Erro ao excluir aluno");
        }

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
        System.out.print(">> ");


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
                InformaDisciplinaCursada();
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
                System.out.print(">> ");
                menu();
        }
    }

    //Método main
    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        app.menu();
    }
}
