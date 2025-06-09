import javax.swing.*;

public class ShackerSort {
    public ShackerSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {

            boolean inProccess = true;
            int start = 0;
            int end = arr.length;


            while(inProccess){
                inProccess = false;

                for (int i = start; i < end - 1; ++i)
                {
                    board.index = i;
                    frame.repaint();

                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        inProccess = true;
                    }
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

                if (inProccess == false) {
                    break;
                }


                inProccess = false;

                end --;

                for (int i = end - 1; i >= start; i--)
                {
                    board.index = i;
                    frame.repaint();

                    if (arr[i] > arr[i + 1])
                    {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        inProccess = true;
                    }

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

                start++;

            }


            done(board, frame, arr.length);

        }).start();
    }

    private void done(Board board, JFrame frame, int lenght){
        new Thread(() -> {
            board.ready = true;

            for (int i = 0; i < lenght; i++) {
                board.index = i;
                frame.repaint(); // This is safe because repaint() is thread-safe

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // Handle interruption
                }
            }

            board.ready = false;
            frame.repaint();
        }).start();

    }
}
