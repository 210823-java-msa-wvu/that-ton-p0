package services;

import models.StudentUser;
import repositories.StudentUserRepo;

public class StudentServices {

    StudentUserRepo studentUserRepo = new StudentUserRepo();

    public boolean studentLogin(String username, String password) {
        StudentUser su = studentUserRepo.getByUsername(username);

        if (su != null) {
            if (username.equals(su.getStudentEmail()) && password.equals(su.getStudentPw())) {
                return true;
            }
        }
        return false;
    }
}
