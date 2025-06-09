import javax.swing.*;

public class MergeSort {
    public MergeSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {
            System.out.println("start");
            mergeSort(arr,0, arr.length, board, frame);

            done(board, frame, arr.length);

        }).start();
    }

    private void mergeSort(int[] arr, int start, int end, Board board, JFrame frame) {
        if (end - start <= 1) {
            return;
        }
        int mid = (end + start) / 2 ;
        mergeSort(arr, start, mid, board, frame);
        mergeSort(arr, mid, end, board, frame);

        int[] arr1 = new int[mid-start];
        int[] arr2 = new int[end-mid];

        for (int i = 0; i < mid-start; i++) {
            arr1[i] = arr[i+start];
            board.index = i+start;
            frame.repaint();
            long delay_in_nanoseconds = 100000;
            long start_time = System.nanoTime();
            while (true) {
                long now = System.nanoTime();
                long time_spent_sleeping_thus_far = now - start_time;
                if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                    break;
                }
            }
        }

        for (int i = 0; i < end-mid; i++) {
            arr2[i] = arr[i+mid];
            board.index = i+mid;
            frame.repaint();
            long delay_in_nanoseconds = 100000;
            long start_time = System.nanoTime();
            while (true) {
                long now = System.nanoTime();
                long time_spent_sleeping_thus_far = now - start_time;
                if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                    break;
                }
            }
        }


        int i = 0;
        int j = 0;
        int pointer = start;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]) {
                arr[pointer] = arr1[i];
                i++;
                pointer++;
            } else {
                arr[pointer] = arr2[j];
                j++;
                pointer++;
            }

            board.index = pointer;
            frame.repaint();
            long delay_in_nanoseconds = 100000;
            long start_time = System.nanoTime();
            while (true) {
                long now = System.nanoTime();
                long time_spent_sleeping_thus_far = now - start_time;
                if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                    break;
                }
            }
        }
        if(i<arr1.length){
            while (i<arr1.length){
                arr[pointer] = arr1[i];
                pointer++;
                i++;

                board.index = pointer;
                frame.repaint();
                long delay_in_nanoseconds = 100000;
                long start_time = System.nanoTime();
                while (true) {
                    long now = System.nanoTime();
                    long time_spent_sleeping_thus_far = now - start_time;
                    if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                        break;
                    }
                }
            }
        }else{
            while (j<arr2.length){
                arr[pointer] = arr2[j];
                pointer++;
                j++;

                board.index = pointer;
                frame.repaint();
                long delay_in_nanoseconds = 100000;
                long start_time = System.nanoTime();
                while (true) {
                    long now = System.nanoTime();
                    long time_spent_sleeping_thus_far = now - start_time;
                    if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                        break;
                    }
                }
            }
        }
    }
    private void done(Board board, JFrame frame, int lenght){
        new Thread(() -> {
            board.ready = true;

            for (int i = 0; i < lenght; i++) {
                board.index = i;
                frame.repaint(); // This is safe because repaint() is thread-safe

                long delay_in_nanoseconds = 100000;
                long start_time = System.nanoTime();
                while (true) {
                    long now = System.nanoTime();
                    long time_spent_sleeping_thus_far = now - start_time;
                    if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                        break;
                    }
                }
            }

            board.ready = false;
            frame.repaint();
        }).start();

    }

}
