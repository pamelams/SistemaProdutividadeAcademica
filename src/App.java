import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    static ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
    static ArrayList<Project> projects = new ArrayList<Project>();
    static ArrayList<AcademicProduction> productions = new ArrayList<AcademicProduction>();
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Menu.principalMenu();
        Menu.addNewCollaborator(collaborators);
        Menu.addNewCollaborator(collaborators);
        System.out.println(collaborators.get(0));
        
    }
    /* Consulta por projeto */
    public static Project searchProject(String title) {
        ArrayList<Project> solution = new ArrayList<Project>();
        title = title.toLowerCase();
        for(int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getTitle().toLowerCase().contains("title")) {
                solution.add(projects.get(i));
            }
        }
        System.out.println("(0) Voltar");
        for(int i = 0; i < solution.size(); i++) {
            System.out.println("("+ i +")"+" "+ solution.get(i).getTitle());
        }
        int selec;
        do {
            selec = read.nextInt();
        } while(selec < 0 || selec > solution.size()); // verifica se a entrada esta dentro do limite
        if(selec == 0) {
            return null;
        }
        else {
            solution.get(selec).printProjectInformation(); // imprime informações do projeto
            return solution.get(selec);
        }

    }
}