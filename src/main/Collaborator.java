package main;
import java.util.ArrayList;

public class Collaborator {
    private String name;
    private String email;
    private ArrayList<Project> history = new ArrayList<Project>(); 
    private ArrayList<AcademicProduction> academicProduction = new ArrayList<AcademicProduction>();

    public Collaborator() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void addHistory(Project newProject) { 
        for(int i = 0; i < this.history.size(); i++) {
            if(newProject.getEndDate().isBefore(this.history.get(i).getEndDate()) {
                this.history.add(i, newProject);
            }
            if(newProject.getEndDate().isAfter(this.history.get(this.history.size()).getEndDate()){
                this.history.add(newProject);
            }
        }
    }
    //addAcademicProduction
    //printInformation
}
