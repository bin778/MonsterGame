package game.model.monster;

// ✅ 바다(Sea) 지역 몬스터 클래스 (Monster 상속)
public class SeaMonster extends Monster { // 자식클래스(몬스터의 종류별 특징 구현) - 2바다 몬스터
	public SeaMonster(int id, String name, int maxEnergy) {
		super(id, name, maxEnergy);
		this.habitat = "sea";
		this.attackName = "물대포";
		this.hpLoss = 40;
	}

	/**
	 * ✅ [method override] 몬스터가 플레이어 공격에 반응하는 메서드
	 * - 바다 몬스터 전용 데미지 연출과 체력 감소 로직
	 */
	@Override
	public void takeDamage() {
		// super.reduceHp(damage)
		reduceHp(this.hpLoss);

		System.out.println("🌊 몬스터 " + getName() + "이(가) " + attackName + "으로 " + hpLoss + " 데미지를 입었습니다!");
		System.out.println("💧 남은 체력: " + getHp());
	}
}
