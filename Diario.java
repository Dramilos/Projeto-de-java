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
    public static void adicionarAlunos()
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

                kid.setNotas(j, nota);
            }
            lista.add(kid);
        }

    }


    // método que imprime um relatório
    public static void relatorio()
    {
        Principal.fflush();

        System.out.println("RELATÓRIO");
        
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println("=========\nALUNO " + (i + 1));
            System.out.println("\n -Nome: " + lista.get(i).getNome());
            for(int j = 0; j < turma.quantNotas; j++)
            {
                System.out.println("\t - nota " + (j + 1) + ": " + lista.get(i).getNotas(j));
            }
            System.out.println("\n -Média: " + lista.get(i).getMedia());
        }

        System.out.println("Digite qualquer tecla para sair");
        Principal.teclado.nextLine();
    }

    // retorna as médias dos alunos
    public void medias()
    {
        
    }

    // métodos para definir as notas de cada aluno
    public void definirNotas()
    {
        
    }

    // métodos para definir o nome da turma do diário
    public void setNomeClasse(String nomeClasse)
    {
        this.nomeClasse = nomeClasse;
    }

    public String getNomeClasse()
    {
        return nomeClasse;
    }
}