package com.chatServer.ChatServer;

// Data Type
public class Message {
	private int sender;
	private int receiver;
	private String time;
	private String content;
	
	public Message(int sender, int receiver, String time, String content){
		this.sender = sender;
		this.receiver = receiver;
		this.time = time;
		this.content = content;
	}
	
	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
