package repositories;

import models.Professor;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfRepo implements CrudRepository<Professor>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    // Read
    public Professor getById(Integer id) {
        // try-with-resources -> a way to initialize a resource that will then be closed after we're done with it
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from professor where professor_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks
            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Professor a = new Professor();
                a.setProfessorID(rs.getInt("professor_id"));
                a.setFirstName(rs.getString("p_first_name"));
                a.setLastName(rs.getString("p_last_name"));
                a.setProfEmail(rs.getString("email"));
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Professor> getAll() {

        List<Professor> profs = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from professor";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professor a = new Professor(
                        rs.getInt("professor_id"),
                        rs.getString("p_first_name"),
                        rs.getString("p_last_name"),
                        rs.getString("email")
                );

                profs.add(a);
            }
            return profs;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // Create
    public Professor add(Professor a) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into professor values (?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getProfessorID());
            ps.setString(2, a.getFirstName());
            ps.setString(3, a.getLastName());
            ps.setString(4, a.getProfEmail());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                a.setProfessorID(rs.getInt("professor_id"));
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Update - this will eventually become a PUT Http Request
    public void update(Professor a) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update professor set p_first_name = ?, p_last_name = ?, email = ? where professor_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setString(3, a.getProfEmail());
            ps.setInt(4, a.getProfessorID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "delete from professor where professor_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
