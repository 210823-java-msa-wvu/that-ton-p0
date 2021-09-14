package services;

import models.ProfUser;
import models.Professor;
import models.Scholarship;
import models.Student;
import repositories.ProfRepo;
import repositories.ProfUserRepo;
import repositories.ScholarRepo;

import java.util.ArrayList;
import java.util.List;


public class ProfServices {

    ProfUserRepo profUserRepo = new ProfUserRepo();
    ScholarRepo scholarRepo = new ScholarRepo();
    ProfRepo profRepo = new ProfRepo();

    public boolean profLogin(String username, String password) {
        ProfUser pu = profUserRepo.getByUsername(username);

        if (pu != null) {
            if (username.equals(pu.getProfEmail()) && password.equals(pu.getProfPw())) {
                return true;
            }
        }
        return false;
    }

    public ProfUser profCreate(Integer id, String email, String pw) {

        ProfUser pu = new ProfUser(id, email, pw);
        pu = profUserRepo.add(pu);
        return pu;
    }

    public Professor createInformation(Integer id, String fn, String ln, String em) {
        Professor s = new Professor(id,fn,ln,em);
        s = profRepo.add(s);
        return s;
    }

    public void decision(Integer scholarshipID, Double amount, String decision) {

        Scholarship sc = new Scholarship(scholarshipID,amount,decision);
        scholarRepo.profUpdate(sc);

    }

    public void apply(Integer scholarshipID, Boolean isApply) {

        Scholarship sc = new Scholarship(scholarshipID,isApply);
        scholarRepo.update(sc);

    }

    public List<Scholarship> scholarshipList() {

        List<Scholarship> scholarshipList = new ArrayList<>();
        scholarshipList = scholarRepo.getAll();
        System.out.println();
        for (Scholarship sc : scholarshipList) {
            System.out.println(sc);
        }
        System.out.println();
        return scholarshipList;

    }

    public boolean checkScholarshipID(Integer id) {
        Scholarship pu = scholarRepo.getById(id);

        if (pu != null){
            if (id.equals(pu.getScholarshipID()))
                return true;
        }
        return false;
    }

    public boolean checkProfId(Integer id) {
        Professor pu = profRepo.getById(id);

        if (pu != null){
            if (id.equals(pu.getProfessorID()))
                System.out.println("Professor ID " + id + " already exists!!!");
            return false;
        }
        return true;
    }

}
