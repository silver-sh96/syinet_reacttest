package com.esh.react.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import com.esh.react.dto.DeptDTO;
import com.esh.react.dto.PositionDTO;
import com.esh.react.dto.RankDTO;
import com.esh.react.dto.UserDTO;


@Mapper("UserMapper")
public interface UserMapper {
	
	// 사용자 목록 가져오기
	public List<UserDTO> getUserList();
	
	// 부서 조회
	public List<DeptDTO> getDeptList();
	
	// 직책 조회
	public List<PositionDTO> getPositionList();
		
	// 직급 조회
	public List<RankDTO> getRankList();
	
	// 수정대상 정보 가져오기
	public List<UserDTO> getModifyUserById(@Param("userId")String userId);
	
	// 사용자 검색
	public List<UserDTO> getSearchUserList(@Param("searchKey")String searchKey, @Param("searchValue")String searchValue);
	
	// 사용자 등록 처리
	public int userReg(UserDTO userDto);
	
	// 아이디 중복 검사
	public int idDupleCheck(@Param("userId")String userId);
	
	// 사용자 삭제 처리
	public int userDelete(@Param("userId")String userId);
	
	// 사용자 수정 처리
	public int userModify(UserDTO userDto);
}
