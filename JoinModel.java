package DiaryProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import quiz.DbConn;
import quiz0908.HelloDTO;

public class JoinModel {
	
	DbConn db = new DbConn();
	
	////////////////////////////////////////////
	//ȸ�������� ���, ���� Join ���̺��� ����
	//�Է��� DTO�� ���ڰ����� ���޹޴´�
	public void insertJoin(JoinDTO dto) {
		
		//DCL�� �⺻ ��ɵ��� �־���� ���̱⿡ ������ �ʼ�
		Connection conn = db.getLoclaConnection();
		PreparedStatement pstmt = null;
		
		//sql
		String sql = "insert into join values(?,?,?,?,?)";
		
		
		//�ļ�
		try {
			pstmt = conn.prepareStatement(sql);
			
			//DTO ��ü�� �̹� �޾����Ƿ� ���� ������ �ʿ����
			
			//�� ���
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone());
			
			//������Ʈ
			pstmt.execute();
			
		} catch (SQLException e) {
			
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	

	/////////////////////////////////////////////	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}