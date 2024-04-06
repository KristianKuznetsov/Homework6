package star;

import java.util.Arrays;

public class ATM {
    private int quantity20;
    private int quantity50;
    private int quantity100;

    public ATM() {
        this.quantity20 = 0;
        this.quantity50 = 0;
        this.quantity100 = 0;
    }

    public ATM(int quantity20, int quantity50, int quantity100) {
        this.quantity20 = quantity20;
        this.quantity50 = quantity50;
        this.quantity100 = quantity100;
    }

    public int[] uploadMoney(int quantity20, int quantity50, int quantity100) {
        int[] overflow = new int[3];
        boolean flag = false;

        if ((Integer.MAX_VALUE - quantity20) >= quantity20) {
            this.quantity20 = this.quantity20 + quantity20;
        } else {
            flag = true;
            overflow[0] = quantity20 - (Integer.MAX_VALUE - this.quantity20);
            this.quantity20 = Integer.MAX_VALUE;
        }

        if ((Integer.MAX_VALUE - quantity50) >= quantity50) {
            this.quantity50 = this.quantity50 + quantity50;
        } else {
            flag = true;
            overflow[1] = quantity50 - (Integer.MAX_VALUE - this.quantity50);
            this.quantity50 = Integer.MAX_VALUE;
        }

        if ((Integer.MAX_VALUE - quantity100) >= quantity100) {
            this.quantity100 = this.quantity100 + quantity100;
        } else {
            flag = true;
            overflow[2] = quantity100 - (Integer.MAX_VALUE - this.quantity100);
            this.quantity100 = Integer.MAX_VALUE;
        }

        if (flag) {
            return overflow;
        } else {
            return null;
        }
    }

    public boolean withdrawalMoney(int amount) {
        long total = this.quantity20 * 20L + this.quantity50 * 50L + this.quantity100 * 100L;
        if (amount % 10 != 0 || amount == 30 || amount == 10 || total < amount) {
            return false;
        }

        amount = amount / 10;
        int[] countOfBills = getPart(amount);
        if (countOfBills[0] <= this.quantity20 && countOfBills[1] <= this.quantity50) {
            this.quantity20 = this.quantity20 - countOfBills[0];
            this.quantity50 = this.quantity50 - countOfBills[1];
            amount = amount - (countOfBills[0] * 2 + countOfBills[1] * 5);
        } else {
            return false;
        }

        int required100 = amount / 10;
        boolean amountHasCollected = required100 == 0;

        if (!amountHasCollected) {
            if (required100 <= this.quantity100) {
                countOfBills[2] = required100;
                this.quantity100 = this.quantity100 - required100;
                required100 = 0;
                amountHasCollected = true;
            } else {
                countOfBills[2] = this.quantity100;
                required100 = required100 - this.quantity100;
                this.quantity100 = 0;
            }

            while (required100 != 0) {
                if (balancing()) {
                    countOfBills[0] = countOfBills[0] + 5;
                    this.quantity20 = this.quantity20 - 5;
                } else {
                    countOfBills[1] = countOfBills[1] + 2;
                    this.quantity50 = this.quantity50 - 2;
                }
                required100--;
            }
        }

        displayOfIssuedBanknotes(countOfBills);
        return true;
    }

    private static int[] getPart(int el) {
        return switch (el % 10) {
            case 1 -> {
                yield new int[]{3, 1, 0};
            }
            case 2 -> {
                yield new int[]{1, 0, 0};
            }
            case 3 -> {
                yield new int[]{4, 1, 0};
            }
            case 4 -> {
                yield new int[]{2, 0, 0};
            }
            case 5 -> {
                yield new int[]{0, 1, 0};
            }
            case 6 -> {
                yield new int[]{3, 0, 0};
            }
            case 7 -> {
                yield new int[]{1, 1, 0};
            }
            case 8 -> {
                yield new int[]{4, 0, 0};
            }
            case 9 -> {
                yield new int[]{2, 1, 0};
            }
            default -> {
                yield new int[]{0, 0, 0};
            }
        };
    }

    private boolean balancing() {
        if (this.quantity20 < 5) {
            return false;
        } else if (this.quantity50 < 2) {
            return true;
        } else {
            return (double) this.quantity20 * 3.8 > (double) quantity50;
        }
    }

    private static void displayOfIssuedBanknotes(int[] countOfBills) {
        int amount = countOfBills[0] * 20 + countOfBills[1] * 50 + countOfBills[2] * 100;
        System.out.println("-----------------------------------------------------");
        System.out.println("Выданна сумма " + amount + " следующими купюрами:");
        System.out.println("Номиналом 20: " + countOfBills[0]);
        System.out.println("Номиналом 50: " + countOfBills[1]);
        System.out.println("Номиналом 100: " + countOfBills[2]);
        System.out.println("-----------------------------------------------------");
        System.out.println("\n");
    }

    public void atmInfo() {
        System.out.println();
        System.out.println("*****************************************************");
        System.out.println("ATM info:");
        System.out.println("banknotes 20:  " + this.quantity20);
        System.out.println("banknotes 20:  " + this.quantity50);
        System.out.println("banknotes 20: " + this.quantity100);
        System.out.println("*****************************************************");
        System.out.println();
    }


}
