import java.util.*;

public class FIFO {
    static Scanner scanner = new Scanner(System.in);

    public int FIFOImplementation(int pages[], int capacity) {
        int pageFaults = 0;
        HashSet<Integer> currentSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < pages.length; i++) {
            if (currentSet.size() < capacity) {
                if (!currentSet.contains(pages[i])) {
                    // Page Fault: Add the page to the set and queue
                    currentSet.add(pages[i]);
                    queue.add(pages[i]);
                    pageFaults++;
                } else {
                    // Page Hit: Do nothing, page is already in memory
                }
            } else {
                if (!currentSet.contains(pages[i])) {
                    // Page Fault: Remove the first page from the queue and set,
                    // then add the new page to the set and queue
                    int removedPage = queue.poll();
                    currentSet.remove(removedPage);
                    currentSet.add(pages[i]);
                    queue.add(pages[i]);
                    pageFaults++;
                } else {
                    // Page Hit: Do nothing, page is already in memory
                }
            }

            // Print current state of frames after each insertion
            System.out.print("Frames: ");
            for (int page : queue) {
                System.out.print(page + " ");
            }
            System.out.println();
        }
        return pageFaults;
    }

    public static void main(String[] args) {
        int capacity, n, pages[];
        FIFO fifo = new FIFO();

        System.out.print("Enter capacity of page frame: ");
        capacity = scanner.nextInt();

        System.out.print("Enter number of page sequence: ");
        n = scanner.nextInt();

        pages = new int[n];

        System.out.print("Enter values (space separated): ");
        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        int pageFaults = fifo.FIFOImplementation(pages, capacity);
        System.out.println("Page Faults: " + pageFaults);
    }
}

