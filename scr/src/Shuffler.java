import javax.swing.*;
import java.util.Random;
public class Shuffler {
    public Shuffler(){
    }

    public void FullShuffle(int[] data, Board board, JFrame frame){

        int mem;
        Random r = new Random();

        for (int i = 1; i < data.length; i++) {

            int j = r.nextInt(0, i);
            mem = data[i];
            data[i] = data[j];
            data[j] = mem;

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

    public void BackwardShuffle(int[] data, Board board, JFrame frame){

        for(int i = 0; i<data.length/2; i++){

            int temp = data[i];
            data[i] = data[data.length-i-1];
            data[data.length-i-1] = temp;

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

    public void FirstHalfShuffle(int[] data, Board board, JFrame frame){

        int mem;
        Random r = new Random();

        for (int i = 1; i < data.length/2; i++) {

            int j = r.nextInt(0, i);
            mem = data[i];
            data[i] = data[j];
            data[j] = mem;

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

    public void SecondHalfShuffle(int[] data, Board board, JFrame frame){

        int mem;
        Random r = new Random();

        for (int i = data.length/2+1; i < data.length; i++) {

            int j = r.nextInt(data.length/2, i);
            mem = data[i];
            data[i] = data[j];
            data[j] = mem;

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

    public void MiddleHalfShuffle(int[] data, Board board, JFrame frame){

        int mem;
        Random r = new Random();

        for (int i = data.length/3+1; i < data.length*2/3; i++) {

            int j = r.nextInt(data.length/3, i);
            mem = data[i];
            data[i] = data[j];
            data[j] = mem;

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

    public void CliffRight(int[] data, Board board, JFrame frame){

        for(int i = 0; i<data.length/2; i++){

            int temp = data[i];
            data[i] = data[data.length/2+i];
            data[data.length/2+i] = temp;

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

        for(int i = data.length/2; i<data.length*3/4; i++){
            int temp = data[i];
            data[i] = data[data.length-i-1+data.length/2];
            data[data.length-i-1+data.length/2] = temp;

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

    public void CliffLeft(int[] data, Board board, JFrame frame){

        CliffRight(data, board, frame);
        BackwardShuffle(data, board, frame);

    }
}
