package DZ2;
import java.util.Arrays;
public class TesterClass {
    public static void main(String[] args) {
        int arrey[][] = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16},{16,17,0,0} };

        System.out.println(arrey.length);
        System.out.println(arrey[0].length);
        System.out.println(Arrays.toString(arrey[1]));
        System.out.println(arrey[1][3]);
    }
}



