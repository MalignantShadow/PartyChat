package com.kill3rtaco.partychat;

import taco.tacoapi.api.TacoPlugin;

public class PartyChat extends TacoPlugin {

	@Override
	public void onStart() {
		chat.out("Enabled");
	}

	@Override
	public void onStop() {
		chat.out("Disabled");
	}

}
