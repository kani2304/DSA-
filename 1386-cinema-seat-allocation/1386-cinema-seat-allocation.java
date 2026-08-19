import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();
        
        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            reserved.computeIfAbsent(seat[0], x -> new HashSet<>()).add(seat[1]);
        }
        
        int res = 0;
        
        for (int row : reserved.keySet()) {
            Set<Integer> seats = reserved.get(row);
            
            boolean left = true;   // seats 2–5
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                    break;
                }
            }
            
            boolean right = true;  // seats 6–9
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                    break;
                }
            }
            
            boolean middle = true; // seats 4–7
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                    break;
                }
            }
            
            if (left && right) {
                res += 2;
            } else if (left || right || middle) {
                res += 1;
            }
        }
        
        // Rows without any reserved seats can fit 2 families
        res += (n - reserved.size()) * 2;
        
        return res;
    }
}