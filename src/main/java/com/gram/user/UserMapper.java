package com.gram.user;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

	//유저 정보
	public ArrayList<UserVO> loginUser(String userId);
	
	//유저 저장(회원가입)
	public int memberSave(UserVO userVO);

	public int getUser(String userId);
	
	//유저 권한 등록
	public void authSave(UserVO userVO);

	//유저 권한 저장
//	int userRoleSave(@Param("userNo") int userNo,@Param("roleNo") int roleNo);

	//유저 FK번호 알아내기
//	int findUserNo(@Param("id") String id);

	//권한 FK번호 알아내기
//	int findRoleNo(@Param("roleName") String roleName);
	
	
}
