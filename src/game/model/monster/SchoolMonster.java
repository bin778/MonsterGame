package game.model.monster;

// ✅ 학교(School) 지역 몬스터 클래스 (Monster 상속)
public class SchoolMonster extends Monster {
	public SchoolMonster(int id, String name, int maxEnergy) { // 자식클래스(몬스터의 종류별 특징 구현) - 3학교몬스터
		super(id, name, maxEnergy);
		this.habitat = "school";
		this.attackName = "지식의 파도";
		this.hpLoss = 99;
	}

	/**
	 * ✅ [method override] 몬스터가 플레이어 공격에 반응하는 메서드
	 * - 학교 몬스터 전용 데미지 연출과 체력 감소 로직
	 */
	@Override
	public void takeDamage() {
		// super.reduceHp(damage)
		reduceHp(this.hpLoss);

		System.out.println("📚 " + getName() + "이(가) " + attackName + "에 맞아 " + hpLoss + " 데미지를 입었습니다!");
		System.out.println("🧠 남은 체력: " + getHp());
	}
}
