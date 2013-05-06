package com.kill3rtaco.partychat;

import java.util.ArrayList;

import com.kill3rtaco.partychat.party.Party;
import com.kill3rtaco.partychat.party.PartyMember;

import taco.tacoapi.api.TacoPlugin;

public class PartyChat extends TacoPlugin {

	public static PartyChat plugin;
	public ArrayList<Party> parties;
	
	@Override
	public void onStart() {
		plugin = this;
		parties = new ArrayList<Party>();
		chat.out("Enabled");
	}

	@Override
	public void onStop() {
		chat.out("Disabled");
	}
	
	public void addParty(Party party){
		parties.add(party);
	}
	
	public Party getParty(PartyMember member){
		for(Party p : parties){
			if(p.hasMember(member.getName())) return p;
		}
		return null;
	}
	
	public PartyMember getPartyMember(String name){
		for(Party p : parties){
			for(PartyMember m : p.getMembers()){
				if(m.getName().equalsIgnoreCase(name)) return m;
			}
		}
		return null;
	}
	
	public void removeParty(Party party){
		parties.remove(party);
	}

}
