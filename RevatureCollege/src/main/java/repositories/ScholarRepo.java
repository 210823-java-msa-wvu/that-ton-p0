package repositories;

import models.Scholarship;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScholarRepo implements CrudRepository<Scholarship>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public Scholarship add(Scholarship scholarship) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into scholarship values (?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, scholarship.getScholarshipID());
            ps.setInt(2, scholarship.getStudentID());
            ps.setBoolean(3, scholarship.getApply());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                scholarship.setStudentID(rs.getInt("student_id"));
                return scholarship;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Scholarship getById(Integer id) {

        try (Connection conn = cu.getConnection()) {
            String sql = "select * from scholarship where scholarship_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks
            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Scholarship a = new Scholarship();
                a.setScholarshipID(rs.getInt("scholarship_id"));
                a.setStudentID(rs.getInt("student_id"));
                a.setApply(rs.getBoolean("application"));
                a.setAmount(rs.getDouble("scholarship_amount"));
                a.setDecision(rs.getString("decision"));
                return a;
            }
            else
                System.out.println("No record found with id " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Scholarship> getAll() {

        List<Scholarship> scholarships = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from scholarship order by scholarship_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Scholarship a = new Scholarship(
                        rs.getInt("scholarship_id"),
                        rs.getInt("student_id"),
                        rs.getBoolean("application"),
                        rs.getDouble("scholarship_amount"),
                        rs.getString("decision")
                );

                scholarships.add(a);
            }
            return scholarships;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Scholarship scholarship) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update scholarship set application = ? where scholarship_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, scholarship.getApply());
            ps.setInt(2, scholarship.getScholarshipID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void profUpdate(Scholarship scholarship) {

        try (Connection conn = cu.getConnection()) {

            String sql = "update scholarship set scholarship_amount = ?, decision = ? where scholarship_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, scholarship.getAmount());
            ps.setString(2, scholarship.getDecision());
            ps.setInt(3, scholarship.getScholarshipID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {

    }
}