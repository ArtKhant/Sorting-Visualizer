import javax.swing.*;

public class QuickSort {
    public QuickSort(int[] arr, Board board, JFrame frame) {
        sort(0, arr.length-1, arr, board, frame);
    }

    private void sort(int start, int end, int[] arr, Board board, JFrame frame){
        if(start >= end){
            return;
        }

        int pointer;
        int a = arr[start];
        int b = arr[(start + end)/2];
        int c = arr[end];


        //take pivot
        if(((a<b) && (a>c)) || ((a>b) && (a<c))){
            pointer = a;
            arr[start] = c;
        } else if (((b<a) && (b>c)) || ((b>a) && (b<c))) {
            pointer = b;
            arr[(start + end)/2] = c;
        }else{
            pointer = c;
        }

        arr[end] = pointer;
        int LIndex = start;
        int RIndex = end-1;

        while(LIndex <= RIndex){

            if(RIndex < start){
                break;
            }

            while(arr[RIndex] > pointer){

                board.setIndex(RIndex);
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

                RIndex--;

                if(RIndex < start){
                    break;
                }
            }

            if(RIndex == start && arr[RIndex] > pointer){
                break;
            }

            while(arr[LIndex] < pointer){

                board.setIndex(LIndex);
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

                LIndex++;
            }

            if(LIndex < RIndex) {
                int temp = arr[RIndex];
                arr[RIndex] = arr[LIndex];
                arr[LIndex] = temp;

                RIndex--;
                LIndex++;
            }
        }

        arr[end] = arr[LIndex];
        arr[LIndex] = pointer;

        board.setIndex(LIndex);
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

        sort(start, LIndex-1, arr, board, frame);
        sort(LIndex+1, end, arr, board, frame);
        frame.repaint();
    }
}
