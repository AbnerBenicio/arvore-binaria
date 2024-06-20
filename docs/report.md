# Relatório Sobre Árvores AVL

**Componentes**: Abner Benício, Arthur Cremasco, Filipe Moura, João Marcos e Vinícius Caetano  
**Disciplina**: Técnicas de Programação Avançada  
**Período**: 2024/1  


## Questões

1. **Por que as alturas das árvores degeneradas criadas com o AppRelatorioAVL é consideravelmente menor que as alturas das árvores degeneradas criadas em etapa anterior, com o AppRelatorioArvoreBinaria?**  
**R:** Enquanto na árvore binária normal nós veremos os novos filhos sempre sendo inseridos à direita do nó pai, assim fazendo com que a árvore tenha a sua altura igual ao número de nós - 1, na árvore AVL nós fazemos a rotação a cada inserção de modo a manter o balanceamento da árvore, tendo assim uma árvore balanceada e com altura menor do que a sua correspondente comum.  
&nbsp;

2. **Avalie as alturas das árvores degeneradas e das AVLs criadas pelo aplicativo. Explique porque a altura da árvore AVL está diferente da altura da árvore degenerada, se ambas foram alimentadas utilizando o método geraArvoreDegenerada do nosso GeradorDeArvores.**  
**R:** O método que gera árvores degeneradas nada mais faz do que seguir adicionando matrículas cada vez maiores na árvore usando o método de adição de elementos da própria árvore. Sendo assim, como explicado na pergunta transata, inserindo os nós do lado direito do nó pai no caso da árvore binária comum e no caso da AVL, realizando o balanceamento a cada inserção, fazendo com que a altura da árvore AVL seja menor que a comum, mesmo que alimentadas com os mesmos valores.  
&nbsp;  

3. **Qual a ordem de complexidade de buscas em árvores AVL criadas utilizando o método "geraArvoreDegenerada" do gerador de árvores. Explique.**  
**R:** _O(log n)_. Em uma AVL, os elementos estarão dispostos de modo que a pesquisa irá ocorrer de modo igual a de uma árvore balanceada qualquer, pois mesmo com os valores sendo inseridos em ordem "degenerada" (isto é, valores cada vez maiores), temos o balanceamento sendo aplicado a cada inserção, o que nos permite realizar uma busca binária eliminando metade dos elementos a cada iteração de comparação.

## Organização do Código Fonte

O código fonte pode ser encontrado no [GitHub](https://github.com/abnerbenicio/arvore-binaria) é organizado como se segue:

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

