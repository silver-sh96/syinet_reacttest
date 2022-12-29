package com.esh.react.dto;

public class PositionDTO {
	
	private String positionNum;
	private String positionName;
	
	public String getPositionNum() {
		return positionNum;
	}
	public String getPositionName() {
		return positionName;
	}
	
	@Override
	public String toString() {
		return "PositionDTO [positionNum=" + positionNum + ", positionName=" + positionName + "]";
	}
	
}
