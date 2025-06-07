import javax.swing.*;

public class QuickSort {
    public QuickSort(int[] arr, Board board, JFrame frame) {
        new Thread(() -> {
            sort(0, arr.length-1, arr, board, frame);
        }).start();
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

            if(RIndex==0){
                break;
            }

            while(arr[RIndex] > pointer){
                RIndex--;
                if(RIndex==0){
                    break;
                }
            }


            board.index = RIndex;
            frame.repaint();
            try { Thread.sleep(1); } catch (InterruptedException e) {}

            while(arr[LIndex] < pointer){
                LIndex++;
            }

            board.index = LIndex;
            frame.repaint();
            try { Thread.sleep(1); } catch (InterruptedException e) {}

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


        board.index = LIndex;
        frame.repaint();
        try { Thread.sleep(1); } catch (InterruptedException e) {}

        sort(start, LIndex-1, arr, board, frame);
        sort(LIndex+1, end, arr, board, frame);
        frame.repaint();
    }
}
