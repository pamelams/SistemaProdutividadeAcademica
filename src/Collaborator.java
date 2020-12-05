import java.util.ArrayList;

public class Collaborator {
    private String name;
    private String email;
    private String password;
    private ArrayList<Project> history = new ArrayList<Project>(); 
    private ArrayList<AcademicProduction> academicProduction = new ArrayList<AcademicProduction>();

    public Collaborator(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Collaborator(String name, String email, String password, ArrayList<Project> history, ArrayList<AcademicProduction> academicProduction) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.history = history;
        this.academicProduction = academicProduction;
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
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public ArrayList<Project> getHistory() {
        return history;
    }
    /* histórico de projetos ordenados em ordem decrescente pela data de término */
    public void addHistory(Project newProject) { 
        for(int i = 0; i < this.history.size(); i++) {
            if(newProject.getEndDate().isBefore(this.history.get(i).getEndDate())) {
                this.history.add(i, newProject);
                break;
            }
        }
        if(newProject.getEndDate().isAfter(this.history.get(this.history.size()).getEndDate())) {
            this.history.add(newProject);
        }
    }
    public ArrayList<AcademicProduction> getAcademicProduction() {
        return academicProduction;
    }
    /* producao academica ordenada em ordem decrescente pelo ano de publicacao */
    public void addAcademicProduction(AcademicProduction newProduction) {
        for(int i = 0; i < this.academicProduction.size(); i++){
            if(newProduction.getYearOfPublication() > academicProduction.get(i).getYearOfPublication()) {
                this.academicProduction.add(i, newProduction);
                break;
            }
        }
    }
    /* dado um colaborador, o sistema deve mostrar suas informacoes: nome, email, um historico contendo a lista 
       de projetos nos quais este colaborador participou, incluindo os projetos em andamento ordenados de forma
       decrescente pela data de termino, incluindo tambem a lista de sua producao academica */
    @Override
    public String toString() {
        String toPrint;
        toPrint = "Nome: " + this.getName();
        toPrint = toPrint + "\nEmail: " + this.getEmail();
        toPrint = toPrint + "\nHistorico: ";
        for(int i = 0; i < this.getHistory().size(); i++) {
            if(i == 0) {
                toPrint = toPrint + this.getHistory().get(i).getTitle();
            }
            else {
                toPrint = toPrint + "\n           " + this.getHistory().get(i).getTitle();
            }
        }
        toPrint = toPrint + "\nProducao academica: ";
        for(int i = 0; i < this.getAcademicProduction().size(); i++) {
            if(i == 0) {
                toPrint = toPrint + this.getAcademicProduction().get(i).getTitle();
            }
            else {
                toPrint = toPrint + "\n                    " + this.getAcademicProduction().get(i).getTitle();
            }
        }
        return toPrint;
    }
}
