import java.util.ArrayList;

public class Project {
    private String title;
    private String startDate;
    private String endDate;
    private String fundigAgency;
    private double fundingValue;
    private String objective;
    private String description;
    private ArrayList<Collaborator> participants = new ArrayList<Collaborator>();
    private int status; // 0 = em elaboracao; 1 = em andamento; 2 = concluido.
}
