package game;

import game.controller.GameController;

// ✅ 게임 실행 메인 엔트리 포인트
// GameController를 생성하고 run() 메서드 호출하여 전체 게임을 시작
public class MonsterApp {
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
	}
}
