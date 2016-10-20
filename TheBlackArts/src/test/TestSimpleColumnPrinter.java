package test;

public class TestSimpleColumnPrinter {
    public static void main(String[] args) {
        String[] attackers = {
                "Monster X",
                "Monster Y",
                "Monster C"

        };
        String[] availableDefenders = {
                "Monster A",
                "Monster B",

        };

        // Determine which of the two arrays is the longest, and use that to iterate

        if (attackers.length > availableDefenders.length) {
            System.out.format("%-20s%s\n", "Attackers:", "Avail. Defenders:");
            for (int i = 0, n = attackers.length; i < n; i++) {
                System.out.format("%-20s", attackers[i]);
                if (i >= 0 && i < availableDefenders.length)
                    System.out.print(availableDefenders[i] + "\n");
                else {
                    System.out.println();
                }

            }
        } else {
            System.out.format("%-20s%s\n", "Attackers:", "Avail. Defenders:");
            for (int i = 0, n = availableDefenders.length; i < n; i++) {
                if (i >= 0 && i < attackers.length) {
                    System.out.format("%-20s", attackers[i]);
                } else {
                    System.out.format("%-20s", "");
                }
                System.out.println(availableDefenders[i]);
            }
        }
    }
}
