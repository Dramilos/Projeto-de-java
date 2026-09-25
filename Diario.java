import java.util.ArrayList;

public class Diario
{
    
    // atributos da classe
    String nomeClasse;
    int quantNotas;
    static ArrayList<Aluno> lista;
    static Diario turma;

    // construtor pra classe diário
    public Diario (String nomeClasse, int quantNotas)
    {
        this.nomeClasse = nomeClasse;
        this.quantNotas = quantNotas;
        lista = new ArrayList<>();
    }

    // criador de diários
    public static void criarDiario()
    {
        int quantNotas;
        String nomeClasse;

        Principal.fflush();

        System.out.println("\nQual o nome da turma? ");
        nomeClasse = Principal.teclado.nextLine();

        System.out.println("\nQuantas notas tem cada aluno? ");
        quantNotas = Principal.teclado.nextInt();

        // criar objeto diário de classe
        turma = new Diario(nomeClasse, quantNotas);
    }

    // método para adicionar alunos a lista
    public void adicionarAlunos()
    {
        Principal.fflush();

        int quantAlunos;

        System.out.println("\nQuantos alunos deseja adicionar? ");
        quantAlunos = Principal.teclado.nextInt();

        for (int i = 0; i < quantAlunos; i++)
        {
            String nome;
            int RA, nota;

            Principal.teclado.nextLine();      // limpar o buffer

            System.out.println("\n-=-=- ALUNO " + (i + 1) + " -=-=-=-");

            System.out.println("\n -NOME: ");
            nome = Principal.teclado.nextLine();

            System.out.println("\n -RA: ");
            RA = Principal.teclado.nextInt();

            Aluno kid = new Aluno(nome, turma.quantNotas, RA);

            for (int j = 0; j < turma.quantNotas ; j++)
            {
                System.out.println("\n -DIGITE A NOTA " + (j + 1));
                do
                {
                    nota = Principal.teclado.nextInt();

                    if(nota < 0 || nota > 100)
                    {
                        System.out.println("\n Valor inválido!");
                    }

                } while(nota < 0 || nota > 100);

                kid.setNota(j, nota);
            }
            lista.add(kid);
        }

    }

    // método para imprimir as notas individuais de um aluno
    public void imprimirNotasIndividuais(int i)
    {
        for(int j = 0; j < turma.quantNotas; j++)
            {
                System.out.println("\t - nota " + (j + 1) + ": " + lista.get(i).getNota(j));
            }
    }

    // método que imprime um relatório
    public void relatorio()
    {
        Principal.fflush();

        System.out.println("RELATÓRIO");
        
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println("==============\nALUNO " + (i + 1));
            System.out.println("\n -Nome: " + lista.get(i).getNome());
            System.out.println(" -RA: " + lista.get(i).getRA());
            imprimirNotasIndividuais(i);
            System.out.println(" -Média: " + lista.get(i).getMedia());
        }

        System.out.println("Digite qualquer tecla para sair");
        Principal.teclado.nextLine();
    }

    public static int checarRA(int RA)
    {
        for (int i = 0; i < lista.size(); i++)
        {
            if(RA == lista.get(i).getRA())
            {
                return i;
            }
        }

        return -1;
    }

    // métodos para definir as notas de cada aluno
    public void definirNotas()
    {
        int RA, i, mod, newnota = 0;

        Principal.fflush();

        do
        {
            System.out.println("Digite o RA do aluno para modificar a nota: ");
            RA = Principal.teclado.nextInt();

            i = checarRA(RA);

            if(i == -1)
            {
                System.out.println("\nAluno não encontrado. Tente novamente");
            }
            else
            {
                System.out.println("\nAluno: " + lista.get(i).getNome());
                imprimirNotasIndividuais(i);

                System.out.println("\nQual das notas acima gostaria de modificar?");
                mod = Principal.teclado.nextInt();

                System.out.println("\n -Digite a nova nota do aluno:");
                newnota = Principal.teclado.nextInt();

                lista.get(i).setNota((mod - 1), newnota);

                System.out.println("\nNotas atualizadas: ");
                imprimirNotasIndividuais(i);

                System.out.println("\nDigite 1 para trocar outra nota");
                newnota = Principal.teclado.nextInt();
            }
        } while (i == -1 || newnota == 1);
    }
}