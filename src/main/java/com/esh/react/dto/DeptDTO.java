package com.esh.react.dto;


public class DeptDTO {
	
	private String deptNum;
	private String deptName;
	
	public String getDeptNum() {
		return deptNum;
	}
	public String getDeptName() {
		return deptName;
	}
	
	@Override
	public String toString() {
		return "DeptDTO [deptNum=" + deptNum + ", deptName=" + deptName + "]";
	}
}
