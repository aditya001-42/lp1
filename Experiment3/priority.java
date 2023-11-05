import java.util.Scanner;

public class priority {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int x, n, p[], pp[], bt[], w[], t[], awt, atat, i;

        p = new int[10];
        pp = new int[10];
        bt = new int[10];
        w = new int[10];
        t = new int[10];

   //n is number of process
   //p is process
   //pp is process priority
   //bt is process burst time
   //w is wait time
   // t is turnaround time
   //awt is average waiting time
   //atat is average turnaround time


        System.out.print("Enter the number of processes: ");
        n = s.nextInt();
        System.out.println("\nEnter burst time and priorities: \n");

        for (i = 0; i < n; i++) {
            System.out.print("Process[" + (i + 1) + "]: ");
            bt[i] = s.nextInt();
            pp[i] = s.nextInt();
            p[i] = i + 1;
        }

        // Sorting on the basis of priority
        for (i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pp[i] < pp[j]) {
                    x = pp[i];
                    pp[i] = pp[j];
                    pp[j] = x;
                    x = bt[i];
                    bt[i] = bt[j];
                    bt[j] = x;
                    x = p[i];
                    p[i] = p[j];
                    p[j] = x;
                }
            }
        }

        w[0] = 0;
        awt = 0;
        t[0] = bt[0];
        atat = t[0];

        for (i = 1; i < n; i++) {
            w[i] = t[i - 1];
            awt += w[i];
            t[i] = w[i] + bt[i];
            atat += t[i];
        }

        // Displaying the process
        System.out.println("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time \t Priority");
        for (i = 0; i < n; i++)
            System.out.println("   " + p[i] + "\t\t   " + bt[i] + "\t\t     " + w[i] + "\t\t     " + t[i] + "\t\t     " + pp[i]);

        awt /= n;
        atat /= n;

        System.out.println("\nAverage Wait Time: " + awt);
        System.out.println("Average Turn Around Time: " + atat);

    }
}

