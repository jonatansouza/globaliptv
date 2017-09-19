/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.models;

/**
 *
 * @author Pichau
 */
public class UserModel {
    private String name;
    private String password;
    private String username;

    @Override
    public String toString() {
        return "UserModel{" + "name=" + name + ", password=" + password + ", username=" + username + '}';
    }
    
    
    
    public UserModel( String name, String passwd, String username) {
        this.name = name;
        this.password = passwd;
        this.username = username;
       
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
