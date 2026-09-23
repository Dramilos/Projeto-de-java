public class Aluno
{
    // atributos da classe
    private String nome;
    private int notas[];
    private int RA;

    // construtor da classe Aluno
    public Aluno (String nome, int quantNotas, int RA)
    {
        this.nome = nome;
        notas = new int[quantNotas];
        this.RA = RA;
    }

    // métodos para as notas do aluno
    public void setNotas(int i, int nota)
    {
        notas[i] = nota;
    }

    public int getNotas(int i)
    {
        return notas[i];
    }

    public float getMedia()
    {
        float media = 0;

        for(int i = 0; i < notas.length; i++)
        {
            media += notas[i];
        }
        media = media / notas.length;

        return media;
    }

    // métodos pra setar e getar o nome
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }
    
    // set e get o RA
    public void setRA(int RA)
    {
        this.RA = RA;
    }

    public int getRA()
    {
        return RA;
    }

}