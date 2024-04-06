package star;

public class ATM {
    int quantity20;
    int quantity50;
    int quantity100;

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

    public boolean withdrawalMoney(int amount){

        return false;
    }

    public void atmInfo(){
        System.out.println();
        System.out.println("*****************************************************");
        //System.out.println("ATM info:");
        System.out.println("banknotes 20:  " + this.quantity20);
        System.out.println("banknotes 20:  " + this.quantity50);
        System.out.println("banknotes 20: " + this.quantity100);
        System.out.println("*****************************************************");
        System.out.println();
    }
}

//Задача *:
//        Сделать функцию, снимающую деньги, которая
//        принимает сумму денег, а возвращает булевое значение - успешность выполнения
//        операции. При снятии денег, функция должна распечатывать каким количеством купюр
//        какого номинала выдаётся сумма.
