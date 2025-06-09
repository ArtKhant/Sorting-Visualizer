import javax.swing.*;

public class HeapSort {
    public HeapSort(int[] arr, Board board, JFrame frame){
        new Thread(() -> {
            //heapification
            boolean swapped = true;
            int pointer = 0;
            while (swapped) {
                swapped = false;
                for (int i = (arr.length - 1); i >= 1; i--) {
                    if (i % 2 == 0) {
                        if (arr[i] > arr[i - 1] && arr[i] > arr[i / 2 - 1]) {
                            int temp = arr[i / 2 - 1];
                            arr[i / 2 - 1] = arr[i];
                            arr[i] = temp;
                            swapped = true;
                        }
                    } else {
                        if (arr[i] > arr[(i - 1) / 2]) {
                            int temp = arr[(i - 1) / 2];
                            arr[(i - 1) / 2] = arr[i];
                            arr[i] = temp;
                            swapped = true;
                        }
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
                }
            }

            //sorting
            for(int j = arr.length-1; j>=0; j--){
                swapped = true;
                pointer = 0;
                while(swapped){
                    if(2*pointer+1==j){
                        if(arr[pointer]<arr[2*pointer+1]){
                            int temp = arr[2*pointer+1];
                            arr[2*pointer+1] = arr[pointer];
                            arr[pointer] = temp;
                            pointer = 2*pointer+1;
                        }
                        else{
                            break;
                        }
                    }if(2*pointer+2 > j || 2*pointer+1 > j){
                        break;
                    }
                    else if(arr[2*pointer+2]<arr[2*pointer+1]){
                        if(arr[pointer]<arr[2*pointer+1]){
                            int temp = arr[2*pointer+1];
                            arr[2*pointer+1] = arr[pointer];
                            arr[pointer] = temp;
                            pointer = 2*pointer+1;
                        }
                        else{
                            break;
                        }
                    } else{
                        if(arr[pointer]<arr[2*pointer+2]){
                            int temp = arr[2*pointer+2];
                            arr[2*pointer+2] = arr[pointer];
                            arr[pointer] = temp;
                            pointer = 2*pointer+2;
                        }else{
                            break;
                        }
                    }

                    board.index = pointer;
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

                int temp = arr[j];
                arr[j] = arr[0];
                arr[0] = temp;
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
