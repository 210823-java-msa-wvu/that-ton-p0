package repositories;

import models.ProfUser;
import utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProfUserRepo implements CrudRepository<ProfUser>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public ProfUser add(ProfUser a) {
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into profuser values (?, ?, ?) returning *";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getProfessorID());
            ps.setString(2, a.getProfEmail());
            ps.setString(3, a.getProfPw());

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


    public ProfUser getById(Integer id) {

        return null;
    }


    public ProfUser getByUsername(String username) {

        try (Connection conn = cu.getConnection()) {

            String sql = "select * from profuser where email = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ProfUser u = new ProfUser(
                        rs.getInt("professor_id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ProfUser> getAll() {
        return null;
    }

    @Override
    public void update(ProfUser profUser) {

    }

    @Override
    public void delete(Integer id) {

    }
}
