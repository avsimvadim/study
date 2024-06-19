package tricky_tasks;

import java.util.HashMap;

public class Lemonade_Change_860 {
    public static void main(String[] args) {
        boolean res = lemonadeChange(new int[]{5,5,5,10,5,5,10,20,20,20});
        System.out.println(res);
    }

    public static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> billsNumber = new HashMap<>();
        int[] billsNotes = new int[]{5, 10, 20};

        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                billsNumber.put(5, billsNumber.getOrDefault(5, 0) + 1);
            } else {
                int change = bills[i] - 5;
                int note = billsNotes.length - 1;
                while(note >= 0){
                    int bill = billsNotes[note];

                    if(change - bill >= 0 && billsNumber.get(bill) != null && billsNumber.get(bill) > 0){
                        if(change - bill == 0){
                            billsNumber.put(bill, billsNumber.getOrDefault(bill, 0) - 1);
                            break;
                        }
                        change -= bill;
                        billsNumber.put(bill, billsNumber.getOrDefault(bill, 0) - 1);
                    } else if (change - bill > 0) {
                        note--;
                    } else if(change - bill < 0) {
                        note--;
                    } else {
                        return false;
                    }
                }
                if(note < 0) return false;
                billsNumber.put(bills[i], billsNumber.getOrDefault(bills[i], 0) + 1);
            }
        }
        return true;
    }
}
