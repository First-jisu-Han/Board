package project.board.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public UserDAO(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/BOARD";
            String dbID = "root";
            String dbPassword = "han@1782";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public int login(String userID,String userPassword){
        String SQL= "Select userPassword From User Where userID= ?" ;
        try{
            pstmt= conn.prepareStatement(SQL);
            pstmt.setString(1,userID); // 물음표에 해당하는 부분에 inject
            rs=pstmt.executeQuery();
            // rs이 작동된다면 ( 아이디가 존재한다면 )
            if(rs.next()){
                if(rs.getString(1).equals(userPassword)){
                    return 1;  // 로그인이 성공한 것
                }
                else return 0; // 비밀번호 오류
            }
            return -1;  // 아이디가 없는 것
        } catch(Exception e){
            e.printStackTrace();
        }
        return -2; // DB 오류
    }
}
