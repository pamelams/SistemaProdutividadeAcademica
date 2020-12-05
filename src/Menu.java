import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
    static Scanner read = new Scanner(System.in);
    public static void principalMenu() {
        System.out.println("#########--MENU PRINCIPAL--#########");
        System.out.println("------------------------------------");
        System.out.println("(1) Adicionar novo colaborador      ");
        System.out.println("(2) Editar colaborador              ");
        System.out.println("(3) Adicionar novo projeto          ");
        System.out.println("(4) Editar projeto                  ");
        System.out.println("(5) Adicionar producao academica    ");
        System.out.println("(6) Consultar por colaborador       ");
        System.out.println("(7) Consultar por projeto           ");
        System.out.println("(8) Gerar relatório de produtividade");
        System.out.println("------------------------------------");
    }
    public static void addNewCollaborator(ArrayList<Collaborator> collaborators) {
        CompareName cn = new CompareName();
        String name, email, password, confirm;
        int selec;
        System.out.println("#########--ADICIONAR NOVO COLABORADOR--#########");
        System.out.println("\nDigite o nome do novo colaborador: ");
        name = read.nextLine();
        System.out.println("\nDigite o email do novo colaborador: ");
        email = read.nextLine();
        for(int i = 0; i < collaborators.size(); i++){  // verifica se o email ja foi cadastrado
            if(email.equals(collaborators.get(i).getEmail())){
                System.out.println("\nEmail ja cadastrado!");
                return;
            }
        }
        do{
            System.out.println("\nDigite a senha do novo colaborador: ");
            password = read.nextLine();
            System.out.println("\nConfirme a senha: ");
            confirm = read.nextLine();
            if(!(password.equals(confirm))) {
                System.out.println("\nSenha incorreta!");
            }
        }while(!(password.equals(confirm)));    // confirmacao de senha
        System.out.println("Selecione o tipo de vínculo:");
        System.out.println("(1) Professor");
        System.out.println("(2) Pesquisador");
        System.out.println("(3) Aluno");
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 0 || selec > 3);
        if(selec == 0) {
            return;
        }
        else if(selec == 1) {
            Professor newCollaborator = new Professor(name, email, password);
            collaborators.add(newCollaborator);
        }
        else if(selec == 2) {
            Researcher newCollaborator = new Researcher(name, email, password);
            collaborators.add(newCollaborator);
        }
        else if(selec == 3) {
            String type = "Aluno";
            System.out.println("\nSelecione o tipo de aluno:");
            System.out.println("(1) Aluno de graduacao");
            System.out.println("(2) Aluno de mestrado");
            System.out.println("(3) Aluno de doutorado");
            do {
                selec = read.nextInt();
                read.nextLine();
            } while(selec < 1 || selec > 3);
            if(selec == 1) {
                type = "Aluno de graduacao";
            }
            else if(selec == 2) {
                type = "Aluno de mestrado";
            }
            else if(selec == 3) {
                type = "Aluno de doutorado";
            }
            Student newCollaborator = new Student(name, email, password, type);
            collaborators.add(newCollaborator);
        }
        Collections.sort(collaborators, cn);
    }
    public static void editCollaborator(Collaborator person) {
        int selec;
        String change, confirm;
        System.out.println("#########--EDITAR COLABORADOR--#########");
        System.out.println("(1) Editar nome");
        System.out.println("(2) Editar email");
        System.out.println("(3) Editar senha");
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 1 || selec > 3);
        if(selec == 1) {
            System.out.println("Digite o nome do colaborador: ");
            change = read.nextLine();
            person.setName(change);
        }
        else if(selec == 2) {
            System.out.println("Digite o email do colaborador: ");
            change = read.nextLine();
            person.setEmail(change);
        }
        else if(selec == 3) {
            System.out.println("Digite o nome do colaborador: ");
            change = read.nextLine();
            do{
                System.out.println("\nDigite a nova senha do colaborador: ");
                change = read.nextLine();
                System.out.println("\nConfirme a senha: ");
                confirm = read.nextLine();
                if(!(change.equals(confirm))) {
                    System.out.println("\nSenha incorreta!");
                }
            }while(!(change.equals(confirm)));    // confirmacao de senha
            person.setPassword(change);
        }
    }
    public static void addNewProject(ArrayList<Project> projects, ArrayList<Collaborator> collaborators) {
        CompareTitle ct = new CompareTitle();
        String title, fundingAgency, objective, description;
        LocalDate startDate, endDate;
        int day, month, year;
        Double fundingValue;
        int selec; 
        System.out.println("#########--ADICIONAR NOVO PROJETO--#########");
        System.out.println("\nDigite o titulo do projeto: ");
        title = read.nextLine();
        for(int i = 0; i < projects.size(); i++){  // verifica se nome de projeto ja existe
            if(title.equals(projects.get(i).getTitle())){
                System.out.println("\nTitulo ja cadastrado!");
                return;
            }
        }
        Project newProject = new Project(title);
        System.out.println("\nAdicionar data de inicio?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nDigite a data de inicio do projeto(dia, mes e ano separados por espaço): ");
            day = read.nextInt();
            month = read.nextInt();
            year = read.nextInt();
            read.nextLine();
            startDate = LocalDate.of(year, month, day);
            newProject.setStartDate(startDate);
        }
        System.out.println("\nAdicionar data de termino?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nDigite a data de termino do projeto(dia, mes e ano separados por espaço): ");
            day = read.nextInt();
            month = read.nextInt();
            year = read.nextInt();
            read.nextLine();
            endDate = LocalDate.of(year, month, day);
            newProject.setEndDate(endDate);
        }
        System.out.println("\nAdicionar agencia financiadora?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nInforme a agencia financiadora do projeto: ");
            fundingAgency = read.nextLine();
            newProject.setFundingAgency(fundingAgency);
        }
        System.out.println("\nAdicionar valor financiado?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nInforme o valor financiado(separado por ponto): ");
            fundingValue = Double.parseDouble(read.nextLine());
            newProject.setFundingValue(fundingValue);
        }
        System.out.println("\nAdicionar objetivo do projeto?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nInforme o objetivo do projeto: ");
            objective = read.nextLine();
            newProject.setObjective(objective);
        }
        System.out.println("\nAdicionar descricao do projeto?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            System.out.println("\nInforme a descricao do projeto: ");
            description = read.nextLine();
            newProject.setDescription(description);
        }
        System.out.println("\nAdicionar participantes?");
        System.out.println("\n(1) Adicionar agora");
        System.out.println("\n(2) Adicionar depois");
        selec = read.nextInt();
        read.nextLine();
        if(selec == 1) {
            boolean added;
            do{
                added = false;
                Collaborator participant = searchCollaborator(collaborators);
                if(newProject.getParticipants() != null) {
                    for(int i = 0; i < newProject.getParticipants().size(); i++) {
                        if(participant.getEmail() == newProject.getParticipants().get(i).getEmail()) {
                            added = true;
                            break;
                        }
                    }
                }
                if(added == false) {
                    if(participant.getClass().getSimpleName() == "Student") {
                        Student st = (Student) participant;
                        newProject.addParticipant(st);
                    }
                    newProject.addParticipant(participant);
                } 
                System.out.println("\n" + participant.getName() + " foi adicionado!");
                System.out.println("\nAdicionar outro participante?");
                System.out.println("\n(1) Sim");
                System.out.println("\n(2) Nao");
                selec = read.nextInt();
                read.nextLine();
            }while(selec == 1);
        }
        projects.add(newProject);
        Collections.sort(projects, ct); // mantem a lista de projetos em ordem alfabetica
    }
    public static void editProject(Project pj, ArrayList<Project> projects, ArrayList<Collaborator> collaborators) {
        int selec;
        System.out.println("#########--EDITAR PROJETO--#########");
        System.out.println("(1) Editar titulo");
        System.out.println("(2) Editar data de inicio");
        System.out.println("(3) Editar data de termino");
        System.out.println("(4) Editar agencia financiadora");
        System.out.println("(5) Editar valor financiado");
        System.out.println("(6) Editar objetivo");
        System.out.println("(7) Editar descricao");
        System.out.println("(8) Adicionar participante");
        System.out.println("(9) Remover participante");
        System.out.println("(10) Mudar status");
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 1 || selec > 10);
        if(selec == 1) {
            String title;
            CompareTitle ct = new CompareTitle();
            System.out.println("\nDigite o novo titulo do projeto: ");
            title = read.nextLine();
            for(int i = 0; i < projects.size(); i++){  // verifica se nome de projeto ja existe
                if(title.equals(projects.get(i).getTitle())){
                    System.out.println("\nTitulo ja cadastrado!");
                    return;
                }
            }
            pj.setTitle(title);
            Collections.sort(projects, ct); // mantem a lista de projetos em ordem alfabetica
        }
        else if(selec == 2) {
            int day, month, year;
            LocalDate startDate;
            System.out.println("\nDigite a data de inicio do projeto(dia, mes e ano separados por espaço): ");
            day = read.nextInt();
            month = read.nextInt();
            year = read.nextInt();
            read.nextLine();
            startDate = LocalDate.of(year, month, day);
            pj.setStartDate(startDate);
        }
        else if(selec == 3) {
            int day, month, year;
            LocalDate endDate;
            System.out.println("\nDigite a data de termino do projeto(dia, mes e ano separados por espaço): ");
            day = read.nextInt();
            month = read.nextInt();
            year = read.nextInt();
            read.nextLine();
            endDate = LocalDate.of(year, month, day);
            pj.setEndDate(endDate);
        }
        else if(selec == 4) {
            String fundingAgency;
            System.out.println("\nDigite o nome da agencia financiadora: ");
            fundingAgency = read.nextLine();
            pj.setFundingAgency(fundingAgency);
        }
        else if(selec == 5) {
            Double fundingValue;
            System.out.println("\nDigite o valor financiado: ");
            fundingValue = read.nextDouble();
            read.nextLine();
            pj.setFundingValue(fundingValue);
        }
        else if(selec == 6) {
            String objective;
            System.out.println("\nDigite o objetivo do projeto: ");
            objective = read.nextLine();
            pj.setObjective(objective);
        }
        else if(selec == 7) {
            String description;
            System.out.println("\nDigite a descricao do projeto: ");
            description = read.nextLine();
            pj.setDescription(description);
        }
        else if(selec == 8) {
            Collaborator participant;
            boolean added;
            System.out.println("\nAdicionar participante:");
            if(pj.getStatus() == 0) {   // verifica se projeto esta em andamento
                do{
                    added = false;
                    participant = searchCollaborator(collaborators);
                    if(pj.getParticipants() != null) {
                        for(int i = 0; i < pj.getParticipants().size(); i++) {
                            if(participant.getEmail() == pj.getParticipants().get(i).getEmail()) {
                                added = true;
                                break;
                            }
                        }
                    }
                    if(added == false) {
                        if(participant.getClass().getSimpleName() == "Student") {
                            Student st = (Student) participant;
                            pj.addParticipant(st);
                        }
                        else{
                            pj.addParticipant(participant);
                        }  
                    } 
                    System.out.println("\nAdicionar outro participante?");
                    System.out.println("\n(1) Sim");
                    System.out.println("\n(2) Nao");
                    do {
                        selec = read.nextInt();
                        read.nextLine();
                    } while(selec < 1 || selec > 2);
                } while(selec == 1);
            }
            else {
                System.out.println("\nNao e possivel fazer alocacao! (O projeto nao esta em elaboracao)");
            }  
        }
        else if(selec == 9) {
            Collaborator participant;
            System.out.println("\nRemover participante: ");
            if(pj.getStatus() == 0) {
                participant = searchCollaborator(collaborators);
                pj.removeParticipant(participant.getEmail());
            }
            else {
                System.out.println("\nNao e possivel fazer alocacao!(O projeto nao esta em elaboracao)");
            }
        }
        else if(selec == 10) {
            System.out.println("\nMudar status: ");
            pj.changeStatus();
        }
    }
    public static void addAcademicProductionMenu(ArrayList<Collaborator> collaborators, ArrayList<AcademicProduction> productions) {
        int selec;
        String title;
        int yearOfPublication;
        System.out.println("#########--ADICIONAR PRODUCAO ACADEMICA--#########");
        System.out.println("\nSelecione o tipo de producao academica: ");
        System.out.println("\n(1) Publicacao");
        System.out.println("\n(2) Orientacao");
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 1 || selec > 2);
        if(selec == 1) {
            Collaborator author;
            String conferenceName;
            Project associatedProject;
            boolean added;

            System.out.println("#########--ADICIONAR PUBLICACAO--#########");
            System.out.println("\nDigite o titulo da publicacao: ");
            title = read.nextLine();
            System.out.println("\nDigite o ano de publicacao: ");
            yearOfPublication = read.nextInt();
            read.nextLine();
            System.out.println("\nDigite o nome da conferencia onde foi publicada: ");
            conferenceName = read.nextLine();
            Publication newPublication = new Publication(title, yearOfPublication, conferenceName);
            System.out.println("\nAdicionar autores: ");
            do{
                added = false;
                author = searchCollaborator(collaborators);
                if(newPublication.getAuthors() != null) {
                    for(int i = 0; i < newPublication.getAuthors().size(); i++) {   // verifica se autor ja foi adicionado
                        if(author.getEmail() == newPublication.getAuthors().get(i).getEmail()) {
                            added = true;
                            break;
                        }
                    }
                }
                if(added == false) {
                    newPublication.addAuthor(author);
                    author.addAcademicProduction(newPublication);
                } 
                else {
                    System.out.println("\nAutor ja foi adicionado!");
                }
                System.out.println("\nAdicionar outro participante?");
                System.out.println("\n(1) Sim");
                System.out.println("\n(2) Nao");
                do {
                    selec = read.nextInt();
                    read.nextLine();
                } while(selec < 1 || selec > 2);
            } while(selec == 1);
            productions.add(newPublication);
            selec = 1;
        }
        else if(selec == 2) {
            Professor advisor;
            Student student;
            ArrayList<Collaborator> professors = new ArrayList<Collaborator>();
            ArrayList<Collaborator> students = new ArrayList<Collaborator>();
            System.out.println("#########--ADICIONAR ORIENTACAO--#########");
            System.out.println("\nDigite o titulo da orientacao: ");
            title = read.nextLine();
            System.out.println("\nDigite o ano de publicacao: ");
            yearOfPublication = read.nextInt();
            read.nextLine();
            System.out.println("\nAdicionar orientador: ");
            for(int i = 0; i < collaborators.size(); i++) {
                if(collaborators.get(i).getClass().getSimpleName() == "Professor") {
                    professors.add((Professor) collaborators.get(i));
                }
                else if(collaborators.get(i).getClass().getSimpleName() == "Student") {
                    students.add((Student) collaborators.get(i));
                }
            }
            advisor = (Professor) searchCollaborator(professors);
            System.out.println("\nAdicionar aluno: ");
            student = (Student) searchCollaborator(students);
            Guidance newGuidance = new Guidance(title, yearOfPublication, advisor, student);
            productions.add(newGuidance);
            advisor.addAcademicProduction(newGuidance);
            student.addAcademicProduction(newGuidance);

        }
    }
    public static Collaborator searchCollaborator(ArrayList<Collaborator> collaborators) {
        ArrayList<Collaborator> solution = new ArrayList<Collaborator>();
        String name;
        int selec;
        System.out.println("#########--BUSCAR COLABORADOR--#########");
        System.out.println("Digite o nome ou email do colaborador: ");
        name = read.nextLine();
        name = name.toLowerCase();
        for(int i = 0; i < collaborators.size(); i++) {
            if(collaborators.get(i).getName().toLowerCase().contains(name) || collaborators.get(i).getEmail().toLowerCase().contains(name)) {
                solution.add(collaborators.get(i));
            }
        }
        System.out.println("\nSelecione o colaborador: ");
        for(int i = 0; i < solution.size(); i++) {
            System.out.println("\n("+ i +")"+" "+ solution.get(i).getName() + "\n    Email: " + solution.get(i).getEmail() + "\n");
        }
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 0 || selec > solution.size()); // verifica se a entrada esta dentro do limite
        return solution.get(selec);
    }
    public static Project searchProject(ArrayList<Project> projects) {
        ArrayList<Project> solution = new ArrayList<Project>();
        String name;
        int selec;
        System.out.println("#########--BUSCAR PROJETO--#########");
        System.out.println("Digite o nome ou email do colaborador: ");
        name = read.nextLine();
        name = name.toLowerCase();
        for(int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getTitle().toLowerCase().contains(name)) {
                solution.add(projects.get(i));
            }
        }
        System.out.println("\nSelecione o colaborador: ");
        for(int i = 0; i < solution.size(); i++) {
            System.out.println("\n("+ i +")"+" "+ solution.get(i).getTitle() + "\n    Descricao: " + solution.get(i).getDescription() + "\n");
        }
        do {
            selec = read.nextInt();
            read.nextLine();
        } while(selec < 0 || selec > solution.size()); // verifica se a entrada esta dentro do limite
        return solution.get(selec);

    }
    public static void productionReport(ArrayList<Collaborator> collaborators, ArrayList<Project> projects, ArrayList<AcademicProduction> productions) {
        int nCollaborators = 0, nInElaboration = 0, nInProgress = 0, nCompleted = 0, nProjects = 0, nPublications = 0, nGuidances = 0;
        for(int i = 0; i < collaborators.size(); i++) {
            nCollaborators += 1;
        }
        for(int i = 0; i < projects.size(); i++) {
            nProjects += 1;
            if(projects.get(i).getStatus() == 0) {
                nInElaboration += 1;
            }
            else if(projects.get(i).getStatus() == 1) {
                nInProgress += 1;
            }
            else if(projects.get(i).getStatus() == 2) {
                nCompleted += 1;
            }
        }
        for(int i = 0; i < productions.size(); i++) {
            if(productions.get(i).getClass().getSimpleName() == "Publication") {
                nPublications += 1;
            }
            else if(productions.get(i).getClass().getSimpleName() == "Guidance") {
                nGuidances += 1;
            }
        }
        System.out.println("#########--RELATORIO DE PRODUTIVIDADE--#########");
        System.out.println("\nNumero de colaboradores: " + nCollaborators);
        System.out.println("\nNumero de projetos em elaboracao: " + nInElaboration);
        System.out.println("\nNumero de projetos em andamento: " + nInProgress);
        System.out.println("\nNumero de projetos concluidos: " + nCompleted);
        System.out.println("\nNumero total de projetos: " + nProjects);
        System.out.println("\nNumero de publicacoes: " + nPublications);
        System.out.println("\nNumero de orientacoes: " + nGuidances);
    }
    /*  O sistema deve fornecer um relatório de produção acadêmica do laboratório,
        contendo:
        a. Número de colaboradores
        b. Número de projetos em elaboração
        c. Número de projetos em andamento
        d. Número de projetos concluídos
        e. Número total de projetos
        f. Número de produção acadêmica por tipo de produçã0 */
}
