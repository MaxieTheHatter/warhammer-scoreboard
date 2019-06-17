package com.maxie.warhammer.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.maxie.warhammer.domain.Player;
import com.maxie.warhammer.domain.ArmyResource;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PlayerController {

	private List<Player> players = new ArrayList<>();
	
	@GetMapping(value = "/exampleplayer")
	public Player examplePlayer() {
		Player player = new Player.Builder("exampleplayer")
				.id(getMaxId())
				.army("cheesedar")
				.score(0)
				.build();
		
		ArmyResource armyResource = new ArmyResource.Builder("cheese")
				.resource(9001)
				.build();
		
		
		player.setArmyResource(armyResource);
		
		return player;
	}

	@GetMapping(value = "/players")
	public List<Player> getPlayers() {

		if (players.isEmpty()) {
			dummyLoadPlayers();
		}
		return players;
	}

	@PutMapping(value = "/players")
	@ResponseStatus(HttpStatus.OK)
	public Player updatePlayer(@RequestBody Player player) {
		players.remove(player);

		Player updatedPlayer = new Player.Builder(player.getName())
				.id(player.getId())
				.army(player.getArmy())
				.score(player.getScore())
				.build();

		updatedPlayer.setArmyResource(player.getArmyResource());
		players.add(updatedPlayer);
		return updatedPlayer;
	}

	@PostMapping(value = "/players")
	@ResponseStatus(HttpStatus.CREATED)
	public Player createPlayer(@RequestBody Player player) {
		Player createdPlayer = new Player.Builder(player.getName())
				.id(getMaxId())
				.army(player.getArmy())
				.score(player.getScore())
				.build();

		createdPlayer.setArmyResource(player.getArmyResource());
		players.add(createdPlayer);
		return createdPlayer;
	}

	private int getMaxId() {
		if (players.isEmpty()) {
			return 1;
		} else {
			Player player = Collections.max(this.players, Comparator.comparing(p -> p.getId()));
			int maxId = player.getId();
			return maxId + 1;
		}
	}

	private void dummyLoadPlayers() {
		Player player1 = new Player.Builder("Max")
				.id(getMaxId())
				.army("Kharadron Overlords")
				.score(0)
				.build();

		player1.setArmyResource(new ArmyResource.Builder("None")
				.resource(0)
				.build());

		players.add(player1);

		Player player2 = new Player.Builder("Johan")
				.id(getMaxId())
				.army("Blades of Khorne")
				.score(0)
				.build();

		player2.setArmyResource(new ArmyResource.Builder("Blood Tithe")
				.resource(8)
				.build());

		players.add(player2);

		Player player3 = new Player.Builder("Micke")
				.id(getMaxId())
				.army("Hedonites of Slaanesh")
				.score(0)
				.build();

		player3.setArmyResource(new ArmyResource.Builder("Dildo Points")
				.resource(60)
				.build());

		players.add(player3);
	}
	

}
