package main;
import java.util.ArrayList;

public class Publication extends AcademicProduction {
    private ArrayList<Collaborator> authors = new ArrayList<Collaborator>();
    private String conferenceName;
    private ArrayList<Project> associatedProject = new ArrayList<Project>();

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
    public String getConferenceName() {
        return conferenceName;
    }
    //addAuthor
    //addAssociatedProject
}
