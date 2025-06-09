import javax.swing.*;

public class ShellSort {

    //not 100% shel sort, but test show that 5~6 smoothes are enough to start ordinary insertion sort
    public ShellSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {
            //shel part
            int i;
            int j = 0;
            int gap =(int) (arr.length/2.3);
            boolean swapped = true;
            while(swapped){
                if(gap<1){
                    gap=1;
                }
                if(gap==1){
                    swapped = false;
                }

                i=j;
                while (i + gap < arr.length){
                    if(i+gap>=arr.length){
                        break;
                    }
                    if(arr[i]>arr[i+gap]){
                        int temp = arr[i+gap];
                        arr[i+gap] = arr[i];
                        arr[i] = temp;
                        swapped = true;
                        if(i-gap>0){
                            i-=gap;
                        }
                    }else{
                        i+=gap;
                    }
                    board.index = i;
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
                    board.index = gap;
                    frame.repaint();
                    start_time = System.nanoTime();
                    while (true) {
                        long now = System.nanoTime();
                        long time_spent_sleeping_thus_far = now - start_time;
                        if (time_spent_sleeping_thus_far >= delay_in_nanoseconds) {
                            break;
                        }
                    }

                }
                if(j == gap){
                    gap = (int) (gap/2.3);
                    j=0;
                }else{
                    j++;
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
