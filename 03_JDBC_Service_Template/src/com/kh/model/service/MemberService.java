package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

// Service : DB와 연결시키는 Connection 객체 생성 후 
//			 Dao 호출 (이때, 생성된 Connection객체와 Controller로 부터 전달된 값 같이 넘겨줄꺼임)
//			  돌아오는 반환값 받아서 만약에 트랜잭션 처리가 필요할 경우 트랜잭션 처리도 여기서 진행
public class MemberService {
	
	public int insertMember(Member m) {
		
		/*
		// 처리 결과를 받을 변수
		int result = 0;
		
		// DB의 연결정보를 담는 객체
		Connection conn = null;
		
		try {
			// jdbc driver 등록처리
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 오타있다거나, ojdbc6.jar 파일 추가 안되어있을 경우
			// Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			result = new MemberDao().insertMember(conn, m);
			
			// 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		// 트랜잭션
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	public ArrayList<Member> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
		
	}
	
	
	public Member selectByUserId(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectByUserId(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectByUserName(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	
	
	
	
	

}
