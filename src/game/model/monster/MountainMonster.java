package game.model.monster;

// ✅ 산(Mountain) 지역 몬스터 클래스 (Monster 상속)
public class MountainMonster extends Monster { // 자식클래스(몬스터의 종류별 특징 구현) - 1산몬스터
	public MountainMonster(int id, String name, int maxEnergy) {
		super(id, name, maxEnergy);
		this.habitat = "mountain";
		this.attackName = "바위던지기";
		this.hpLoss = 50;
	}

	/**
	 * ✅ [method override] 몬스터가 플레이어 공격에 반응하는 메서드
	 * - 산 몬스터 전용 데미지 연출과 체력 감소 로직
	 */
	@Override
	public void takeDamage() {
		// super.reduceHp(damage); 와 같음. 자식에서 오버라이드 하지 않음
		reduceHp(this.hpLoss); // 현재 클래스에 없으므로 부모 거 호출

		// reduceHP(->체력을 깎는 메서드), 몬스터가 받는 데미지 만큼의 값을 메서드에 넣어준다.
		System.out.println(
				"😵 몬스터 " + this.getName() + "이(가) " + this.attackName + "공격으로 " + this.hpLoss + " 데미지를 입었습니다.");
		System.out.println("🩸 남은 체력: " + this.getHp());
	}
}
