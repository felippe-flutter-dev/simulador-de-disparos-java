package engine;

import enuns.GunPowderType;
import model.M4;

import java.util.Scanner;

public class ShootingEngine {
    private final M4 weapon;
    private final Scanner scanner;

    public ShootingEngine() {
        this.weapon = new M4();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== SIMULADOR DE TIRO TERMINAL ===");
        System.out.println("Arma: M4 | Calibre: 5.56mm");
        System.out.println("Comandos: [ENTER] para atirar | [q] para sair | [m] para mudar modo de disparo | [r] para recarregar");
        System.out.println("----------------------------------");

        while (true) {
            System.out.print("> "); // Prompt de entrada
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Saindo... Limpando armamento.");
                break; // Sai do loop e encerra o programa
            }

            if (input.equalsIgnoreCase("m")) {
                weapon.cycleFireMode();
                System.out.println("Modo de disparo alterado para: " + weapon.getCurrentFireMode());
                continue;
            }

            if (input.equalsIgnoreCase("r")) {
                System.out.println("Qual tipo de munição deseja recarregar? (1) " + GunPowderType.STANDARD.description + " (2) " + GunPowderType.HIGH_VELOCITY.description + " (3) " + GunPowderType.PLUS_P.description + " (4) Cancelar");
                System.out.print("> ");
                String choice = scanner.nextLine();
                GunPowderType selectedType = null;
                switch (choice) {
                    case "1" -> selectedType = GunPowderType.STANDARD;
                    case "2" -> selectedType = GunPowderType.HIGH_VELOCITY;
                    case "3" -> selectedType = GunPowderType.PLUS_P;
                    default -> {
                        System.out.println("Recarregamento cancelado.");
                    }
                }
                if (selectedType == null) continue;
                System.out.println("Quantas balas deseja recarregar? (Max: " + weapon.getMaxCapacity() + ")");
                System.out.print("> ");
                int amount;
                try {
                    amount = Integer.parseInt(scanner.nextLine());
                    if (amount < 1 || amount > weapon.getMaxCapacity()) {
                        System.out.println("Quantidade inválida. Recarregamento cancelado.");
                        continue;
                    } else {
                        for (int i = 0; i < amount; i++) {
                            weapon.reload(new model.Ammo("5.56x45mm NATO", 1479, selectedType));
                        }
                        System.out.println("Recarregado com munição: " + selectedType.description);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Recarregamento cancelado.");
                    continue;
                }
                continue;
            }

            weapon.fire(weapon.getCurrentFireMode());

            // Mostra quantas balas restam no carregador
            System.out.println("Balas restantes: " + weapon.getCapacity());
        }

        scanner.close();
    }


    public static void main(String[] args) {
        new ShootingEngine().start();
    }
}