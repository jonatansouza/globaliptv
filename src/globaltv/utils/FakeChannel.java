/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.utils;

import globaltv.models.ChannelModel;
import java.io.File;

/**
 *
 * @author Pichau
 */
public class FakeChannel {
    public FakeChannel() {
        
    }
    
    public ChannelModel getChannel(){
        return new ChannelModel(0, "Nenhum canal Cadastrado!", "Global IP TV", "");
    }
    
}
