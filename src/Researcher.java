public class Researcher extends Collaborator {
    public Researcher(String name, String email, String password) {
        super(name, email, password);
    }
    @Override
    public String toString() {
        return super.toString() + "\nVinculo: Pesquisador";
    }
}