package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.AreaBean;

public class AreaDAO {
	public List<AreaBean> getAllArea() throws SQLException, ClassNotFoundException {
		List<AreaBean> areaList = new ArrayList<AreaBean>();
		String sql = """
					SELECT
						area_code,
						area_name
					FROM m_area
					ORDER BY area_code ASC
				""";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet res = pstmt.executeQuery()){
			while(res.next()) {
				AreaBean area = new AreaBean();
				area.setAreaCode(res.getString("area_code"));
				area.setAreaName(res.getString("area_name"));
				
				areaList.add(area);
			}
		}

		return areaList;
		
	}
}
