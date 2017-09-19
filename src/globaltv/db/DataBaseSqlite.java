/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pichau
 */
public class DataBaseSqlite {
    public static Connection connect() {
        Connection c = null;
        File resource = new File("resource");
        if(!resource.isDirectory()){
            System.out.println("Creating dir");
            resource.mkdir();
        }
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:resource/globaltv.db");
            return c;
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return null;
    }
}
