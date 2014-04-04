package org.pearemu.network.realm;

import java.io.IOException;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.pearemu.network.MinaServer;
import org.pearemu.network.MinaServer;

public class RealmServer extends MinaServer {
	final static private short PORT = 444;
	
	public RealmServer() throws IOException {
		super(PORT, new RealmIoHandler());
		
	}

	

}
