package com.gram.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@Component
@ToString
public class UserVO {

//	`userIdx`       VARCHAR(45)    NOT NULL    COMMENT '유저고유번호', 
//    `userId`        VARCHAR(45)    NOT NULL    COMMENT '유저아이디', 
//    `userPassword`  VARCHAR(45)    NOT NULL    COMMENT '유저비밀번호', 
//    `userNick`      VARCHAR(45)    NOT NULL    COMMENT '유저닉네임', 
//    `userEmail`     VARCHAR(45)    NOT NULL    COMMENT '유저이메일', 
//    `userBirth`     VARCHAR(45)    NULL        COMMENT '유저생년월일', 
//    `userSex`       CHAR(1)        NULL        COMMENT '유저성별', 
//    `userIcon`      VARCHAR(45)    NULL        COMMENT '유저아이콘', 
//    `userUse`       CHAR(1)        NULL        COMMENT '유저사용여부' default 'Y', 
//    `userDate`      DATETIME       NULL        COMMENT '가입일', 
//    `userUpdate`    DATETIME       NULL        COMMENT '수정일', 
//    `userAuth`      INT            NULL        COMMENT '유저 권한',
	
	private String userIdx;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 20,  message="4자리 이상 가능합니다.")
	private String userId;
	
	private String userPassword;
	private String userNick;
	private String userEmail;
	private String userBirth;
	private String userSex;
	private String userIcon;
	private String userUse;
	private String userDate;
	private String userUpdate;
	private int userAuth;
	private String Auth;
	private String AuthUser;
	
	
	
}
