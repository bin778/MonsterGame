package game.view;

import game.model.context.GameContext;

public class ViewController {
    public void printWelcomeMessage() {
        System.out.println("--------------------------------");
        System.out.println("📝 명령어 예시:");
        System.out.println("  start         → 게임 시작");
        System.out.println("  exit          → 프로그램 종료");
        System.out.println("--------------------------------");
    }

    public void printStartGuide(GameContext gameContext) {
        System.out.println("\n## 게임 시작!");
        System.out.println("🔥 몬스터 초기화 완료 ("
            + gameContext.getMonsterManager().getAllMonsters().length + " 마리 등장)");
        System.out.println("😁 당신의 이름은 무엇입니까?");
    }

    public void printInGameHelp() {
        System.out.println("📌 명령어 예시:");
        System.out.println("  dex        → 몬스터 도감 보기");
        System.out.println("  go 1       → 산으로 탐험 가기");
        System.out.println("  go 2       → 바다로 탐험 가기");
        System.out.println("  go 3       → 학교로 탐험 가기");
        System.out.println("  zz         → 체력 회복하기");
        System.out.println("  exit       → 게임 종료\n");
    }

    public void printExitMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("   게임 종료! 다음에 또 만나요 😊");
        System.out.println("🌟==============================🌟\n");
    }

    public void playerLoseMessage() {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("🔥 120턴을 초과했습니다. 몬스터들이 모두 도망갔습니다!");
        System.out.println("게임 오버 😵");
        System.out.println("🌟==============================🌟\n");
    }

    public void playerWinMessage(int turnCount) {
        System.out.println();
        System.out.println("🌟==============================🌟");
        System.out.println("    모든 몬스터를 잡았습니다! 😁");
        System.out.println("    당신은 진정한 트레이너입니다! 😁");
        System.out.println("    승리하였습니다! 🎊");
        System.out.println("총 소요 턴 수: " + turnCount + "턴");

        if (turnCount <= 80) {
            System.out.println("당신의 랭크는 S입니다!");
        } else if (turnCount <= 90) {
            System.out.println("당신의 랭크는 A입니다!");
        } else if (turnCount <= 100) {
            System.out.println("당신의 랭크는 B입니다!");
        } else if (turnCount <= 110) {
            System.out.println("당신의 랭크는 C입니다!");
        } else {
            System.out.println("당신의 랭크는 D입니다!");
        }
        System.out.println("🌟==============================🌟\n");
    }
}
