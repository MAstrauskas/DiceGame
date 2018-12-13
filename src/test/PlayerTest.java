package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.app.domain.Player;

public class PlayerTest {
	Player player;
	
	@Before
	public void setUpPlayer() {
		player = new Player();
		player.setPlayerName("Test");
		player.addScore(10);
	}
	
	@Test
	public void getName() {
		assertEquals(player.getPlayerName(), "Test");
	}
	
	@Test
	public void getScore() {
		assertEquals(player.getScore(), 10);
	}
}
