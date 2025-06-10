import javax.swing.*;

public class InsertionSort {
    public InsertionSort(int[] arr, Board board, JFrame frame){

        int i = 1;

        while (i < arr.length){

            if(i==0){
                i++;
            }

            if(arr[i-1]>arr[i]){

                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                i--;

            }else{
                i++;
            }

            board.setIndex(i);
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
