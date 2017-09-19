/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globaltv.utils;

import globaltv.models.ChannelModel;
import java.util.Comparator;

/**
 *
 * @author Pichau
 */
public class SortChannelsByName implements Comparator<ChannelModel>{
    
    @Override
    public int compare(ChannelModel o1, ChannelModel o2) {
        if(o1.getName().compareTo(o2.getName()) > 0){
            return 1;
        }
        return 0;
    }
    
}
