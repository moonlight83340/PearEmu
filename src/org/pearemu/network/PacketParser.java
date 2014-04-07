/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pearemu.network;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author p13006381
 */
public class PacketParser {
    public Map<String, Method> getPackets(){
        Map<String, Method> packets = new HashMap<>();
        for(Method method : getClass().getDeclaredMethods()){
            Packet annotation = method.getAnnotation(Packet.class);
            
            if(annotation == null)
               continue;
            
            packets.put(annotation.value(), method);
        }
        return packets;
    }    
}
