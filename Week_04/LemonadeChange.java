package wb.test;

public class LemonadeChange {
    // public boolean change(int bill, Map<Integer, Integer> map) {
    //     if (bill == 5 || bill == 0) {
    //         return true;
    //     }
    //     if (bill == 10) {
    //         if (map.getOrDefault(5, 0) > 0) {
    //             map.put(5, map.get(5) - 1);
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }
    //     if (bill == 20) {
    //         if (map.getOrDefault(10, 0) > 0) {
    //             map.put(10, map.get(10) - 1);
    //             return change(10, map);
    //         } else if (map.getOrDefault(5, 0) >= 3) {
    //             map.put(5, map.get(5) - 3);
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }

    //     return false;
    // }

    // public boolean lemonadeChange(int[] bills) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < bills.length; i++) {
    //         if (!change(bills[i], map)) {
    //             return false;
    //         }
    //         map.put(bills[i], map.getOrDefault(bills[i], 0) + 1);
    //     }

    //     return true;
    // }

    //简化做法
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
