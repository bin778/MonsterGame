package game.model.monster;

import java.io.*;
import java.nio.file.*;
import java.util.*;

// ✅ 초기 몬스터 데이터 생성용 클래스
// Mountain, Sea, School 지역별 몬스터 18마리를 초기화하여 Monster 배열로 반환
public class MonsterData {
    private static final String CSV_FILE = "monster.csv";

	public static Monster[] getInitialMonsters() {
        List<Monster> monsters = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_FILE));

            for (int i = 1; i < lines.size(); i++) {
                String[] fields = lines.get(i).split(",");

                int id = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim();
                String type = fields[2].trim().toLowerCase();
                int maxEnergy = Integer.parseInt(fields[3].trim());

                switch (type) {
                    case "mountain" -> monsters.add(new MountainMonster(id, name, maxEnergy));
                    case "sea"      -> monsters.add(new SeaMonster(id, name, maxEnergy));
                    case "school"   -> monsters.add(new SchoolMonster(id, name, maxEnergy));
                    default -> System.out.println("⚠️ 알 수 없는 타입: " + type);
                }
            }

        } catch (IOException e) {
            System.err.println("⚠️ 몬스터를 불러오는 데 문제 발생: " + e.getMessage());
        }
        return monsters.toArray(new Monster[0]);
	}
}
