# Relatório Sobre Árvores AVL

**Componentes**: Abner Benício, Arthur Cremasco, Filipe Moura, João Marcos e Vinícius Caetano  
**Disciplina**: Técnicas de Programação Avançada  
**Período**: 2024/1  


## Questões

1. Por que as alturas das árvores degeneradas criadas com o AppRelatorioAVL é consideravelmente menor que as alturas das árvores degeneradas criadas em etapa anterior, com o AppRelatorioArvoreBinaria?  
**R:**

2. Avalie as alturas das árvores degeneradas e das AVLs criadas pelo aplicativo. Explique porque a altura da árvore AVL está diferente da altura da árvore degenerada, se ambas foram alimentadas utilizando o método geraArvoreDegenerada do nosso GeradorDeArvores.  
**R:** 

3. Qual a ordem de complexidade de buscas em árvores AVL criadas utilizando o método "geraArvoreDegenerada" do gerador de árvores. Explique.  
**R:** 

## Organização do Código Fonte

O código fonte é organizado como se segue:

> ├── docs: Pasta com os relatórios   
│  └── report.md : Relatório sobre Árvores AVL  
├── README.md : README padrão  
└── src : Pasta com todo o código fonte  
   ├── app : Pasta com a Aplicação  
   │   ├── Aluno.java: Classe de aluno  
   │   ├── Aplicativo.java : Aplicativo que o usa código fonte conforme inputs do usuário   
   │   ├── AppRelatorioArvoreBinaria.java  Código utilizado no relatório de Árvores Binárias  
   │   ├── AppRelatorioAVL.java : Código utilizado no relatório de Árvores AVL  
   │   ├── ComparadorAlunoPorMatricula.java : Comparator por Matrícula  
   │   ├── ComparadorAlunoPorNome.java : Comparator por Nome  
   │   ├── ComparadorDisciplinaCodigo.java : Comparator de Disciplina  
   │   ├── Disciplina.java : Classe de Disciplina  
   │   └── GeradorDeArvores.java : Classe que gera árvores de alunos  
   └── lib : Bibliotecas  
      ├── ArvoreAVL.java : Biblioteca de Árvores AVL  
      ├── ArvoreBinaria.java : Biblioteca de Árvores Binárias  
      ├── IArvoreBinaria.java : Interface para a biblioteca de Árvores Binárias  
      └── No.java: Classe Nó que é utilizada em ambas bibliotecas   

