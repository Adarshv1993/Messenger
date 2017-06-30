package com.adarsh.rest.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adarsh.rest.messenger.model.Message;
import com.adarsh.rest.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService service =new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return service.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
			return service.addMessage(message);
		}
	
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") Long id) {
			return service.getMessage(id);
	}
	
}	

