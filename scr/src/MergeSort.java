import javax.swing.*;

public class MergeSort {
    public MergeSort(int[] arr, Board board, JFrame frame){
        mergeSort(arr,0, arr.length, board, frame);
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
            board.setIndex(i+start);
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
            board.setIndex(i+mid);
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

            board.setIndex(pointer);
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

                board.setIndex(pointer);
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

                board.setIndex(pointer);
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
}
