package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	public UserBean getUserId(String userId) throws SQLException, ClassNotFoundException {
		UserBean user = new UserBean();
		String sql = """
				SELECT
					user_id,
					password
				FROM m_user
				WHERE user_id = ?
				""";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, userId);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String password = res.getString("password");
				user.setUserId(userId);
				user.setPassword(password);
			}
		}
		return user;
	}
}
