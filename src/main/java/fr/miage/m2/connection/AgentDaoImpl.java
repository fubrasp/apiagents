package fr.miage.m2.connection;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class AgentDaoImpl implements AgentDao {

    @Override
    public void setAvailability(Integer idAgent,int possibleEvents) {

        try {
            PreparedStatement pstmt = PostgresConnection.getDbCon().conn.prepareStatement(
                    "UPDATE agents_events SET capacite_events=? WHERE id_resource=?;"
            );

            pstmt.setInt(1, possibleEvents);
            pstmt.setString(2, idAgent.toString());

            //pstmt.executeUpdate();
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getAvailability(Integer idAgent) {
        int availability =0;
        try {
            PreparedStatement pstmt = PostgresConnection.getDbCon().conn.prepareStatement(
                    "SELECT capacite_events FROM agents_events WHERE id_resource=?;"
            );
            pstmt.setString(1, idAgent.toString());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
               availability = rs.getInt("capacite_events");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return availability;
    }

}
