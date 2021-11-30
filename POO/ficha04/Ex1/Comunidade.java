package ficha04.Ex1;

public class Comunidade {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Andre", 1234);
        Aluno aluno2 = new Aluno("Colaco", 5678);
        Docente docente1 = new Docente("luis", 1111);
        Docente docente2 = new Docente("antonio", 2222);

        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(docente1);
        System.out.println(docente2);

        System.out.println();

        System.out.println(aluno1.comunica());
        System.out.println(aluno2.comunica());
        System.out.println(docente1.comunica());
        System.out.println(docente2.comunica());
    }
}
