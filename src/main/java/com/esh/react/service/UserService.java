package com.esh.react.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.esh.react.dto.DeptDTO;
import com.esh.react.dto.PositionDTO;
import com.esh.react.dto.RankDTO;
import com.esh.react.dto.UserDTO;
import com.esh.react.mapper.UserMapper;


@Service("UserService")
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	// 사용자 목록 조회
	public List<UserDTO> getUserList(){
		List<UserDTO> userList = userMapper.getUserList();
		log.info("Service - userList   :   {}", userList);
		
		return userList;
	}
	
	// 부서 조회
	public List<DeptDTO> getDeptList(){
		List<DeptDTO> deptList = userMapper.getDeptList();
		log.info("deptList  :  {}", deptList);
		return deptList;
	}
	
	// 직책 조회
	public List<PositionDTO> getPositionList(){
		List<PositionDTO> positionList = userMapper.getPositionList();
		log.info("positionList  :  {}", positionList);
		return positionList;
	}
			
	// 직급 조회
	public List<RankDTO> getRankList(){
		List<RankDTO> rankList = userMapper.getRankList();
		log.info("rankList  :  {}", rankList);
		return rankList;
	}
	
	// 수정대상 정보 가져오기
	public List<UserDTO> getModifyUserById(String userId){
		List<UserDTO> targetUser = userMapper.getModifyUserById(userId);
		log.info("Service - targetUser   :   {}", targetUser);
		
		return targetUser;
	}
	
	// 사용자 검색
	public List<UserDTO> getSearchUserList(String searchKey, String searchValue){
		List<UserDTO> searchList = userMapper.getSearchUserList(searchKey, searchValue);
		log.info("Service - searchList   :   {}", searchList);
		
		return searchList;
	}
	
	// 사용자 등록 처리
	public int userReg(UserDTO userDto) {
		System.out.println("service - 사용자 등록 처리 진행!!");
		int result = userMapper.userReg(userDto);
		
		return result;
	}
	
	// 아이디 중복 검사
	public int idDupleCheck(String userId) {
		System.out.println("service - 아이디 중복검사 진행!!");
		int result = userMapper.idDupleCheck(userId);
		
		return result;
	}
	
	// 사용자 삭제 처리
	public int userDelete(String userId) {
		System.out.println("service - 사용자 삭제 진행!!");
		int result = userMapper.userDelete(userId);
		
		return result;
	}
	
	// 사용자 등록 처리
	public int userModify(UserDTO userDto) {
		System.out.println("service - 사용자 수정 처리 진행!!");
		int result = userMapper.userModify(userDto);
		
		return result;
	}

}
