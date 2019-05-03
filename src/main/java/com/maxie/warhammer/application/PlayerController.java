package com.maxie.warhammer.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.maxie.warhammer.domain.Player;
import com.maxie.warhammer.domain.ArmyResource;

import javax.validation.Valid;

@RestController
public class PlayerController {
	
	@GetMapping(value = "/exampleplayer")
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

	@PutMapping(value = "/player")
	@ResponseStatus(HttpStatus.OK)
	public Player updatePlayer(@Valid Player player) {
		Player updatedPlayer = new Player.Builder(player.getName())
				.army(player.getArmy())
				.score(player.getScore())
				.build();

		updatedPlayer.setArmyResource(player.getArmyResource());
		return updatedPlayer;
	}

	@PostMapping(value = "/player")
	@ResponseStatus(HttpStatus.CREATED)
	public Player createPlayer(@Valid Player player) {
		Player createdPlayer = new Player.Builder(player.getName())
				.army(player.getArmy())
				.score(player.getScore())
				.build();

		createdPlayer.setArmyResource(player.getArmyResource());
		return createdPlayer;
	}
	

}
