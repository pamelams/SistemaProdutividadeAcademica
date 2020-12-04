import java.util.ArrayList;
import java.util.Collections;

public class Publication extends AcademicProduction {
    private ArrayList<Collaborator> authors = new ArrayList<Collaborator>();
    private String conferenceName;
    private Project associatedProject;

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }
    public String getConferenceName() {
        return conferenceName;
    }
    /* adicionar projeto associado */
    public void setAssociatedProject(Project associatedProject) {
        this.associatedProject = associatedProject;
    }
    public Project getAssociatedProject() {
        return associatedProject;
    }
    /* adicionar autores em ordem alfabetica */
    public void addAuthor(Collaborator newAuthor) {
        CompareName cn = new CompareName();
        this.authors.add(newAuthor);
        Collections.sort(authors, cn);
    }
    public ArrayList<Collaborator> getAuthors() {
        return authors;
    }
    /* Uma publicação deve ter título, nome da conferência onde foi publicada, ano de publicação e projeto
       de pesquisa associado (se houver) */
    @Override
    public String toString() {
        String toPrint;
        toPrint = "Titulo: " + this.getTitle();
        toPrint = toPrint + "\n Conferencia: " + this.getConferenceName();
        toPrint = toPrint + "\n Ano de publicacao: " + this.getYearOfPublication();
        toPrint = toPrint + "\n Projeto de pesquisa associado: " + this.getAssociatedProject().getTitle();
        return toPrint;
    }
}
