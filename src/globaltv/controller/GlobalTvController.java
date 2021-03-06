/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.controller;

import globaltv.db.DataBaseController;
import globaltv.models.ChannelModel;
import globaltv.models.UserModel;
import globaltv.utils.SortChannelsByName;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Pichau
 */
public class GlobalTvController {
    private DataBaseController dataBaseController;
    private UserModel user;
    private ChannelModel channel;
    
    public GlobalTvController() {
        dataBaseController = new DataBaseController();
        this.channel = new ChannelModel();
        user = null;
    }

    public ChannelModel getChannel() {
        return channel;
    }

    public void setChannel(ChannelModel channel) {
        this.channel = channel;
    }

    
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
    
    
   
    /**
     * lista todos
     * @return lista com todos EasyOrganizerModel
     */
    public List<UserModel> listAllUsers(){
        ArrayList<UserModel> users = (ArrayList<UserModel>) dataBaseController.selectAllUsers();
        return users;
    }
    /**
     * procura pelo id
     * @param id
     * @return um EasyOrganizerModel correspondente ao id passado
     */
    public UserModel getUserByUsername(String username){
        return dataBaseController.selectUserByUsername(username);
    }
   
    public boolean createUser(UserModel user){
        return dataBaseController.insertUser(user);
    }
    /**
     * responsavel por deletar
     * @param id
     * @return
     */
    public boolean deleteUserModel(String username){
        return dataBaseController.deleteUser(username);
    }
   
    public List<ChannelModel> listAllChannels(){
        return dataBaseController.selectAllChannels();
    }
    
    public ChannelModel getChannelById(int id){
        return dataBaseController.selectChannelById(id);
    }
   
    public boolean createChannel(ChannelModel channel){
        return dataBaseController.insertChannel(channel);
    }
    /**
     * responsavel por deletar
     * @param id
     * @return
     */
    public boolean deleteChannel(int id){
        return dataBaseController.deleteChannel(id);
    }
    
    
    
    public List<ChannelModel> listByName(String name){
        List<ChannelModel> channels = new ArrayList<>();
        for(ChannelModel channel : dataBaseController.selectAllChannels()){
            if(channel.getName().toLowerCase().contains(name.toLowerCase())){
                channels.add(channel);
            }
        }
        Collections.sort(channels, new SortChannelsByName());
        
        return channels;
    }

    private void initFileSystem(URI uri) 
{
    try
    {
       FileSystems.getFileSystem(uri);
    }
    catch( FileSystemNotFoundException e )
    {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        try {
            FileSystems.newFileSystem(uri, env);
        } catch (IOException ex) {
            Logger.getLogger(GlobalTvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    public void initialize() {
        if(dataBaseController.selectAllUsers().size() == 0){
            UserModel u = new UserModel("GlobalTV", "admin", "admin");
            System.out.println("initializing first user "+ u);
            dataBaseController.insertUser(u);
        }
            
        if(dataBaseController.selectAllChannels().size() == 0){
            System.out.println("initializing channels");
            
            
            try {
                dataBaseController.insertChannel(new ChannelModel(0, "http://www.sbt.com.br/aovivo/", "SBT", "",IOUtils.toByteArray(ClassLoader.getSystemResourceAsStream("images/channels/sbt.png"))));
            } catch (IOException ex) {
                Logger.getLogger(GlobalTvController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dataBaseController.insertChannel(new ChannelModel(0, "https://globoplay.globo.com/agora-na-globo/", "Globo", "", IOUtils.toByteArray(ClassLoader.getSystemResourceAsStream("images/channels/globo.png"))));
            } catch (IOException ex) {
                Logger.getLogger(GlobalTvController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                dataBaseController.insertChannel(new ChannelModel(0, "http://violence.com", "Violence TV", "1234", IOUtils.toByteArray(ClassLoader.getSystemResourceAsStream("images/channels/fake.png"))));
          } catch (IOException ex) {
                Logger.getLogger(GlobalTvController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public boolean editChannel(ChannelModel channel) {
        return dataBaseController.updateChannel(channel);
    }
    
}
