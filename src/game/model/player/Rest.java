package game.model.player;

public class Rest {
    public void rest(Player player) {
        if (player.getHp() <= 0) {
            System.out.println("❤️ 체력을 회복합니다! 이제 행동할 수 있습니다!");
            player.setHp(100);
        } else {
            System.out.println("😅 휴식 금지 다시 몬스터를 잡으러 가세요.");
        }
        System.out.println();
    }
}
