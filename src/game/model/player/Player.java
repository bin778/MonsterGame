package game.model.player;

import game.model.monster.Monster;
import game.view.ViewAttackReaction;
import game.view.ViewHP;
import game.view.ViewMonsterDex;

/**
 * ✅ 플레이어 클래스
 * - 이름, 체력 관리
 * - 몬스터 공격/포획/휴식 등 플레이어 행동 정의
 */
public class Player {
	private String name;
	private int hp = 100;

    // TODO: 함수 분리 방향 더 생각해보기
	ViewMonsterDex vmd = new ViewMonsterDex();
    ViewAttackReaction viewat = new ViewAttackReaction();
	AttackMonster am = new AttackMonster();
    Rest rest = new Rest();
	ViewHP ph = new ViewHP();

	// 이름 입력하기
	public void enterName(String name) {
		this.name = name;
	}

	// 도감 목록 보기- 잡은 몬스터 목록, 잡아야할 몬스터 목록 모두 포함
	// 아래 함수들에 대한 몬스터 상태에 대한 것은 몬스터 패키지에서 처리
	public void viewMonsterDex(Monster[] monsterList) {
		System.out.println(vmd.viewMonsterDex(monsterList, this.name));
	}

    // 몬스터 잡기 - 잡혔는지 안잡혔는지 결과에 따라 처리하기
	public void attackMonster(Monster monster) {
		if (checkHP()) return;
		System.out.println("🎯 " + this.name + "이(가) 몬스터를 잡으려 합니다!");
		am.attackMonster(monster);
		this.consumeHP();
	}

    // 몬스터 공격하기 - 플레이어, 포켓몬 에너지 깎임
	public void hitMonster(Monster monster) {
        if (checkHP()) return;
		System.out.println("💥 " + this.name + "이(가) 몬스터에게 공격을 시도합니다!");
		this.consumeHP();
        viewat.viewAttackReaction(monster.getAttackName());
		monster.takeDamage();
	}

	// 휴식 - 에너지 복구
	public void rest() {
        rest.rest(this);
	}

    private boolean checkHP() {
        if (this.hp <= 0) {
            ph.recoveryHP(name);
            return true;
        }
        return false;
    }

    // 체력 감소 - 행동할 때 마다 플레이어 체력이 깍임(10 감소)
	private void consumeHP() {
		final int conHP = 10;
		this.hp -= conHP;
		ph.printHP(hp, conHP, name);
	}

    // 공통 getter
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
