package main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class App {
    static ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
    static ArrayList<Project> projects = new ArrayList<Project>();
    static ArrayList<AcademicProduction> productions = new ArrayList<AcademicProduction>();
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Date x = new Date();
        System.out.println(x);

        LocalDate y = LocalDate.of(2017, 2, 23);
        LocalDate z = LocalDate.of(2017, 4, 23);
        if(y.isAfter(z)){
            System.out.println(y + " is after " + z);
        }
        else{
            System.out.println(z + " iss after " + y);
        }
        

        LocalDate w = null;
        if(w == null){
            System.out.println("is null!");
        }
        w = LocalDate.of(2001, 4, 5);
        System.out.println(w.getYear());

        ArrayList<Collaborator> c = new ArrayList<Collaborator>();
        System.out.println(c.size());

        Project p = new Project();
        Professor pf = new Professor();
        pf.setName("maria");
        Student st = new Student();
        st.setName("zana");
        System.out.println(pf.getName());
        System.out.println(st.getName());

        addNewCollaborator(pf);
        addNewCollaborator(st);
        
        p.addParticipant(pf);
        System.out.println(p.getParticipants().get(0).getName());
        System.out.println("collabs: " + collaborators.get(0).getName() +", " + collaborators.get(1).getName());

        
    }

    //menu
    //productionReport
    //searchCollaborator
    // searchProject
    public static void addNewCollaborator(Collaborator newCollaborator) {
        CompareName cn = new CompareName();
        collaborators.add(newCollaborator);
        Collections.sort(collaborators, cn);
    }
    public static void addNewProject(Project newProject) {
        projects.add(newProject);
    }
    public static Project searchProject(String projectName) {

    }
}
