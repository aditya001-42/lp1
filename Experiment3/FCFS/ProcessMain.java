import java.util.Scanner;

class Process {
    int submission;
    int bursts;
    int turnAround;
    int completionTime;
    int wait;

    Process(int sub, int bur) {
        submission = sub;
        bursts = bur;
    }
}

public class ProcessMain {
    public static void main(String[] args) {
        int wait = 0, x = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = s.nextInt();
        Process[] myProcess = new Process[n];
        System.out.println("Enter Arrival time and bursts:");
        for (int i = 0; i < n; i++) {
            int sub = s.nextInt();
            int bur = s.nextInt();
            myProcess[i] = new Process(sub, bur);
        }
        for (int i = 0; i < myProcess.length; i++) {
            x = x + myProcess[i].bursts;
            myProcess[i].completionTime = x;
            myProcess[i].turnAround = myProcess[i].completionTime - myProcess[i].submission;
            myProcess[i].wait = myProcess[i].turnAround - myProcess[i].bursts;
            System.out.println("Process " + i + ":");
            System.out.println("Turnaround\tCompletion\twaiting");
            System.out.println(myProcess[i].turnAround + "\t\t\t" + myProcess[i].completionTime + "\t\t\t" + myProcess[i].wait);
        }
    }
}

