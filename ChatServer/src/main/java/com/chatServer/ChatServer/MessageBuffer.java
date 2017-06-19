package com.chatServer.ChatServer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chatServer.ChatServer.Controllers.DatabaseController;

public class MessageBuffer {
	final static Logger logger = LoggerFactory.getLogger(MessageBuffer.class);
	
	private BlockingQueue<Message> buffer = null;
	private static MessageBuffer instance = null;
	
	private MessageBuffer() {
		this.buffer = new ArrayBlockingQueue<Message>(2048);
		logger.info("new Taskbuffer has been created");
	}
	
	public static MessageBuffer getInstance() {
		if (instance == null) {
			instance = new MessageBuffer();
		}
		return instance;
	}
	
	public Message getNext() throws InterruptedException{
		return buffer.poll();
	}
	
	public void addTask(Message msg) throws Exception{
		buffer.put(msg);
	}
	
	public int getSize(){
		return buffer.size();
	}

	public boolean hasNew(){
		if(buffer != null){
			return !buffer.isEmpty();
		}
		return false;
	}
}