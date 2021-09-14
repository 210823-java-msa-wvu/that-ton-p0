import models.ProfUser;
import models.Student;
import org.junit.Test;
import repositories.ProfRepo;
import repositories.ProfUserRepo;
import repositories.StudentRepo;
import services.ProfServices;
import services.StudentServices;

import static org.junit.Assert.assertEquals;

public class RevatureCollegeTest {
    private static final ProfServices profServices = new ProfServices();
    private static final StudentServices studentServices = new StudentServices();
    private static final StudentRepo studentRepo = new StudentRepo();
    private static final ProfUserRepo profUserRepo = new ProfUserRepo();
    private static final ProfUser profUser = profUserRepo.getByUsername("tton@revature.edu");
    private static final Student student = studentRepo.getByEmail("wbrett@revature.edu");


    @Test
    public void testProfessorUsernamePassword() {
        assertEquals("tton@revature.edu", profUser.getProfEmail());
        assertEquals("pass123", profUser.getProfPw());
    }

    @Test
    public void testStudentInformation() {
        assertEquals("Will", student.getFirstName());
        assertEquals("Brett", student.getLastName());
        assertEquals("wbrett@revature.edu", student.getStudentEmail());
        assertEquals("Marketing", student.getStudentMajor());
    }


}
