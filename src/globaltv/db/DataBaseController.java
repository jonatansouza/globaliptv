/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.db;

import globaltv.models.ChannelModel;
import globaltv.models.UserModel;
import globaltv.utils.FilesHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pichau
 */
public class DataBaseController {
    private Connection conn;
    
    public DataBaseController(){
        conn = new DataBaseSqlite().connect();
        createDB();
    }

    private void createDB() {
        System.out.println("Creating DBs...");
        
            
        try {
            Statement stmt;
            stmt = conn.createStatement();
        
                String sql = "CREATE TABLE users " +
                    " (username TEXT PRIMARY KEY, " +
                    " name TEXT NOT NULL, " +
                    " password TEXT NOT NULL) " ;
                    
            stmt.executeQuery(sql);
            stmt.close();
        
        } catch (SQLException ex) {
            System.out.println("DB User Already exists!");
        }
        
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE channels " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    " addrChannel TEXT NOT NULL, " +
                    " name TEXT NOT NULL, " +
                    " code TEXT, " +
                    " icon BLOB NOT NULL)" ;
            stmt.executeQuery(sql);
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("DB Channels Already exists!");
        }
    }
    
     public boolean insertUser(UserModel user){
        String sql = "INSERT INTO users(name, username, password) VALUES(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
     public boolean insertChannel(ChannelModel channel){
        String sql = "INSERT INTO channels(addrChannel, name, icon, code) VALUES(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, channel.getAddrChannel());
            pstmt.setString(2, channel.getName());
            try {
                pstmt.setBytes(3, new FilesHandler().readFile(channel.getIcon()));
            } catch (SecurityException ex) {
                Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            pstmt.setString(4, channel.getCode());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public List<UserModel> selectAllUsers(){
        List users = new ArrayList<UserModel>();
        String sql = "SELECT name, username, password FROM users";
        
        
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                users.add(new UserModel(
                        rs.getString("name"),
                        rs.getString("password"),
                    rs.getString("username")));
            }
            stmt.close();
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    /**
     * retorna o objeto persistido atraves do id
     * @param id
     * @return 
     */
    public UserModel selectUserByUsername(String username){
        UserModel user = null;
        String sql = "SELECT name, username, password FROM users WHERE username=\""+username+"\"";
       
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                user = new UserModel(
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("username"));
            }
            stmt.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<ChannelModel> selectAllChannels(){
        List channels = new ArrayList<ChannelModel>();
        String sql = "SELECT id, addrChannel, name, code, icon FROM channels";
        
        
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            ChannelModel channel = null;
            while (rs.next()) {
                channel = new ChannelModel(
                        rs.getInt("id"),
                        rs.getString("addrChannel"),
                        rs.getString("name"),
                        rs.getString("code"));
                
                File file = new File(channel.getName());
                FileOutputStream fos;
               try {
                   fos = new FileOutputStream(file);
                   fos.write(rs.getBytes("icon"));
                   fos.close();
                   
                channel.setIcon(file);
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
               }
                channels.add(channel);
            }
            stmt.close();
            return channels;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    /**
     * retorna o objeto persistido atraves do id
     * @param id
     * @return 
     */
    public ChannelModel selectChannelById(int id){
       ChannelModel channel = null;
        String sql = "SELECT id, addrChannel, name, code, icon FROM channels WHERE id="+id;
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            while (rs.next()) {
                channel = new ChannelModel(
                        rs.getInt("id"),
                        rs.getString("addrChannel"),
                        rs.getString("name"),
                        rs.getString("code"));
                
               File file = new File(channel.getName());
                FileOutputStream fos;
               try {
                   fos = new FileOutputStream(file);
                   fos.write(rs.getBytes("icon"));
                   fos.close();
                   
                channel.setIcon(file);
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
               }
            stmt.close();
            return channel;
            }} catch (SQLException ex) {
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean deleteUser(String username) {
        String sql = "DELETE FROM users WHERE username = ?";
        
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean deleteChannel(int id) {
        String sql = "DELETE FROM channels WHERE id = ?";
        
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
        
    
    
    
     
}
