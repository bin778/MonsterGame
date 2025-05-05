package game.model.habitat;

import java.util.Scanner;

import game.model.context.GameContext;
import game.model.monster.Monster;
import game.view.OutputString;

// ✅ 지역 탐험을 담당하는 서비스 클래스
// 입력받은 지역에 따라 몬스터 탐험을 실행하고, 플레이어 행동(잡기/공격)을 지역별로 처리
// 지역에 입장할 때 안내 메시지(printRegionIntro) 출력
public class HabitatService {
    static OutputString output = new OutputString();

	public static void exploreRegion(String region, GameContext gameContext) {
		printRegionIntro(region);
		Monster[] uncapturedMonstersByRegion = gameContext.getMonsterManager().getUncapturedMonstersByRegion(region);
		if (uncapturedMonstersByRegion.length == 0) {
			System.out.println("⚠️ 이 지역에서 더 이상 잡을 수 있는 몬스터가 없습니다.");
			return;
		}
		gameContext.getMonsterManager().showMonstersByRegion(uncapturedMonstersByRegion);

		System.out.println("💡 행동을 선택하세요: 1.잡기  2.공격하기 0.지역 선택으로 돌아가기");
		String action = output.outputString();
		Monster target = gameContext.getMonsterManager().getRandomMonster(uncapturedMonstersByRegion);

		// 플레이어 체력이 0 이하인 것은 플레이어 함수에서 처리
		switch (action) {
			case "1":
				target.printMonster();
				gameContext.getPlayer().attackMonster(target);
				break;
			case "2":
				target.printMonster();
				gameContext.getPlayer().hitMonster(target);
				break;
			case "0":
				return;
			default:
				System.out.println("⚠️ 올바른 입력이 아닙니다.");
		}
		if (target.isCaptured()) {
			System.out.println("🎉 몬스터 한 마리를 잡았습니다! 축하합니다!");
		}
	}

	private static void printRegionIntro(String region) {
		switch (region) {
			case "mountain":
				System.out.println("⛰️ 산에 들어섰습니다. 거대한 바위 몬스터가 출몰합니다!");
				break;
			case "sea":
				System.out.println("🌊 바다에 도착했습니다. 깊은 곳에서 몬스터가 솟아오릅니다!");
				break;
			case "school":
				System.out.println("🏫 학교 안으로 들어갑니다. 의외의 장소에서 몬스터가 나타납니다!");
				break;
			default:
				System.out.println("🗺️ 낯선 지역에 들어섰습니다.");
		}
	}
}
