package app;

import java.util.ArrayList;

/**
 *
 * @author abner, filipe moura, joão marcos, vinicius
 * 
 * Essa é a classe Aluno que será utilizada como tipo do conteúdo das árvores nos 
 * programas de teste para redigir os relatórios.
 */

public class Aluno  {
    private int matricula;
    private String nome;
    private ArrayList<Disciplina> disciplinasCursadas;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
        this.disciplinasCursadas = new ArrayList<Disciplina>();
    }


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void addDisciplinaCursada(Disciplina disciplina) {
        disciplinasCursadas.add(disciplina);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Matrícula: ").append(this.getMatricula()).append(": ").append(this.getNome()).append("\nDisciplinas cursadas:\n");

        for (Disciplina disciplina : this.getDisciplinasCursadas()) {
            stringBuilder.append(disciplina.toString()).append("\n");
        }

        return stringBuilder.toString();
    }
}
