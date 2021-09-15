package services;

import models.Scholarship;
import models.Student;
import models.StudentUser;
import repositories.ScholarRepo;
import repositories.StudentRepo;
import repositories.StudentUserRepo;

public class StudentServices {

    StudentUserRepo studentUserRepo = new StudentUserRepo();
    StudentRepo studentRepo = new StudentRepo();
    ScholarRepo scholarRepo = new ScholarRepo();

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

    public Student getStudent(String email) {
        Student s = studentRepo.getByEmail(email);
        return s;
    }

    public Student createInformation(Integer id, String fn, String ln, String em, String mj) {
        Student s = new Student(id,fn,ln,em,mj);
        s = studentRepo.add(s);
        return s;
    }

    public boolean checkStudentID(Integer id) {
        Student pu = studentRepo.getById(id);

        if (pu != null){
            if (id.equals(pu.getStudentID())) {
                System.out.println("Student ID " + id + " already exists!!!");
                System.out.println();
            }
            return false;
        }
        return true;
    }

    public Integer getID(String email) {

        Integer id = studentRepo.returnId(email);
        return id;

    }

    public Scholarship getSchoInfo(Integer id) {

        Scholarship sc = scholarRepo.getById(id);
        return sc;

    }

    public void applyScholarship(Integer id, Boolean isApply) {

        Scholarship sc = new Scholarship(id, isApply);
        scholarRepo.update(sc);

    }

    public Scholarship createNewApplication(Integer studentid, Integer scholarid, Boolean isApply) {

        Scholarship sc = new Scholarship(studentid,scholarid,isApply);
        sc = scholarRepo.add(sc);
        return sc;

    }

    public boolean checkScholarshipID(Integer id) {
        Scholarship pu = scholarRepo.getById(id);

        if (pu != null){
            if (id.equals(pu.getScholarshipID()))
                return true;
        }
        return false;
    }

    public boolean checkIsApply(Integer id) {
        Scholarship pu = scholarRepo.getById(id);
        if ((pu.getApply()) == true)
            return true;
        else
            return false;
    }

}
