/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.models;

import java.io.File;

/**
 *
 * @author Pichau
 */
public class ChannelModel {
    private String addrChannel;
    private String name;
    private byte[] icon;
    private String code;
    private int id;

    @Override
    public String toString() {
        return "ChannelModel{" + "addrChannel=" + addrChannel + ", name=" + name + ", icon=" + icon + ", code=" + code + ", id=" + id + '}';
    }
    
    

    public ChannelModel(int id, String addrChannel, String name, String code, byte[] icon) {
        this.addrChannel = addrChannel;
        this.name = name;
        this.icon = icon;
        this.code = code;
        this.id = id;
    }
    public ChannelModel(int id, String addrChannel, String name, String code) {
        this.addrChannel = addrChannel;
        this.name = name;
        this.code = code;
        this.id = id;
    }
    
    public ChannelModel(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getAddrChannel() {
        return addrChannel;
    }

    public void setAddrChannel(String addrChannel) {
        this.addrChannel = addrChannel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
}
