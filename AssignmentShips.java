import java.util.Arrays;

public class AssignmentShips{

     public static void main(String []args){
        
        int[] ships = {50, 11, 2, 2, 11, 5, 9, 1};
        int i = ships.length - 1, k = ships.length - 1, days = 0;

		// Do this until we achieve descending order of ships
        do {
            if (i <= 0) {
                i = k;
                days++;
                System.out.println( "ships -> " + Arrays.toString(ships) + "\n Ships stop destroying after Days -> " + days);
            }

            if (ships[i] > ships[i - 1]) {
				// Destroy ship 
                ships = removeIndex(i, ships);
				// assign value to check for new ships
                i = i - 2;
                k = ships.length - 1;
            } else {
                i--;
            }
        } while (!isDescendingOrder(ships));
		// Ships destroy if right value is greater means that list should be in descending order.
        days++;
        System.out.println( "ships -> " + Arrays.toString(ships) + "\n Ships stop destroying after Days -> " + days);
     }
     
     private static boolean isDescendingOrder(int[] ships) {
        for (int i = 0; i < ships.length - 1; i++) {
            if (ships[i] < ships[i + 1]) {
                return false;
            }
        }
        return true;
    }
     
     private static int[] removeIndex(int j, int[] ships) {

        int[] proxyArray = new int[ships.length - 1];
        // copy all the elements in the original to proxy array except the one at index
        for (int l = 0, k = 0; l < ships.length; l++) {
            // check if index is crossed, continue without copying
            if (l == j) {
                continue;
            }
            // else copy the element
            proxyArray[k++] = ships[l];
        }
        return proxyArray;
    }
}