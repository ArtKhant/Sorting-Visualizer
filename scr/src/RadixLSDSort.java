import javax.swing.*;

public class RadixLSDSort {
    public RadixLSDSort(int[] arr, Board board, JFrame frame){

        boolean sorting = true;
        int pointer = 0;
        int[] base_0 = new int[0];
        int[] base_1 = new int[0];
        int[] base_2 = new int[0];
        int[] base_3 = new int[0];
        int[] base_4 = new int[0];
        int[] base_5 = new int[0];
        int[] base_6 = new int[0];
        int[] base_7 = new int[0];
        int[] base_8 = new int[0];
        int[] base_9 = new int[0];
        int[] subArraySizes;

        while(true){
            //finding size of sub arrays
            sorting = false;
            subArraySizes = new int[10];

            for(int i = 0; i < arr.length; i++){

                int digit = (int)((arr[i]/Math.pow(10, pointer)) % 10);

                if(digit != 0 && !sorting){
                    sorting = true;
                }

                subArraySizes[digit] +=1;


                draw(i, board, frame);

            }

            if(!sorting){
                break;
            }


            //creating sub arrays
            for(int i = 0; i < 10; i++){

                switch (i){

                    case 0 ->{base_0 = new int[subArraySizes[i]];}
                    case 1 ->{base_1 = new int[subArraySizes[i]];}
                    case 2 ->{base_2 = new int[subArraySizes[i]];}
                    case 3 ->{base_3 = new int[subArraySizes[i]];}
                    case 4 ->{base_4 = new int[subArraySizes[i]];}
                    case 5 ->{base_5 = new int[subArraySizes[i]];}
                    case 6 ->{base_6 = new int[subArraySizes[i]];}
                    case 7 ->{base_7 = new int[subArraySizes[i]];}
                    case 8 ->{base_8 = new int[subArraySizes[i]];}
                    case 9 ->{base_9 = new int[subArraySizes[i]];}

                }

            }


            //filling sub arrays
            int base_0_index = 0;
            int base_1_index = 0;
            int base_2_index = 0;
            int base_3_index = 0;
            int base_4_index = 0;
            int base_5_index = 0;
            int base_6_index = 0;
            int base_7_index = 0;
            int base_8_index = 0;
            int base_9_index = 0;

            for(int i = 0; i < arr.length; i++){

                int digit = (int)((arr[i]/Math.pow(10, pointer)) % 10);

                switch (digit){

                    case 0 ->{base_0[base_0_index] = arr[i]; base_0_index++;}
                    case 1 ->{base_1[base_1_index] = arr[i]; base_1_index++;}
                    case 2 ->{base_2[base_2_index] = arr[i]; base_2_index++;}
                    case 3 ->{base_3[base_3_index] = arr[i]; base_3_index++;}
                    case 4 ->{base_4[base_4_index] = arr[i]; base_4_index++;}
                    case 5 ->{base_5[base_5_index] = arr[i]; base_5_index++;}
                    case 6 ->{base_6[base_6_index] = arr[i]; base_6_index++;}
                    case 7 ->{base_7[base_7_index] = arr[i]; base_7_index++;}
                    case 8 ->{base_8[base_8_index] = arr[i]; base_8_index++;}
                    case 9 ->{base_9[base_9_index] = arr[i]; base_9_index++;}

                }

                draw(i, board, frame);

            }

            //pasting sub arrays to main array

            int index = 0;
            for(int i = 0; i < base_0.length; i++){
                arr[i] = base_0[i];

                draw(i+index, board, frame);
            }
            index += base_0.length;

            for(int i = 0; i < base_1.length; i++){
                arr[i+index] = base_1[i];

                draw(i+index, board, frame);
            }
            index += base_1.length;

            for(int i = 0; i < base_2.length; i++){
                arr[i+index] = base_2[i];

                draw(i+index, board, frame);
            }
            index += base_2.length;

            for(int i = 0; i < base_3.length; i++){
                arr[i+index] = base_3[i];

                draw(i+index, board, frame);
            }
            index += base_3.length;

            for(int i = 0; i < base_4.length; i++){
                arr[i+index] = base_4[i];

                draw(i+index, board, frame);
            }
            index += base_4.length;

            for(int i = 0; i < base_5.length; i++){
                arr[i+index] = base_5[i];

                draw(i+index, board, frame);
            }
            index += base_5.length;

            for(int i = 0; i < base_6.length; i++){
                arr[i+index] = base_6[i];

                draw(i+index, board, frame);
            }
            index += base_6.length;

            for(int i = 0; i < base_7.length; i++){
                arr[i+index] = base_7[i];

                draw(i+index, board, frame);
            }
            index += base_7.length;

            for(int i = 0; i < base_8.length; i++){
                arr[i+index] = base_8[i];

                draw(i+index, board, frame);
            }
            index += base_8.length;

            for(int i = 0; i < base_9.length; i++){
                arr[i+index] = base_9[i];

                board.setIndex(i);
                frame.repaint();

                draw(i+index, board, frame);
            }

            pointer +=1;
        }
    }

    private void draw(int index, Board board, JFrame frame){
        board.setIndex(index);
        frame.repaint();
        long delay_in_nanoseconds = 1000000;
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
