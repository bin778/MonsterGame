package game.controller;

import java.util.*;

import game.model.context.GameContext;
import game.model.habitat.HabitatService;
import game.model.monster.Monster;
import game.utils.Converter;
import game.view.*;

public class GameController {
    private GameContext gameContext;
    private final ViewController vc = new ViewController();
    private final OutputString output = new OutputString();
    private final Map<String, Runnable> commandMap = new HashMap<>();
    private boolean isGameStarted = false;
    private int turnCount = 0;

    public void run() {
        vc.printWelcomeMessage();
        initCommands();

        while (true) {
            String input = output.outputString().toLowerCase();

            if (input.equals("exit")) {
                vc.printExitMessage();
                break;
            }

            if (!isGameStarted) {
                handleGameStart(input);
                continue;
            }

            if (input.startsWith("go ")) {
                handleGoCommand(input);
                continue;
            }

            Runnable command = commandMap.get(input);
            if (command != null) {
                command.run();
            } else {
                System.out.println("⚠️ 존재하지 않는 명령어입니다. 사용 가능한 명령어:");
                vc.printInGameHelp();
            }
        }
    }

    private void initCommands() {
        commandMap.put("dex", () -> {
            gameContext.getPlayer()
                .viewMonsterDex(gameContext.getMonsterManager().getAllMonsters());
            vc.printInGameHelp();
        });

        commandMap.put("zz", () -> gameContext.getPlayer().rest());
    }

    private void handleGameStart(String input) {
        if (input.equalsIgnoreCase("start")) {
            startGame();
            vc.printInGameHelp();
        } else {
            System.out.println("⚠️ 존재하지 않는 명령어입니다. (start 또는 exit 입력 가능)");
        }
    }

    private void handleGoCommand(String input) {
        String regionName = input.substring(3).trim();
        String region = Converter.convertInputToRegion(regionName);

        if (region == null) {
            System.out.println("⚠️ 잘못된 탐험지 입니다. (go 1 / go 2 / go 3)");
            return;
        }

        System.out.println("🧭 선택된 장소: " + region);
        HabitatService.exploreRegion(region, gameContext);
        turnCount++;
        System.out.println(turnCount + "번째 턴 종료!");

        if (turnCount > 120) {
            vc.playerLoseMessage();
            System.exit(0);
        }

        if (Arrays.stream(gameContext.getMonsterManager().getAllMonsters())
            .allMatch(Monster::isCaptured)) {
            vc.playerWinMessage(turnCount);
            System.exit(0);
        }

        vc.printInGameHelp();
    }

    private void startGame() {
        this.gameContext = new GameContext();
        this.isGameStarted = true;
        this.turnCount = 0;
        vc.printStartGuide(this.gameContext);
        enterName();
    }

    private void enterName() {
        String inputName = output.outputString();
        if (inputName.isEmpty()) inputName = "트레이너";
        gameContext.getPlayer().enterName(inputName);
    }
}
