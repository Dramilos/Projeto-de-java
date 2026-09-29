import java.util.Scanner;

public class Principal
{
    static Scanner teclado = new Scanner(System.in);

    public static void fflush()
    {
        for (int i = 0; i < 50; i++)
        {
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int option = 0, flag;
        do
        {
            fflush();

            System.out.println("==============\n\tSISTEMA DE NOTAS\n=============");
            System.out.println(" 1 - Criar diário\n 2 - Adicionar alunos\n 3 - Relatório\n 4 - Modificar uma nota\n 5 - Sair");

            do
            {
                flag = 0;
                try
                {
                    option = Integer.parseInt(teclado.nextLine().trim());
                }
                catch (NumberFormatException e)
                {
                    System.out.println(" - Erro! Espera-se valor numérico");
                    flag = 1;
                }
            } while (flag == 1);

            try
            {
                switch (option)
                {
                    case 1:
                        Diario.criarDiario();
                        break;
                    case 2:
                        Diario.turma.adicionarAlunos();
                        break;
                    case 3:
                        Diario.turma.relatorio();
                        break;
                    case 4:
                        Diario.turma.definirNotas();
                        break;
                    case 5:
                        System.out.println(" -Saindo do sistema.");
                        break;
                    default:
                        System.out.println(" -Opção inválida!\n");
                }
            }
            catch (NullPointerException e)
            {
                System.out.println(" -O diário precisa ser criado antes de acessá-lo!");
            }
        } while (option != 5);
    }
}