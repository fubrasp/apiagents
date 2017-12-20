package fr.miage.m2.connection;

import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

@Service
public class AgentDaoImpl implements AgentDao {

    @Override
    public void setAvailability(int idAgent,int possibleEvents) {

        try {
            PreparedStatement pstmt = PostgresConnection.getDbCon().conn.prepareStatement(
                    "UPDATE agents_events SET capacite_events=? WHERE id_resource=?;"
            );

            pstmt.setInt(1, idAgent);
            pstmt.setDouble(2, possibleEvents);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
