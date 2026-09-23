import java.util.Scanner;
import java.util.ArrayList;

public class Diario
{
    
    // atributos da classe
    String nomeClasse;
    int quantNotas;
    ArrayList<Aluno> lista;

    // construtor pra classe diário
    public Diario (String nomeClasse, int quantNotas)
    {
        this.nomeClasse = nomeClasse;
        this.quantNotas = quantNotas;
        lista = new ArrayList<>();
    }

    // método pra criar um aluno novo
    public void adicionaAluno (Aluno kid)
    {
        lista.add(kid);
    }

    // retorna as médias dos alunos
    public void medias()
    {
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println("=========\nALUNO " + (i + 1));
            System.out.println("\n -Nome: " + lista.get(i).getNome());
            for(int j = 0; j < quantNotas; j++)
            {
                System.out.println("\t - nota " + (j + 1) + ": " + lista.get(j).getNotas(j));
            }
            System.out.println("\n -Média: " + lista.get(i).getMedia());
        }
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