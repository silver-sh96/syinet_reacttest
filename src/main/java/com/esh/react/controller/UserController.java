package com.esh.react.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esh.react.dto.DeptDTO;
import com.esh.react.dto.PositionDTO;
import com.esh.react.dto.RankDTO;
import com.esh.react.dto.UserDTO;
import com.esh.react.service.UserService;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 사용자 목록 조회
	@RequestMapping(value = "/userList.do")
	public List<UserDTO> getUserList() throws Exception {
		List<UserDTO> userList = userService.getUserList();
		log.info("Controller - userList   :   {}", userList);
		
		return userList;
	}
	
	// 부서 목록 조회
	@RequestMapping(value = "/deptList.do")
	public List<DeptDTO> getDeptList() throws Exception {
		List<DeptDTO> deptList = userService.getDeptList();
		log.info("Controller - deptList   :   {}", deptList);
		
		return deptList;
	}
	
	// 직급 목록 조회
	@RequestMapping(value = "/rankList.do")
	public List<RankDTO> getRankList() throws Exception {
		List<RankDTO> rankList = userService.getRankList();
		log.info("Controller - rankList   :   {}", rankList);
		
		return rankList;
	}
	
	// 직책 목록 조회
	@RequestMapping(value = "/positionList.do")
	public List<PositionDTO> getPositionList() throws Exception {
		List<PositionDTO> positionList = userService.getPositionList();
		log.info("Controller - positionList   :   {}", positionList);
		
		return positionList;
	}
	
	// 수정 대상정보 가져오기
	@RequestMapping(value = "/userSelectForModify.do")
	public List<UserDTO> getModifyUserById(@RequestParam("userId")String userId) throws Exception {
		List<UserDTO> targetUser = userService.getModifyUserById(userId);
		log.info("Controller - targetUser   :   {}", targetUser);
		
		return targetUser;
	}
	
	// 사용자 검색
	@RequestMapping(value = "/userSearch.do")
	public List<UserDTO> getSearchUserList(@RequestParam(name = "searchKey", required = false, defaultValue = "user_dept") String searchKey
										,  @RequestParam(name = "searchValue", required = false) String searchValue) throws Exception {
		
		if(searchKey.equals("userDept")) {
			searchKey = "user_dept";
		} else if(searchKey.equals("userName")) {
			searchKey = "user_name";
		} else if(searchKey.equals("userRank")) {
			searchKey = "user_rank";
		} else {
			searchKey = "user_position";
		}
		
		log.info("Controller - searchKey   :   {}", searchKey);
		log.info("Controller - searchValue   :   {}", searchValue);
		
		List<UserDTO> searchList = userService.getSearchUserList(searchKey, searchValue);
		log.info("Controller - searchList   :   {}", searchList);
		
		return searchList;
	}
	
	// 사용자 등록 처리
	@RequestMapping(value = "/userReg.do", method = RequestMethod.POST)
	public int userReg(UserDTO userDto) throws Exception {
		System.out.println("controller - 사용자 등록 처리 진행!!");
		log.info("userDto  :  {}", userDto);
		int result = userService.userReg(userDto);
		
		return result;
	}
	
	// 아이디 중복검사
	@RequestMapping(value = "/idDupleCheck.do")
	public int idDupleCheck(@RequestParam("userId")String userId) throws Exception {
		System.out.println("controller - 아이디 중복검사 진행!!");
		log.info("userId  :  {}", userId);
		int result = userService.idDupleCheck(userId);
		log.info("result  :  {}", result);
		
		return result;
	}
	
	// 사용자 삭제 처리
	@RequestMapping(value = "/userDelete.do")
	public int userDelete(@RequestParam("userId")String userId) throws Exception {
		System.out.println("controller - 사용자 삭제 진행!!");
		log.info("userId  :  {}", userId);
		int result = userService.userDelete(userId);
		log.info("result  :  {}", result);
		
		return result;
	}
	
	// 사용자 수정 처리
	@RequestMapping(value = "/userModify.do", method = RequestMethod.POST)
	public int userModify(UserDTO userDto) throws Exception {
		System.out.println("controller - 사용자 수정 처리 진행!!");
		log.info("userDto  :  {}", userDto);
		int result = userService.userModify(userDto);
		
		return result;
	}

}
