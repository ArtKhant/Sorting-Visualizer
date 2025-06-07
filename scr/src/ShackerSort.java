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
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        // Handle interruption
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

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        // Handle interruption
                    }

                }

                start++;

            }




        }).start();
    }
}
