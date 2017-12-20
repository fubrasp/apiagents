package fr.miage.m2.connection;

import fr.miage.m2.metier.Agent;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

@Service
public class AgentDaoImpl implements AgentDao {
    @Override
    public void setAvailability(int possibleEvents) {

        try {

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
