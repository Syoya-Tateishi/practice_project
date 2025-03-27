package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;

public class CustomerDAO {
	//引数(従業員コード)を使って該当の従業員情報を取得する
		public CustomerBean getCustomer(int customerId) throws SQLException, ClassNotFoundException {

			String sql = """
					SELECT
						customer_id,
						customer_name,
						customer_name_kana,
						postal_code,
						address,
						area_code,
						contact_person_name,
						contact_person_name_kana,
						contact_person_tell,
						user_id
					from m_customer
					WHERE customer_id = ?
					""";
			CustomerBean customer = new CustomerBean();
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setInt(1, customerId);
				ResultSet res = pstmt.executeQuery();
				while (res.next()) {
					customer.setCustomerId(customerId);
					customer.setCustomerName(res.getString("customer_name"));
					customer.setCustomerNameKana(res.getString("customer_name_kana"));
					customer.setPostalCode(res.getString("postal_code"));
					customer.setAddress(res.getString("address"));
					customer.setAreaCode(res.getString("area_code"));
					customer.setContactPersonName(res.getString("contact_person_name"));
					customer.setContactPersonNameKana(res.getString("contact_person_name_kana"));
					customer.setContactPersonTell(res.getString("contact_person_tell"));
					customer.setUserId(res.getString("user_id"));
				}
			}
			return customer;
		}

		//全ての従業員情報を取得する
		public List<CustomerBean> getAllCustomer() throws SQLException, ClassNotFoundException {
			String sql = """
					SELECT
						customer_id,
						customer_name,
						customer_name_kana,
						postal_code,
						address,
						area_code,
						contact_person_name,
						contact_person_name_kana,
						contact_person_tell,
						user_id
					from m_customer;
					""";
			List<CustomerBean> customerList = new ArrayList<CustomerBean>();
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet res = pstmt.executeQuery()) {
				while (res.next()) {
					CustomerBean customer = new CustomerBean();
					customer.setCustomerId(res.getInt("customer_id"));
					customer.setCustomerName(res.getString("customer_name"));
					customer.setCustomerNameKana(res.getString("customer_name_kana"));
					customer.setPostalCode(res.getString("postal_code"));
					customer.setAddress(res.getString("address"));
					customer.setAreaCode(res.getString("area_code"));
					customer.setContactPersonName(res.getString("contact_person_name"));
					customer.setContactPersonNameKana(res.getString("contact_person_name_kana"));
					customer.setContactPersonTell(res.getString("contact_person_tell"));
					customer.setUserId(res.getString("user_id"));
					customerList.add(customer);
				}
			}
			return customerList;
		}

		//新しい従業員情報を挿入する
		public int addCustomer(CustomerBean customer) throws SQLException, ClassNotFoundException {
			String sql = """
					INSERT INTO m_customer(
						customer_name,
						customer_name_kana,
						postal_code,
						address,
						area_code,
						contact_person_name,
						contact_person_name_kana,
						contact_person_tell,
						user_id
						)VALUES(?,?,?,?,?,?,?,?,?)
					""";
			int rowsAffected = 0;
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customer.getCustomerName());
				pstmt.setString(2, customer.getCustomerNameKana());
				pstmt.setString(3, customer.getPostalCode());
				pstmt.setString(4, customer.getAddress());
				pstmt.setString(5, customer.getAreaCode());
				pstmt.setString(6, customer.getContactPersonName());
				pstmt.setString(7, customer.getContactPersonNameKana());
				pstmt.setString(8, customer.getContactPersonTell());
				pstmt.setString(9, customer.getUserId());

				rowsAffected = pstmt.executeUpdate();
			}
			return rowsAffected;
		}

		//従業員情報を更新する
		public int updateCustomer(CustomerBean customer) throws SQLException, ClassNotFoundException {
			String sql = """
					UPDATE m_employee SET
						customer_name = ?,
						customer_name_kana = ?,
						postal_code = ?,
						address = ?,
						area_code = ?,
						contact_person_name = ?,
						contact_person_name_kana = ?,
						contact_person_tell = ?,
						user_id = ?
					WHERE customer_id = ?
					""";
			int rowsAffected = 0;
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customer.getCustomerName());
				pstmt.setString(2, customer.getCustomerNameKana());
				pstmt.setString(3, customer.getPostalCode());
				pstmt.setString(4, customer.getAddress());
				pstmt.setString(5, customer.getAreaCode());
				pstmt.setString(6, customer.getContactPersonName());
				pstmt.setString(7, customer.getContactPersonNameKana());
				pstmt.setString(8, customer.getContactPersonTell());
				pstmt.setString(9, customer.getUserId());
				pstmt.setInt(10, customer.getCustomerId());

				rowsAffected = pstmt.executeUpdate();
			}
			return rowsAffected;
		}

		//引数(従業員コード)を使って該当の従業員情報を削除する
		public int deleteCustomer(String customerId) throws SQLException, ClassNotFoundException {
			String sql = "DELETE FROM m_customer WHERE customer_id = ?";
			int rowsAffected = 0;
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customerId);

				rowsAffected = pstmt.executeUpdate();
			}
			return rowsAffected;
		}
}
