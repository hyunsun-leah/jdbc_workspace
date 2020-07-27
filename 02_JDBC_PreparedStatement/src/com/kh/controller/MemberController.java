package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {
	
	/**
	 * 사용자가 회원 가입 요청시 실행되는 메소드
	 * @param m		--> 회원가입시 입력한 회원의 정보들이 다 담겨있는 객체
	 */
	public void insertMember(Member m) {
		
		int result = new MemberDao().insertMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 가입 되었습니다.");
		}else {
			new MemberMenu().displayFail("회원 가입에 실패했습니다.");
		}
		
	}
	
	public void selectList() {
		
		ArrayList<Member> list = new MemberDao().selectList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("전체 회원에 대한 조회결과 없습니다.");
		}else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
	public void selectByUserId(String userId) {
		
		Member m = new MemberDao().selectByUserId(userId);
		
		if(m == null) {
			new MemberMenu().displayNoData(userId + "에 대한 검색 결과 없습니다.");
		}else {
			new MemberMenu().displayMember(m);
		}
	}
	
	public void selectByUserName(String keyword) {
		ArrayList<Member> list = new MemberDao().selectByUserName(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData(keyword + "에 대한 검색 결과 없습니다.");
		}else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
	public void updateMember(Member m) {
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보가 변경되었습니다.");
		}else {
			new MemberMenu().displayFail("회원 정보 변경에 실패했습니다.");
		}
	}
	
	public void deleteMember(String userId) {
		int result = new MemberDao().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원탈퇴 되었습니다.");
		}else{
			new MemberMenu().displayFail("회원 탈퇴에 실패했습니다.");
		}
	}
	
	public void loginMember(String userId, String userPwd) {
		Member m = new MemberDao().loginMember(userId, userPwd);
		
		if(m == null) {
			new MemberMenu().displayNoData("로그인 실패");
		}else {
			new MemberMenu().displayMember(m);
		}
	}

}
