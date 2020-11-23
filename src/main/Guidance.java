package main;
public class Guidance extends AcademicProduction {
    private Professor advisor;
    private Student student;

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
}
