import java.util.Scanner;

public class TestClass2 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int wtime[], btime[], rtime[], num, quantum, total;

        wtime = new int[10];
        btime = new int[10];
        rtime = new int[10];

        System.out.print("Enter number of processes(MAX 10): ");
        num = s.nextInt();

        System.out.println("Enter burst time:");
        for (int i = 0; i < num; i++) {
            System.out.print("P[" + (i + 1) + "]: ");
            btime[i] = s.nextInt();
            rtime[i] = btime[i];
            wtime[i] = 0;
        }

        System.out.print("\nEnter quantum: ");
        quantum = s.nextInt();

        int rp = num;
        int i = 0;
        int time = 0;

        System.out.print("Gantt Chart: 0");

        while (rp != 0) {
            if (rtime[i] > quantum) {
                rtime[i] = rtime[i] - quantum;
                System.out.print(" | P[" + (i + 1) + "] | ");
                time += quantum;
                System.out.print(time);
            } else if (rtime[i] <= quantum && rtime[i] > 0) {
                time += rtime[i];
                rtime[i] = 0;
                System.out.print(" | P[" + (i + 1) + "] | ");
                wtime[i] = time - btime[i];
                rp--;
                System.out.print(time);
            }

            i++;
            if (i == num) {
                i = 0;
            }
        }

        int totalWaitingTime = 0;
        for (int j = 0; j < num; j++) {
            totalWaitingTime += wtime[j];
        }

        double avgWaitingTime = (double) totalWaitingTime / num;
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
    }
}

