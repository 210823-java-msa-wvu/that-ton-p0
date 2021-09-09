package services;

import models.ProfUser;
import repositories.ProfUserRepo;


public class ProfServices {

    ProfUserRepo profUserRepo = new ProfUserRepo();

    public boolean profLogin(String username, String password) {
        ProfUser pu = profUserRepo.getByUsername(username);

        if (pu != null) {
            if (username.equals(pu.getProfEmail()) && password.equals(pu.getProfPw())) {
                return true;
            }
        }
        return false;
    }
}
