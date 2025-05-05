package game.model.monster;

/**
 * ✅ 모든 몬스터가 공통으로 가지는 기본 속성과 기능 정의 (부모 클래스)
 * 몬스터가 데미지를 받거나, 포획되거나, 정보를 출력하는 기능 제공
 */
public class Monster {
	private final int id;
	private final String name;
	private int hp; // 에너지. 체력
    private boolean isCaptured; // 잡힘 상태. 잡혔으면 true 아니면 false
	protected String habitat;
	protected String attackName;
	protected int hpLoss;

	public Monster(int id, String name, int maxEnergy) {
		this.id = id;
		this.name = name;
        this.hp = maxEnergy;
		this.habitat = "서식지";
		this.attackName = "공격이름";
		this.hpLoss = 10;
	}

	// 몬스터 정보 출력
	public void printMonster() {
		System.out.println("이름: " + this.name + ", 몬스터 HP: " + this.hp + ", 몬스터 서식지: " + this.habitat);
	}

	/**
	 * - 몬스터가 맞을 때 출력되는 멘트를 지역/속성별로 다르게 처리 -> 자식 클래스에서 오버라이드하여 사용
	 */
	public void takeDamage() {
		System.out.println("😵 몬스터 " + this.name + "이(가) " + this.hpLoss + " 만큼의 데미지를 입었습니다.");
	}

	// 몬스터가 공격을 받았을 때 체력을 감소시키는 메서드
	public void reduceHp(int hpLoss) {
		this.hp = Math.max(0, this.hp - hpLoss);
	}

	// 공통 getter
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public boolean isCaptured() {
		return isCaptured;
	}

	public String getHabitat() {
		return habitat;
	}

	public String getAttackName() {
		return attackName;
	}

    // 공통 setter
	public void setIsCaptured(boolean isCaptured) {
		this.isCaptured = isCaptured;
	}
}
