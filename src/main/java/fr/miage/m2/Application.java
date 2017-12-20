package fr.miage.m2;

import fr.miage.m2.rjava.RJavaImpl;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws RserveException, REXPMismatchException, IOException, SQLException {

        SpringApplication.run(Application.class, args);

        // Launch k-means algorithm when app has been run
        //EntityManager.alter();

        RJavaImpl.lancerKmeans();

    }

}
