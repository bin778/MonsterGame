package game.view;

/**
 * ✅ 플레이어 체력 감소/회복 관련 메시지를 출력하는 클래스
 */
public class ViewHP {
    public void printHP(int hp, int conHp, String name) {
        System.out.println("플레이어 체력이 " + conHp + " 감소하였습니다.");
        System.out.println("현재 " + name + "님의 체력은 " + hp + "입니다.\n");
    }

    // 체력 방전 메시지
    public void recoveryHP(String name) {
        System.out.println("❤️ " + name + "님은 지쳐 있어 체력을 회복해야 합니다!");
    }
}
