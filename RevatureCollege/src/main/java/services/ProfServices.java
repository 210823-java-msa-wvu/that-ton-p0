package services;

import models.ProfUser;
import models.Professor;
import models.Scholarship;
import repositories.ProfUserRepo;
import repositories.ScholarRepo;

import java.util.ArrayList;
import java.util.List;


public class ProfServices {

    ProfUserRepo profUserRepo = new ProfUserRepo();
    ScholarRepo scholarRepo = new ScholarRepo();

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
}
