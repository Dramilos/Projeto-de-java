import java.util.ArrayList;
import java.util.InputMismatchException;

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
        int quantNotas, flag;
        String nomeClasse;

        Principal.fflush();

        System.out.println("\nQual o nome da turma? ");
        nomeClasse = Principal.teclado.nextLine();

        do
        {
            flag = 0;

            System.out.println("\nQuantas notas tem cada aluno? ");

            try
            {
                quantNotas = Integer.parseInt(Principal.teclado.nextLine().trim());

                // criar objeto diário de classe
                turma = new Diario(nomeClasse, quantNotas);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(" -Erro. Tente novamente.");
                flag = 1;
            }
            catch (InputMismatchException f)
            {
                System.out.println(" -Erro. Tente novamente.");
                flag = 1;
            }
        } while (flag == 1);
    }

    // método para adicionar alunos a lista
    public void adicionarAlunos()
    {
        int quantAlunos = 0, flag, sucesso = 0;

        Principal.fflush();

        do
        {
            flag = 0;

            try
            {
                System.out.println("\nQuantos alunos deseja adicionar? ");
                quantAlunos = Integer.parseInt(Principal.teclado.nextLine().trim());
            }
            catch (NumberFormatException e)
            {
                System.out.println(" - Erro! Espera-se valor numérico");
                flag = 1;
            }
            catch (InputMismatchException f)
            {
                System.out.println(" - Erro! Espera-se valor numérico");
                flag = 1;
            }
        } while(flag == 1);

        do
        {
            flag = 0;

            try
            {
                for (; sucesso < quantAlunos; sucesso++)
                {
                    String nome;
                    int RA, nota;

                    System.out.println("\n-=-=- ALUNO " + (sucesso + 1) + " -=-=-=-");

                    System.out.println("\n -NOME: ");
                    nome = Principal.teclado.nextLine();

                    System.out.println("\n -RA: ");
                    RA = Integer.parseInt(Principal.teclado.nextLine().trim());

                    Aluno kid = new Aluno(nome, turma.quantNotas, RA);

                    for (int j = 0; j < turma.quantNotas ; j++)
                    {
                        System.out.println("\n -DIGITE A NOTA " + (j + 1));
                        do
                        {
                            nota = Integer.parseInt(Principal.teclado.nextLine().trim());

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
            catch (NumberFormatException e)
            {
                System.out.println(" - Erro! Espera-se valor numérico");
                flag = 1;
            }
            catch (InputMismatchException f)
            {
                System.out.println(" - Erro! Espera-se valor numérico");
                flag = 1;
            }
        } while (flag == 1);
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
            System.out.println("LISTA DE RAs: ");

            for(int j = 0; j < lista.size(); j++)
            {
                System.out.println(" -RA: " + lista.get(j).getRA());
            }

            System.out.println("Digite o RA do aluno para modificar a nota: ");
            RA = Integer.parseInt(Principal.teclado.nextLine().trim());

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
                mod = Integer.parseInt(Principal.teclado.nextLine().trim());

                System.out.println("\n -Digite a nova nota do aluno:");
                newnota = Integer.parseInt(Principal.teclado.nextLine().trim());

                lista.get(i).setNota((mod - 1), newnota);

                System.out.println("\nNotas atualizadas: ");
                imprimirNotasIndividuais(i);

                System.out.println("\nDigite 1 para trocar outra nota");
                newnota = Principal.teclado.nextInt();
            }
        } while (i == -1 || newnota == 1);
    }
}