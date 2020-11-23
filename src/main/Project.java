package main;
import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String fundigAgency;
    private Double fundingValue;
    private String objective;
    private String description;
    private ArrayList<Collaborator> participants;
    private ArrayList<Publication> publications;
    private int status; // 0 = em elaboracao; 1 = em andamento; 2 = concluido.

    public Project(){
        this.title = null;
        this.startDate = null;
        this.endDate = null;
        this.fundigAgency = null;
        this.fundingValue = null;
        this.objective = null;
        this.description = null;
        this.participants = null;
        this.publications = null;
        this.status = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getStartDate() {
        return this.startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public LocalDate getEndDate() {
        return this.endDate;
    }
    public void setFundingAgency(String fundingAgency) {
        this.fundigAgency = fundigAgency;
    }
    public String getFundingAgency() {
        return this.fundigAgency;
    }
    public void setFundingValue(Double fundingValue) {
        this.fundingValue = fundingValue;
    }
    public Double getFundingValue() {
        return this.fundingValue;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getObjective() {
        return this.objective;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    public ArrayList<Collaborator> getParticipants() {
        return this.participants;
    }
    public void addParticipant(Collaborator newParticipant){
        if(this.participants == null){
            this.participants = new ArrayList<Collaborator>();
        }
        this.participants.add(newParticipant);
    }
    public void removeParticipant(){
        
    }
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
            if(checkBasicInformation() == true) {
                this.status = 1;
            }
        }
        if(this.status == 1) {
            if(this.publications != null) {
                this.status = 2;
            }
        }
    }
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
        if(isProfessor && this.title != null && this.startDate != null && this.endDate != null && this.fundigAgency != null 
        && this.fundingValue != null && this.objective != null && this.description != null) {
            return true;
        }
        else{
            return false;
        }
    }
}