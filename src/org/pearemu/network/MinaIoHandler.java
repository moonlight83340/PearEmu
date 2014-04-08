/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.pearemu.network;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 *
 * @author moonlight83340
 */
public class MinaIoHandler extends IoHandlerAdapter{
    
    final private Map<String , Method > packets = new HashMap<>();
    final protected void registerPacketParser(PacketParser parser){
       packets.putAll(parser.getPackets());
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
        System.out.println("Send >> " + message);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message); 
         System.out.println("Recv << " + message);
    }
    
    final protected void parsePacket(String packet){
        if(packet.length()<2 )
            return;
        for(int size = 3; size >= 2; --size){
            String header = packet.substring(0, size);
            String extra = packet.substring(size);
            Method method = packets.get(header);
            
            if(method == null)
                continue;
            
            method.invoke(packets,parser);
            
        }  
    }
            
}
