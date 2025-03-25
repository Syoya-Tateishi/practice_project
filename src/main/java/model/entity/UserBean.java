package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable{
	/*
	 * 
	 */
	private String userId;
	/*
	 * 
	 */
	private String password;
	/*
	 * 
	 */
	private String userName;
	
	public UserBean() {
	}
	
	/*
	 * フィールド ユーザーIDに値を取得
	 * return ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/*
	 * フィールド ユーザーIDに値を設定
	 * return userId ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * フィールド パスワードに値を取得
	 * return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * フィールド パスワードに値を設定
	 * return password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * フィールド ユーザー名に値を取得
	 * return ユーザー名
	 */
	public String getUserName() {
		return userName;
	}
	
	/*
	 * フィールド パスワードに値を設定
	 * return　userName ユーザー名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
