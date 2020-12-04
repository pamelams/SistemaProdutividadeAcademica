public class Professor extends Collaborator {
    public Professor(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public String toString() {
        return super.toString() + "\nVinculo: Professor";
    }
}
