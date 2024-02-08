package game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Character[] heroesFirstPlayer;
    private Character[] heroesPCPlayer;
    private int sizeTeam;

    private Character GetCharacterByNum(int n) {
        switch (n) {
            case 1:
                return new Barbarian();
            case 2:
                return new Witch();
        }
        return new Barbarian();
    }

    private void FillTeams() {
        heroesFirstPlayer = new Character[sizeTeam];
        heroesPCPlayer = new Character[sizeTeam];
        Random random = new Random();
        for (int i = 0; i < sizeTeam; i++) {
            heroesFirstPlayer[i] = GetCharacterByNum(random.nextInt(2) + 1);
            heroesPCPlayer[i] = GetCharacterByNum(random.nextInt(2) + 1);
        }
    }

    private void showBattlefield() {
        System.out.println(" Ваша команда     VS      PC команда");
        for (int i = 0; i < sizeTeam; i++) {
            System.out.println(heroesFirstPlayer[i].getName() + " " + heroesFirstPlayer[i].getHealth() + "HP" + "   ------>   " + heroesPCPlayer[i].getName() + " " + heroesPCPlayer[i].getHealth() + "HP");
        }
    }

    private boolean isGameOver() {
        int first = 0;
        int second = 0;
        for (int i = 0; i < sizeTeam; i++) {
            if (heroesFirstPlayer[i].getHealth() <= 0) {
                first++;
            }
            if (heroesPCPlayer[i].getHealth() <= 0) {
                second++;
            }
        }
        if (first == sizeTeam || second == sizeTeam) {
            return true;
        }
        return false;
    }

    private void whoWin() {
        int first = 0;
        int second = 0;
        for (int i = 0; i < sizeTeam; i++) {
            if (heroesFirstPlayer[i].getHealth() <= 0) {
                first++;
            }
            if (heroesPCPlayer[i].getHealth() <= 0) {
                second++;
            }
        }
        showBattlefield();
        if (second == sizeTeam) {
            System.out.println("Ви виграли!");
        } else {
            System.out.println("Ви програли!");
        }
    }

    private int whoToAttack() {
        int indexChose;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Кого атакувати?");
            for (int i = 0; i < sizeTeam; i++) {
                if (heroesPCPlayer[i].getHealth() > 0) {
                    System.out.println(i + 1 + "." + heroesPCPlayer[i].getName() + " " + heroesPCPlayer[i].getHealth() + "HP");
                }
            }
            System.out.print("->");
            indexChose = scanner.nextInt() - 1;
            if (indexChose >= 0 && indexChose < sizeTeam) {
                if (heroesPCPlayer[indexChose].getHealth() <= 0) {
                    System.out.println("Не коректний вибір!");
                } else {
                    break;
                }
            }
        }
        return indexChose;
    }

    private int whoToHealth() {
        int indexChose;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Кого лікувати?");
            for (int i = 0; i < sizeTeam; i++) {
                if (heroesFirstPlayer[i].getHealth() > 0) {
                    System.out.println(i + 1 + "." + heroesFirstPlayer[i].getName() + " " + heroesFirstPlayer[i].getHealth() + "HP");
                }
            }
            System.out.print("->");
            indexChose = scanner.nextInt() - 1;
            if (indexChose >= 0 && indexChose < sizeTeam) {
                if (heroesFirstPlayer[indexChose].getHealth() <= 0) {
                    System.out.println("Не коректний вибір!");
                } else {
                    break;
                }
            }
        }
        return indexChose;
    }
    private int whoToHealthForPC() {
        int indexChose;
        Random random = new Random();
        while (true) {
            indexChose = random.nextInt(sizeTeam);
            if (indexChose >= 0 && indexChose < sizeTeam) {
                if (heroesPCPlayer[indexChose].getHealth() > 0) {
                    break;
                }
            }
        }
        return indexChose;
    }

    private void makeAMovePlayerWitch(Witch witch) {
        int indexChose;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть дію:");
            System.out.println("Атакувати ->1");
            System.out.println("Накласти прокляття ->2");
            System.out.println("Лікувати ->3");
            System.out.print("->");
            indexChose = scanner.nextInt();
            if (indexChose >= 1 && indexChose <= 3) {
                break;
            } else {
                System.out.println("Не коректний вибір!");
            }
        }
            boolean b = true;
            while (b) {
                switch (indexChose) {
                    case 1:
                        witch.attack(heroesPCPlayer[whoToAttack()]);
                        b = false;
                        break;
                    case 2:
                        if (!witch.toCurse(heroesPCPlayer[whoToAttack()])) {
                            System.out.println("Ви вже використали прокляття!");
                            while (true) {
                                System.out.println("Виберіть дію:");
                                System.out.println("Атакувати ->1");
                                System.out.println("Накласти прокляття ->2");
                                System.out.println("Лікувати ->3");
                                System.out.print("->");
                                indexChose = scanner.nextInt();
                                if (indexChose >= 1 && indexChose <= 3) {
                                    break;
                                } else {
                                    System.out.println("Не коректний вибір!");
                                }
                            }
                        } else {
                            b = false;
                        }
                        break;
                    case 3:
                        witch.toHealth(heroesFirstPlayer[whoToHealth()]);
                        b = false;
                        break;
                }
            }


    }

    private void randomMovePC() {
        Random random = new Random();
        int indexChose;
        while (true) {
            indexChose = random.nextInt(sizeTeam);
            if (indexChose >= 0 && indexChose < sizeTeam) {
                if (heroesPCPlayer[indexChose].getHealth() > 0) {
                    break;
                }
            }
        }
        if (heroesPCPlayer[indexChose] instanceof Barbarian) {
            makeAMovePCBarbarian((Barbarian) heroesPCPlayer[indexChose]);
        }
        if (heroesPCPlayer[indexChose] instanceof Witch) {
            makeAMovePCWitch((Witch) heroesPCPlayer[indexChose]);//зависає програма на цьому місці
        }

    }

    private int whoAttackforPC() {
        int indexChose;
        Random random = new Random();
        while (true) {
            indexChose = random.nextInt(sizeTeam);
            if (indexChose >= 0 && indexChose < sizeTeam) {
                if (heroesFirstPlayer[indexChose].getHealth() > 0) {
                    break;
                }
            }
        }
        return indexChose;
    }

    private void makeAMovePCWitch(Witch witch) {
        int indexChose;
        Random random = new Random();
        //Scanner scanner = new Scanner(System.in);
        //while (true) {
            indexChose = random.nextInt(3) + 1;
            boolean b = true;
            while (b) {
                switch (indexChose) {
                    case 1:
                        witch.attack(heroesFirstPlayer[whoAttackforPC()]);
                        b = false;
                        break;
                    case 2:
                        if (witch.toCurse(heroesFirstPlayer[whoAttackforPC()])) {
                            b = false;
                        }else {
                            indexChose = random.nextInt(3) + 1;
                        }
                        break;
                    case 3:
                        witch.toHealth(heroesPCPlayer[whoToHealthForPC()]);
                        b = false;
                        break;
                }
//            }
//            if(!b){
//                break;
//            }

        }
    }

    private void makeAMovePCBarbarian(Barbarian barbarian) {
        barbarian.attack(heroesFirstPlayer[whoAttackforPC()]);
    }

    private void makeAMovePlayerBarbarian(Barbarian barbarian) {
        barbarian.attack(heroesPCPlayer[whoToAttack()]);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість персонажів ->");
        sizeTeam = scanner.nextInt();
        FillTeams();
        showBattlefield();
        while (!isGameOver()) {

            int indexChose;
            while (true) {
                System.out.println("Виберіть гравця:");
                for (int i = 0; i < sizeTeam; i++) {
                    if (heroesFirstPlayer[i].getHealth() > 0) {
                        System.out.println(i + 1 + "." + heroesFirstPlayer[i].getName() + " " + heroesFirstPlayer[i].getHealth() + "HP");
                    }
                }
                System.out.print("->");
                indexChose = scanner.nextInt() - 1;
                if (indexChose >= 0 && indexChose < sizeTeam) {
                    if (heroesFirstPlayer[indexChose].getHealth() <= 0) {
                        System.out.println("Не коректний вибір!");
                    } else {
                        break;
                    }
                }
            }
            if (heroesFirstPlayer[indexChose] instanceof Barbarian) {
                makeAMovePlayerBarbarian((Barbarian) heroesFirstPlayer[indexChose]);
            }
            if (heroesFirstPlayer[indexChose] instanceof Witch) {
                makeAMovePlayerWitch((Witch) heroesFirstPlayer[indexChose]);
            }
            if (isGameOver()) {
                whoWin();
                break;
            }
            showBattlefield();
            randomMovePC();
            if (isGameOver()) {
                whoWin();
                break;
            }
            showBattlefield();
        }

    }
}
