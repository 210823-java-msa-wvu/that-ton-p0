package repositories;

import models.Professor;
import models.Schedule;
import models.Student;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepo implements CrudRepository<Schedule>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public Schedule add(Schedule schedule) {
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into schedule values (?, ?, ?, ?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, schedule.getStudentID());
            ps.setString(2, schedule.getMonday());
            ps.setString(2, schedule.getTuesday());
            ps.setString(2, schedule.getWednesday());
            ps.setString(2, schedule.getThursday());
            ps.setString(2, schedule.getFriday());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                schedule.setStudentID(rs.getInt("student_id"));
                return schedule;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Schedule getById(Integer id) {
        try (Connection conn = cu.getConnection()) {
            String sql = "select * from schedule where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql); // Setting up our SQL statement in this way helps prevent SQL Injection Attacks
            ps.setInt(1, id); // parameter Indexes start from 1 (NOT 0)

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Schedule a = new Schedule();
                a.setStudentID(rs.getInt("student_id"));
                a.setMonday(rs.getString("mon"));
                a.setTuesday(rs.getString("tue"));
                a.setWednesday(rs.getString("wed"));
                a.setThursday(rs.getString("thu"));
                a.setFriday(rs.getString("fri"));
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Schedule> getAll() {

        List<Schedule> schedules = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            // we will need to use a join on schedule and student to get all data needed
            String sql = "select c.student_id, t.first_name, t.last_name, c.mon, c.tue, c.wed, c.thu, c.fri \n" +
                    "from schedule c left join student t on c.student_id = t.student_id";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // For each record we need to create an Author Object AND a Book Object
                Student t = new Student();
                t.setStudentID(rs.getInt("student_id"));
                t.setFirstName(rs.getString("first_name"));
                t.setLastName(rs.getString("last_name"));

                Schedule c = new Schedule();
                c.setStudentID(rs.getInt("student_id"));
                c.setMonday(rs.getString("mon"));
                c.setTuesday(rs.getString("tue"));
                c.setWednesday(rs.getString("wed"));
                c.setThursday(rs.getString("thu"));
                c.setFriday(rs.getString("fri"));

                schedules.add(c);
            }

            return schedules;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void update(Schedule schedule) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update schedule set mon = ?, tue = ?, wed = ?, thu = ?, fri = ? where student_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, schedule.getMonday());
            ps.setString(2, schedule.getTuesday());
            ps.setString(3, schedule.getWednesday());
            ps.setString(4, schedule.getThursday());
            ps.setString(5, schedule.getFriday());
            ps.setInt(6, schedule.getStudentID());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer id) {
        try (Connection conn = cu.getConnection()) {

            String sql = "delete from schedule where student_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
