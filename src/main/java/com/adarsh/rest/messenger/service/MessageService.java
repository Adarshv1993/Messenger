package com.adarsh.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.adarsh.rest.messenger.database.DatabaseClass;
import com.adarsh.rest.messenger.model.Message;
import com.adarsh.rest.messenger.model.Profile;

public class MessageService {
	
	private Map<Long,Message> messages=DatabaseClass.getMessage();
	private Map<Long,Profile> profiles=DatabaseClass.getProfiles();
	
	public MessageService(){
		messages.put(1L,new Message(1,"Hello World!","adarsh"));
		messages.put(2L,new Message(2,"Hello Jersey!","abhijeet"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message addMessage(Message message){
		message.setId(message.getId()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message){
			if(message.getId()<=0){
				return null;
			}
			else{
				messages.put(message.getId(), message);
				return message;
			}
	}
	
	public Message removeMessage(Long id){
		return messages.remove(id);
	}
	
	public Message getMessage(Long id){
			return messages.get(id);
	}
}
