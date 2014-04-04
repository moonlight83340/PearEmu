package org.pearemu.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.pearemu.commons.Constants;


abstract public class MinaServer {

	final static private String OUT_EOP = "\0";
	final static private String IN_EOP  = "\n\0"; 
	final static private int BUFFER     = 512;
	
	final protected NioSocketAcceptor acceptor = new NioSocketAcceptor();
	
	public MinaServer(short port,IoHandlerAdapter handler) throws IOException{
		acceptor.getSessionConfig().setReadBufferSize(BUFFER);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.READER_IDLE,Constants.DECO_TIME);
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(
                Charset.forName("UTF-8"),
                OUT_EOP,
                IN_EOP)));
		acceptor.setHandler(handler);
		acceptor.bind(new InetSocketAddress(port));
		
	}
}
