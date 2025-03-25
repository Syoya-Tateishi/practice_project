package model.entity;

import java.io.Serializable;

public class AreaBean implements Serializable{
	/*
	 * 地区コード
	 */
	private String areaCode;
	/*
	 * 地区名
	 */
	private String areaName;
	
	public AreaBean() {
	}
	
	/*
	 * フィールド 地区コードに値を取得
	 * return 地区コード
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/*
	 * フィールド 地区コードに値を設定
	 * return areaCode 地区コード
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/*
	 * フィールド 地区名に値を取得
	 * return 地区名
	 */
	public String getAreaName() {
		return areaName;
	}

	/*
	 * フィールド 地区名に値を設定
	 * return areaName 地区名
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
