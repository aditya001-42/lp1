import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalReplacement {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        boolean isFull = false;
        int buffer[];
        int reference[];

        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());

        System.out.println("Please enter the length of the Reference string: ");
        ref_len = Integer.parseInt(br.readLine());

        reference = new int[ref_len];
        buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;

        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        for (int i = 0; i < ref_len; i++) {
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                if (isFull) {
                    int index[] = new int[frames];
                    for (int j = 0; j < frames; j++) {
                        boolean found = false;
                        for (int k = i + 1; k < ref_len; k++) {
                            if (buffer[j] == reference[k]) {
                                index[j] = k;
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            index[j] = ref_len; // Set index to maximum possible value if not found in future
                        }
                    }
                    int max = index[0];
                    pointer = 0;
                    for (int j = 0; j < frames; j++) {
                        if (index[j] > max) {
                            max = index[j];
                            pointer = j;
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                if (!isFull) {
                    pointer++;
                    if (pointer == frames) {
                        pointer = 0;
                        isFull = true;
                    }
                }
            }
        }

        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
        System.out.println("The number of Faults: " + fault);
    }
}

