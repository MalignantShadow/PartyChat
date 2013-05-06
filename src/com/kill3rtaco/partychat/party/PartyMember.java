package com.kill3rtaco.partychat.party;

import org.bukkit.entity.Player;

import com.kill3rtaco.partychat.PartyChat;

public class PartyMember {

	private Player player;
	private Party party;
	private String name;
	
	public PartyMember(Player player) {
		this.player = player;
		this.name = player.getName();
		this.party = null;
	}
	
	public String getName(){
		return name;
	}
	
	public Party getParty(){
		return party;
	}
	
	public boolean isLeader(){
		if(party == null) return false;
		return this == party.getLeader();
	}
	
	public void sendMessage(String message){
		PartyChat.plugin.chat.sendPlayerMessageNoHeader(player, message);
	}

}
