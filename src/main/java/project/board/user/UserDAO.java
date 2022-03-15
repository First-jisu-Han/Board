package project.board.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDAO {

    private Connection conn;
    private PreparedStatement pstm;

    public UserDAO(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/BOARD";
            String dbID = "root";
            String dbPassword = "root";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
