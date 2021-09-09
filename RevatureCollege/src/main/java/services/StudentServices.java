package services;

import models.ProfUser;
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

    public StudentUser stuCreate(Integer id, String email, String pw) {

        StudentUser su = new StudentUser(id, email, pw);
        su = studentUserRepo.add(su);
        return su;
    }
}
