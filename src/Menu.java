import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    static Scanner read = new Scanner(System.in);
    public static void principalMenu() {
        System.out.println("#########--MENU PRINCIPAL--#########");
        System.out.println("------------------------------------");
        System.out.println("(1) Adicionar novo colaborador      ");
        System.out.println("(2) Editar colaborador              ");
        System.out.println("(3) Adicionar novo projeto          ");
        System.out.println("(4) Editar projeto                  ");
        System.out.println("(5) Adicionar producao academica    ");
        System.out.println("(6) Consultar por colaborador       ");
        System.out.println("(7) Consultar por projeto           ");
        System.out.println("(8) Gerar relatório de produtividade");
        System.out.println("------------------------------------");
    }
    public static void addNewCollaborator(ArrayList<Collaborator> collaborators) {
        CompareName cn = new CompareName();
        String name, email, password, confirm;
        int selec;
        System.out.println("#########--ADICIONAR NOVO COLABORADOR--#########");
        System.out.println("\nDigite o nome do novo colaborador: ");
        name = read.nextLine();
        System.out.println("\nDigite o email do novo colaborador: ");
        email = read.nextLine();
        for(int i = 0; i < collaborators.size(); i++){  // verifica se o email ja foi cadastrado
            if(email.equals(collaborators.get(i).getEmail())){
                System.out.println("\nEmail ja cadastrado!");
                return;
            }
        }
        do{
            System.out.println("\nDigite a senha do novo colaborador: ");
            password = read.nextLine();
            System.out.println("\nConfirme a senha: ");
            confirm = read.nextLine();
            if(!(password.equals(confirm))) {
                System.out.println("\nSenha incorreta!");
            }
        }while(!(password.equals(confirm)));    // confirmacao de senha
        System.out.println("Selecione o tipo de vínculo:");
        System.out.println("\n(1) Professor");
        System.out.println("\n(2) Pesquisador");
        System.out.println("\n(3) Aluno");
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 0 || selec > 3);
        if(selec == 0) {
            return;
        }
        else if(selec == 1) {
            Professor newCollaborator = new Professor(name, email, password);
            collaborators.add(newCollaborator);
        }
        else if(selec == 2) {
            Researcher newCollaborator = new Researcher(name, email, password);
            collaborators.add(newCollaborator);
        }
        else if(selec == 3) {
            String type = "Aluno";
            System.out.println("\nSelecione o tipo de aluno:");
            System.out.println("\n(1) Aluno de graduacao");
            System.out.println("\n(2) Aluno de mestrado");
            System.out.println("\n(3) Aluno de doutorado");
            do {
                selec = read.nextInt();
                read.nextLine();
            } while(selec < 1 || selec > 3);
            if(selec == 1) {
                type = "Aluno de graduacao";
            }
            else if(selec == 2) {
                type = "Aluno de mestrado";
            }
            else if(selec == 3) {
                type = "Aluno de doutorado";
            }
            Student newCollaborator = new Student(name, email, password, type);
            collaborators.add(newCollaborator);
        }
        Collections.sort(collaborators, cn);
    }
    public static void editCollaborator() {
        System.out.println("#########--EDITAR COLABORADOR--#########");
    }
    public static void addNewProject(ArrayList<Project> projects) {
    /*    CompareName cn = new CompareName();
        String name, email;
        int selec; */
        System.out.println("#########--ADICIONAR NOVO COLABORADOR--#########");
    }
    public static void editProject() {
        System.out.println("#########--EDITAR PROJETO--#########");
    }
    public static void addAcademicProductionMenu() {
        System.out.println("#########--ADICIONAR PRODUCAO ACADEMICA--#########");
    }
    public static void searchCollaborator() {
        ArrayList<Collaborator> solution = new ArrayList<Collaborator>();
        System.out.println("#########--BUSCAR COLABORADOR--#########");
        
    }
    public static void searchByEmail() {

    }
    public Collaborator searchByName(ArrayList<Collaborator> collaborators) {
        ArrayList<Collaborator> solution = new ArrayList<Collaborator>();
        String name;
        int selec;
        System.out.println("Digite o nome do colaborador:");
        name = read.nextLine();
        name = name.toLowerCase();
        for(int i = 0; i < collaborators.size(); i++) {
            if(collaborators.get(i).getName().toLowerCase().contains(name)) {
                solution.add(collaborators.get(i));
            }
        }
        for(int i = 0; i < solution.size(); i++) {
            System.out.println("\n("+ i +")"+" "+ solution.get(i).getName() + "\n    Email: " + solution.get(i).getEmail() + "\n");
        }
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 0 || selec > solution.size()); // verifica se a entrada esta dentro do limite
        return solution.get(selec);
        
    }
    public static void searchProject() {
        System.out.println("#########--BUSCAR PROJETO--#########");
    }
    public static void productionReport() {
        System.out.println("#########--RELATORIO DE PRODUTIVIDADE--#########");
    }
}
