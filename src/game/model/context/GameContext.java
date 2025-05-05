package game.model.context;

import game.model.monster.MonsterManager;
import game.model.player.Player;

// ✅ 게임 전역 상태를 관리하는 컨텍스트 객체
// Player, MonsterManager를 생성해서 게임의 핵심 데이터(플레이어/몬스터)를 한 곳에 묶어 관리
public class GameContext {
	private final Player player;
	private final MonsterManager monsterManager;

	public GameContext() {
		this.player = new Player();
		this.monsterManager = new MonsterManager();
	}

	public Player getPlayer() {
		return player;
	}

	public MonsterManager getMonsterManager() {
		return monsterManager;
	}

}
