# monster-game-app

> JAVA로 몬스터 잡기 게임을 구현한 저장소입니다.

## 프로젝트 인원

- 이서우: 몬스터 객체, 구조 및 설계
- 최영빈: 플레이어 객체, 발표
- 이태희: 몬스터 객체
- 노유성: 플레이어 객체

## 프로젝트 기간

- 2025.04.22 ~ 2025.04.28

## 요구 사항

### 공통 요구사항

- 지정된 값 이외의 값을 입력하면 메시지를 출력하면서 예외 처리한다.
- 예외 처리하면 해당 지점부터 다시 입력한다.
- 클래스를 사용하여 각각의 메서드 역할을 분리한다.

### 게임 시작 요구 사항

- 우선 플레이어는 게임을 시작하거나 종료할 수 있다.
  - `start`, `exit` 중 하나의 명령어를 입력한다.

### 게임 진행 요구 사항

- 몬스터는 18마리로 산, 바다, 학교로 각각 6마리로 주어진다.
- 게임을 시작하기 전에 플레이어의 이름을 입력한다.
- 몬스터 도감을 보거나 서식지를 탐험할 수 있다.
  - `dex`: 몬스터 도감 보기
  - `go 1`: 산, `go 2`: 바다, `go 3`: 탐험
  - `exit`을 입력하면 중간에 게임을 종료할 수 있다.
- 서식지를 탐험하면 플레이어는 행동을 선택한다.
  - 번호를 입력해서 잡기, 공격하기, 휴식, 돌아가기를 선택한다.
- 잡기는 몬스터를 포획할 수 있다.
  - 잡은 몬스터는 `Boolean`값이 `true`로 바뀐다.
  - 잡기, 공격하기 행동을 하면 플레이어의 체력이 10씩 감소한다.
  - 몬스터의 체력마다 포획할 수 있는 확률이 달라진다.
    - 70 초과은 25%
    - 30 ~ 70은 50%
    - 30 이하는 100%
- 공격하기는 몬스터를 공격해서 체력을 깍게 한다.
  - 각 서식지마다 쓰는 기술을 사용해서 몬스터를 공격할 수 있다.
- 플레이어는 휴식을 취할 수 있다.
  - 반드시 체력이 0 이어야 휴식할 수 있다.
  - 휴식을 하면 플레이어의 체력은 100으로 회복된다.
- 모든 서식지의 몬스터를 잡으면 그 서식지에 접근할 수 없다.

### 게임 종료 요구 사항

- 게임을 종료하면 턴 수 마다 랭크 및 메시지를 출력하고 종료한다.
- 120턴을 초과하면 게임 오버처리 한다.

## 다이어그램

![image](https://github.com/user-attachments/assets/a96840de-4045-47c7-8b1c-ae6805d6452f)
![image](https://github.com/user-attachments/assets/2df5c7b0-fe61-4dc1-ac26-bb0831bee41a)

## 디렉터리 구조
```
src
└── game
    ├── context
    │   └── GameContext.java
    ├── controller
    │   └── GameController.java
    ├── habitat
    │   └── HabitatService.java
    ├── monster
    │   ├── Monster.java
    │   ├── MonsterData.java
    │   ├── MonsterManager.java
    │   ├── MountainMonster.java
    │   ├── SchoolMonster.java
    │   └── SeaMonster.java
    ├── MonsterApp.java
    ├── player
    │   ├── AttackMonster.java
    │   ├── HitMonster.java
    │   ├── Player.java
    │   ├── PrintHP.java
    │   └── ViewMonsterDex.java
    └── utils
        └── Converter.java
```
