public class Guidance extends AcademicProduction {
    private Professor advisor;
    private Student student;

    public Guidance(String title, int yearOfPublication, Professor advisor, Student student) {
        super(title, yearOfPublication);
        this.advisor = advisor;
        this.student = student;
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }
    public Professor getAdvisor() {
        return advisor;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }
    @Override
    public String toString() {
        String toPrint;
        toPrint = "Titulo: " + this.getTitle();
        toPrint = toPrint + "\n Aluno: " + this.getStudent().getName();
        toPrint = toPrint + "\n Orientador: " + this.getAdvisor().getName();
        toPrint = toPrint + "\n Ano de publicacao: " + this.getYearOfPublication();
        return toPrint;
    }
}
