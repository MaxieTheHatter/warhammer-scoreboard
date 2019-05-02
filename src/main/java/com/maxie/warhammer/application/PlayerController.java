package com.maxie.warhammer.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxie.warhammer.domain.Player;
import com.maxie.warhammer.domain.ArmyResource;

@RestController
public class PlayerController {
	
	@RequestMapping(value = "/exampleplayer", method = RequestMethod.GET)
	public Player examplePlayer() {
		Player player = new Player.Builder("exampleplayer")
				.army("cheesedar")
				.score(0)
				.build();
		
		ArmyResource armyResource = new ArmyResource.Builder("cheese")
				.resource(9001)
				.build();
		
		
		player.setArmyResource(armyResource);
		
		return player;
	}
	

}
