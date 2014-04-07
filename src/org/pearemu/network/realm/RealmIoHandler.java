package org.pearemu.network.realm;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.pearemu.commons.Constants;
import org.pearemu.commons.tools.StringTools;

public class RealmIoHandler extends IoHandlerAdapter{

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
        System.out.println("Send >> " + message);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        String packet = ((String)message).trim();
        
        if(packet.length() == 0)
            return;
        
        System.out.println("Recv << " + packet);
        int  numPacket = session.containsAttribute(1) ? (int)session.getAttribute(1) : 1;
        
        switch(numPacket){
            case 1 : 
                if(!packet.equals(Constants.DOFUS_VER)){
                    RealmPacketEnum.REQUIRE_VERSION.send(session);
                    session.close(true);
                }
            break;  
        }
        session.setAttribute(1,numPacket+1);
        
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);
        System.out.println("Logout");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        System.out.println("New client");
        RealmPacketEnum.HELLO_CONNECTION.send(session, StringTools.strRand(32));
    }
    
}