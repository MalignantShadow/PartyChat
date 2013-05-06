package com.kill3rtaco.partychat.party;

import java.util.ArrayList;

import com.kill3rtaco.partychat.PartyChat;

public class Party {

	private ArrayList<PartyMember> members;
	private ArrayList<String> invited;
	private PartyMember leader;
	private boolean open;
	
	public Party() {
		members = new ArrayList<PartyMember>();
		invited = new ArrayList<String>();
		leader = null;
		open = true;
	}
	
	public void addMember(PartyMember member){
		members.add(member);
	}
	
	public void assignNewLeader(){
		if(members.size() == 0){
			removeSelf();
		}else{
			leader = members.get(0);
		}
	}
	
	public ArrayList<PartyMember> getMembers(){
		return members;
	}
	
	public PartyMember getLeader(){
		return leader;
	}
	
	public boolean hasMember(String name){
		for(PartyMember pm : members){
			if(pm.getName().equalsIgnoreCase(name)) return true;
		}
		return false;
	}
	
	public void invitePlayer(String name){
		invited.add(name);
	}
	
	public boolean isInvited(String name){
		for(String s : invited){
			if(s.equalsIgnoreCase(name)) return true;
		}
		return false;
	}
	
	public boolean isOpen(){
		return open;
	}
	
	public void removeSelf(){
		PartyChat.plugin.removeParty(this);
	}
	
	public void sendMessage(PartyMember speaker, String message){
		String fullMessage = (speaker.isLeader() ? "&2" : "&a") + speaker.getName() + "&7: &a" + message;
		for(PartyMember pm : members){
			pm.sendMessage(fullMessage);
		}
	}
	
	
	public void sendNewLeaderMessage(){
		for(PartyMember pm : members){
			pm.sendMessage("&e" + (leader.getName().equalsIgnoreCase(pm.getName()) ? leader.getName() + " is" : "You are") + " now the party leader!");
		}
	}
	
	public void sendNewMemberMessage(PartyMember member){
		for(PartyMember pm : members){
			pm.sendMessage("&e" + (pm.getName().equalsIgnoreCase(member.getName()) ? member.getName() : "You") + " joined the party");
		}
	}
	
	//does not add a new member if the given PartyMember does not exist
	public void setLeader(PartyMember newLeader){
		leader = newLeader;
	}
	
	public void setOpen(boolean open){
		this.open = open;
	}

}
