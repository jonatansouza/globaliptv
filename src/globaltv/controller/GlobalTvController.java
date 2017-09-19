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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pichau
 */
public class GlobalTvController {
    private DataBaseController dataBaseController;
    private UserModel user;
    
    public GlobalTvController() {
        dataBaseController = new DataBaseController();
        user = null;
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

    public void initialize() {
        if(dataBaseController.selectAllUsers().size() == 0){
            UserModel u = new UserModel("GlobalTV", "admin", "admin");
            System.out.println("initializing first user "+ u);
            dataBaseController.insertUser(u);
        }
            
        if(dataBaseController.selectAllChannels().size() == 0){
            System.out.println("initializing channels");
            dataBaseController.insertChannel(new ChannelModel(0, "http://www.sbt.com.br/aovivo/", "SBT", "", new File(getClass().getResource("../ui/images/channels/sbt.png").getPath())));
            dataBaseController.insertChannel(new ChannelModel(0, "https://globoplay.globo.com/agora-na-globo/", "Globo", "", new File(getClass().getResource("../ui/images/channels/globo.png").getPath())));
            dataBaseController.insertChannel(new ChannelModel(0, "http://violence.com", "Violence TV", "1234", new File(getClass().getResource("../ui/images/channels/fake.png").getPath())));  
        }
    }
    
}
