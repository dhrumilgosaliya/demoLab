package com.project.accomatch.Repository;

import com.project.accomatch.Model.LeaseHolderApplicantModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ApplyonPostTableOperations {
    @Value("${username.db.accomatch}")
    private String username;

    @Value("${password.db.accomatch}")
    private String password;

    @Value("${Connection.db.accomatch}")
    private String JDBC;
    public void applyOnPost(LeaseHolderApplicantModel leaseHolderApplicantModel){
        try{
            Connection connect;
            Statement statement;
            // Connect to the database.
            //getCredentials();
            connect = DriverManager.getConnection(JDBC, username, password);
            // Create a statement object.
            statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //   statement.execute("use accomatch;");
            String sql = "INSERT INTO leaseholder_applicant (application_id,user_id,status,room_id)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1,leaseHolderApplicantModel.getApplication_id());
            stmt.setInt(2,leaseHolderApplicantModel.getUser_id());
            stmt.setString(3,leaseHolderApplicantModel.getStatus());
            stmt.setInt(4,leaseHolderApplicantModel.getRoom_id());
            stmt.executeUpdate();
            stmt.close();
            connect.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
