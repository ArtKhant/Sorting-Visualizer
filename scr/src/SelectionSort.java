import javax.swing.*;

public class SelectionSort {
    public SelectionSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {


            int i = 0;
            int min = arr[0];
            int minIndex = 0;
            int pointer = 0;
            while (pointer < arr.length-1){
                board.index = i;
                frame.repaint();
                long delay_in_nanoseconds = 10000;
                long start_time = System.nanoTime();
                while (true) {
                    long now = System.nanoTime();
                    long time_spent_sleeping_thus_far = now - start_time;
                    if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                        break;
                    }
                }

                i++;

                if(arr[minIndex]>arr[i]){
                    min = arr[i];
                    minIndex = i;
                }

                if(i == arr.length-1){
                    arr[minIndex] = arr[pointer];
                    arr[pointer] = min;
                    pointer++;
                    i=pointer;
                    minIndex = pointer;
                    min = arr[minIndex];
                }


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
