import java.util.Scanner;

public class DistanceVectorRouting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int no = input.nextInt();

        int[][] dm = new int[no][no];

        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < no; i++) {
            for (int j = 0; j < no; j++) {
                dm[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < no; i++) {
            System.out.println("\nRouting Table for Node " + (i + 1) + ":\n");
            System.out.println("Node   Distance   Next Hop");

            for (int j = 0; j < no; j++) {
                if (i == j) {
                    System.out.println("N" + (j + 1) + "    0       N" + (j + 1));
                } else {
                    int minDistance = dm[i][j];
                    int nextHop = j + 1;

                    for (int k = 0; k < no; k++) {
                        if (k != i && dm[i][k] > 0 && dm[k][j] > 0 && (dm[k][j] + dm[i][k] < minDistance)) {
                            minDistance = dm[k][j] + dm[i][k];
                            nextHop = k + 1;
                        }
                    }

                    System.out.println("N" + (j + 1) + "    " + minDistance + "       N" + nextHop);
                }
            }
        }
    }
}
