import javax.swing.*;

public class BubbleSort {

    public BubbleSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {
            int i, j, temp,  n;
            boolean swapped;
            n = arr.length;


            for (i = 0; i < n - 1; i++) {
                swapped = false;
                board.index = i;
                frame.repaint();

                for (j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap arr[j] and arr[j+1]
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }

                    board.index = j;
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
                if (swapped == false) {
                    break;
                }
            }

            done(board, frame, arr.length);

        }).start();
    }

    private void done(Board board, JFrame frame, int lenght){
        board.ready = true;

        for (int i = 0; i < lenght; i++) {
            board.index = i;
            frame.repaint();

            try {Thread.sleep(1);} catch (InterruptedException e) {}


        }
        board.ready = false;
        frame.repaint();
    }
}
