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

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        // Handle interruption
                    }



                }
                if (swapped == false) {
                    break;
                }
            }



        }).start();
    }
}
