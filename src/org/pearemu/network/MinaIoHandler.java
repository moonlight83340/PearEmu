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
    final private Map<String, Method> packets = new HashMap<>();
    
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
       for(int id_Size = 3; id_Size >= 2; --id_Size)
       {
         String id_Packet = packet.substring(0, id_Size);
         String extra = packet.substring(id_Size,packet.length);
       }
       
    }
            
}
