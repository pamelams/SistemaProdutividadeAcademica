import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String fundingAgency;
    private Double fundingValue;
    private String objective;
    private String description;
    private ArrayList<Collaborator> participants;
    private ArrayList<Publication> publications;
    private int status; // 0 = em elaboracao; 1 = em andamento; 2 = concluido.

    public Project(String title, Collaborator participant){
        this.title = title;
        this.startDate = null;
        this.endDate = null;
        this.fundingAgency = null;
        this.fundingValue = null;
        this.objective = null;
        this.description = null;
        this.participants.add(participant);
        this.publications = null;
        this.status = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setFundingAgency(String fundingAgency) {
        this.fundingAgency = fundingAgency;
    }
    public String getFundingAgency() {
        return fundingAgency;
    }
    public void setFundingValue(Double fundingValue) {
        this.fundingValue = fundingValue;
    }
    public Double getFundingValue() {
        return fundingValue;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getObjective() {
        return objective;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Collaborator> getParticipants() {
        return participants;
    }
    public void addParticipant(Collaborator newParticipant) {
        if(this.participants == null){
            this.participants = new ArrayList<Collaborator>();
        }
        this.participants.add(newParticipant);
    }
    public void removeParticipant(String email) {
        for(int i = 0; i < this.participants.size(); i++) {
            if(email == this.participants.get(i).getEmail()){
                this.participants.remove(i);
                break;
            }
        }
    }
    public ArrayList<Publication> getPublications() {
        return publications;
    }
    /* Adiciona publicacoes em ordem decrescente de data. */
    public void addPublication(Publication newPublication){
        if(this.publications == null){
            this.publications = new ArrayList<Publication>();
        } 
        if(newPublication.getYearOfPublication() < this.publications.get(this.publications.size()).getYearOfPublication()) {
            this.publications.add(newPublication);
        }
        else {
            for(int i = 0; i < this.publications.size(); i++){
                if(newPublication.getYearOfPublication() > this.publications.get(i).getYearOfPublication()) {
                    this.publications.add(i, newPublication);
                } 
            }
        }
    }
    public int getStatus() {
        return this.status;
    }
    public void changeStatus() {
        if(this.status == 0) {
            if(this.checkBasicInformation() == true) {
                this.status = 1;
                System.out.println("Status alterado com sucesso!");
            }
            else {
                System.out.println("Nao foi possivel alterar o status.");
            }
        }
        else if(this.status == 1) {
            if(this.publications != null) {
                this.status = 2;
                System.out.println("Status alterado com sucesso!");
            }
            else {
                System.out.println("Nao foi possivel alterar o status.");
            }
        }
    }
    /* checar se as informacoes basicas foram preenchidas */
    public boolean checkBasicInformation() {
        boolean isProfessor = false;
        if(this.participants != null) {
            for(int i = 0; i < this.participants.size(); i++) {
                if(this.participants.get(i).getClass().getSimpleName() == "Professor"){
                    isProfessor = true;
                    break;
                }
            }
        }
        if(isProfessor && this.title != null && this.startDate != null && this.endDate != null && this.fundingAgency != null 
        && this.fundingValue != null && this.objective != null && this.description != null) {
            return true;
        }
        else{
            return false;
        }
    }
    /* titulo, status, data de inicio, data de termino, agencia financiadora, valor financiado, objetivo, 
       descricao, participantes e publicacoes.*/
    public void printProjectInformation() {
        System.out.println("Titulo: " + this.getTitle());
        if(this.getStatus() == 0) {
            System.out.println("Status: Em elaboracao");
        }
        else if(this.getStatus() == 1) {
            System.out.println("Status: Em andamento");
        }
        else if(this.getStatus() == 0) {
            System.out.println("Status: Concluido");
        }
        System.out.println("Data de inicio: " + this.getStartDate());
        System.out.println("Data de termino: " + this.getEndDate());
        System.out.println("Agencia financiadora: " + this.getFundingAgency());
        System.out.println("Valor financiado: " + this.getFundingValue());
        System.out.println("Objetivo: " + this.getObjective());
        System.out.println("Descrição: " + this.getDescription());
        System.out.println("Participantes: ");
        for(int i = 0; i < this.getParticipants().size(); i++){
            System.out.println("               " + this.getParticipants().get(i).getName());
        }
        System.out.println("Publicacoes: ");
        for(int i = 0; i < this.getPublications().size(); i++){
            System.out.println("             " + this.getPublications().get(i).getTitle());
        }
    }
    @Override
    public String toString() {
        String toPrint;
        toPrint = "Titulo: " + this.getTitle();
        if(this.getStatus() == 0) {
            toPrint = toPrint + "\nStatus: Em elaboracao";
        }
        else if(this.getStatus() == 1) {
            toPrint = toPrint + "\nStatus: Em andamento";
        }
        else if(this.getStatus() == 0) {
            toPrint = toPrint + "\nStatus: Concluido";
        }
        toPrint = toPrint + "\nData de inicio: " + this.getStartDate();
        toPrint = toPrint + "\nData de termino: " + this.getEndDate();
        toPrint = toPrint + "\nAgencia financiadora: " + this.getFundingAgency();
        toPrint = toPrint + "\nValor financiado: " + this.getFundingValue();
        toPrint = toPrint + "\nObjetivo: " + this.getObjective();
        toPrint = toPrint + "\nDescrição: " + this.getDescription();
        toPrint = toPrint + "\nParticipantes: ";
        for(int i = 0; i < this.getParticipants().size(); i++){
            if(i == 0) {
                toPrint = toPrint + this.getParticipants().get(i).getName();
            }
            else {
                toPrint = toPrint + "\n               " + this.getParticipants().get(i).getName();
            }
        }
        toPrint = toPrint + "\nPublicacoes: ";
        for(int i = 0; i < this.getPublications().size(); i++){
            if(i == 0) {
                toPrint = toPrint + this.getPublications().get(i).getTitle();
            }
            else {
                toPrint = toPrint + "\n             " + this.getPublications().get(i).getTitle();
            }
        }
        return toPrint;
    }
}