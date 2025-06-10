import javax.swing.*;

public class CombSort {
    public CombSort(int[] arr, Board board, JFrame frame){

        int gap = arr.length * 10 / 13;
        int i = 0;
        boolean swapped = true;

        while(true){

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

            board.setIndex(i+gap);
            frame.repaint();
            start_time = System.nanoTime();

            while (true) {
                long now = System.nanoTime();
                long time_spent_sleeping_thus_far = now - start_time;
                if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                    break;
                }
            }

            if(i+gap==arr.length){
                if(gap>1){
                    gap = gap * 10 / 13;
                }else if(!swapped) {
                    break;
                }
                i=0;
                swapped=false;
            }

            if(arr[i]>arr[i+gap]){
                int temp = arr[i];
                arr[i] = arr[i+gap];
                arr[i+gap] = temp;
                swapped = true;
            }

            i++;

        }
    }
}
