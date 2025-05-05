package game.model.monster;

import java.util.Random;

// ✅ 몬스터 리스트를 관리하는 매니저
// 전체 몬스터 목록을 저장하고, 지역별 미포획 몬스터 필터링, 랜덤 몬스터 선택 기능 제공
//(showMonstersByRegion)하는 기능도 포함
public class MonsterManager {
	private final Monster[] allMonsters;

	public MonsterManager() {
		this.allMonsters = MonsterData.getInitialMonsters(); // 초기 몬스터 배열 받아서 저장. 게임 시작되면 가능한 몬스터들 준비하는 단게
	}

	public Monster[] getAllMonsters() {
		return allMonsters; // 몬스터 조회
	}

	public Monster[] getUncapturedMonstersByRegion(String region) { // 해당 지역 몬스터만 불러내기
		// 임시 배열은 최대 크기를 전체 몬스터 수로 설정
		Monster[] tempArray = new Monster[this.allMonsters.length];
		int count = 0; // 조건에 맞는 몬스터 수를 셈

        for (Monster m : this.allMonsters) {
            if (!m.isCaptured() && m.getHabitat().equals(region)) {
                tempArray[count] = m;
                count++;
            }
        }
		// 실제 크기만큼 새 배열 생성 후 복사
		Monster[] resultList = new Monster[count];
        System.arraycopy(tempArray, 0, resultList, 0, count);
		return resultList;
	}

	// 몬스터 목록을 출력
	public void showMonstersByRegion(Monster[] allMonsters) {
		System.out.println("\n📋 몬스터 목록:");
		System.out.println("-----------------------------");
        for (Monster allMonster : allMonsters) {
            allMonster.printMonster();
        }
		System.out.println("-----------------------------");
	}

	// 랜덤으로 몬스터를 선택(잡기/공격하기 선택 시)
	public Monster getRandomMonster(Monster[] monsters) {
		if (monsters == null || monsters.length == 0) {
			throw new IllegalArgumentException("선택 가능한 몬스터가 없습니다.");
		}
		Random r = new Random();
		int index = r.nextInt(monsters.length); // 0 ~ monsters.length - 1
		return monsters[index];
	}
}
