import java.util.Scanner;

public class Principal
{
    static int quantNotas;
    static String nomeClasse;
    static Diario turma;
    static Scanner teclado = new Scanner(System.in);

    public static void fflush()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }
    
    public static void criarDiario()
    {
        fflush();

        System.out.println("\nQual o nome da turma? ");
        nomeClasse = teclado.nextLine();

        System.out.println("\nQuantas notas tem cada aluno? ");
        quantNotas = teclado.nextInt();

        // criar objeto diário de classe
        turma = new Diario(nomeClasse, quantNotas);
    }

    public static void adicionarAlunos()
    {
        fflush();

        int quantAlunos;

        System.out.println("\nQuantos alunos deseja adicionar? ");
        quantAlunos = teclado.nextInt();

        for (int i = 0; i < quantAlunos; i++)
        {
            String nome;
            int RA, nota;

            teclado.nextLine();      // limpar o buffer

            System.out.println("\n-=-=- ALUNO " + (i + 1) + " -=-=-=-");

            System.out.println("\n -NOME: ");
            nome = teclado.nextLine();

            System.out.println("\n -RA: ");
            RA = teclado.nextInt();

            Aluno kid = new Aluno(nome, quantNotas, RA);

            for (int j = 0; j < quantNotas ; j++)
            {
                System.out.println("\n -DIGITE A NOTA " + (j + 1));
                do
                {
                    nota = teclado.nextInt();

                    if(nota < 0 || nota > 100)
                    {
                        System.out.println("\n Valor inválido!");
                    }

                } while(nota < 0 || nota > 100);

                kid.setNotas(j, nota);
            }
            turma.adicionaAluno(kid);
        }

    }

    public static void relatorio()
    {
        fflush();

        System.out.println("RELATÓRIO");
        turma.medias();

        System.out.println("Digite qualquer tecla para sair");
        teclado.nextLine();
    }

    public static void main(String[] args)
    {
        int option;
        do
        {
            fflush();

            System.out.println("==============\n\tSISTEMA DE NOTAS\n=============");
            System.out.println(" 1 - Criar diário\n 2 - Adicionar alunos\n 3 - Relatório\n 4 - Sair");

            option = teclado.nextInt();
            teclado.nextLine();         // limpar o buffer

            switch (option)
            {
                case 1:
                    criarDiario();
                    break;
                case 2:
                    adicionarAlunos();
                    break;
                case 3:
                    relatorio();
                    break;
                case 4:
                    System.out.println(" -Saindo do sistema.");
                    break;
                default:
                    System.out.println(" -Opção inválida!\n");
            }
        } while (option != 4);
    }
}

/*
do
            {
                RA = teclado.nextInt();

                if(RA > 99999999 || RA < 10000000)
                {
                    System.out.println("\n -valor inválido, tente novamente");
                }
            } while (RA > 99999999 || RA < 10000000);
 */