import java.util.ArrayList;

public class Student extends Collaborator {
    private String type; // Aluno de graduacao, Aluno de mestrado, Aluno de doutorado
    private int status; // so pode estar em ate dois projetos em andamento

    public Student(String name, String email, String password, String type) {
        super(name, email, password);
        this.type = type; 
        this.status = 0;
    }
    public Student(String name, String email, String password, ArrayList<Project> history, ArrayList<AcademicProduction> academicProduction, String type) {
        super(name, email, password, history, academicProduction);
        this.type = type; 
        this.status = 0;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public int getStatus() {
        int sum = 0;
        for(int i = 0; i < this.getHistory().size(); i++) {
            if(this.getHistory().get(i).getStatus() == 1) {
                sum += 1;
            }
        }
        this.status = sum;
        return this.status;
    }
    /* se o projeto estiver em elaboracao ou andamento, um aluno de graduacao que ja esteja em dois projetos em
       andamento nao pode ser alocado */
    @Override
    public void addHistory(Project newProject) {
        if(newProject.getStatus() == 0 || newProject.getStatus() == 1) { 
            if(this.type == "Aluno de Graduacao") {
                if(this.status == 0 || this.status == 1) {
                    this.status = this.status +1;
                }
                else if(this.status == 2) {
                    System.out.println("Nao foi possivel alocar o aluno");
                    return;
                }
            }
        }
        super.addHistory(newProject);
    }
    @Override
    public String toString() {
        return super.toString() + "\nVinculo: " + this.getType();
    }
}
