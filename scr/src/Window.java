import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window {
    JFrame frame;
    Board board;

    Enum[] sorters = {Sorters.Bubble, Sorters.Shaker, Sorters.Quick};
    Enum selectedSorter;

    Enum[] dataTypes = {DataType.Triangle, DataType.Circle};
    Enum selectedDataType;

    int lenght;
    int[] data;
    int pointer;

    public Window(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectedSorter = Sorters.Bubble;
        selectedDataType = DataType.Triangle;

        createData(128);

        board = new Board(data, 0);


    }

    public void show(){
        frame.setVisible(true);
        System.out.println("window is visible");
    }

    public void hide(){
        frame.setVisible(false);
        System.out.println("window is invisible");
    }

    public void create(){
        frame.setSize(900, 900);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        LoadInterface();
        System.out.println("window class created");
    }

    public void kill(){
        frame.dispose();
        System.out.println("window closed");
    }

    public void clear(){
        frame.getContentPane().removeAll();
        frame.repaint();
        System.out.println("window cleared");
    }

    public void LoadInterface(){
        frame.add(board, BorderLayout.CENTER);

        JPanel sideController = new JPanel();
        sideController.setLayout(new GridLayout(7, 1, 0,5));

        JLabel top = new JLabel("Sorter controlls");
        sideController.add(top);


        JComboBox SortersTypeBar;
        String data[] = {};
        data = new String[sorters.length];

        for (int i=0; i < sorters.length; i++){ data[i] = sorters[i].toString();}

        SortersTypeBar = new JComboBox(data);
        SortersTypeBar.addActionListener(e-> {
            try {
                selectedSorter = sorters[((JComboBox) e.getSource()).getSelectedIndex()];
            }catch(Exception expt) {}
        });
        sideController.add(SortersTypeBar);



        JComboBox DataTypeBar;

        data = new String[dataTypes.length];

        for (int i=0; i < dataTypes.length; i++){ data[i] = dataTypes[i].toString();}

        DataTypeBar = new JComboBox(data);
        DataTypeBar.addActionListener(e-> {
            try {
                selectedDataType = dataTypes[((JComboBox) e.getSource()).getSelectedIndex()];
            }catch(Exception expt) {}
        });
        sideController.add(DataTypeBar);


        JTextField DataLenght = new JTextField();
        sideController.add(DataLenght);


        JButton createData = new JButton("Create Data");
        createData.setAlignmentX(0);
        createData.setAlignmentY(0);
        createData.addActionListener(e->{});
        sideController.add(createData);


        JButton shuffle = new JButton("shuffle");
        shuffle.setAlignmentX(0);
        shuffle.setAlignmentY(0);
        shuffle.addActionListener(e->{
            try{
                shuffle();
            }catch(Exception expt){}
        });
        sideController.add(shuffle);


        JButton sort = new JButton("sort");
        sort.setAlignmentX(0);
        sort.setAlignmentY(0);
        sort.addActionListener(e->{
            try{
                if (sort()) {
                    //done();
                }
            }catch(Exception expt){}
        });
        sideController.add(sort);


        frame.add(sideController, BorderLayout.EAST);
    }

    private void createData(int lenght){
        this.lenght = lenght;
        data = new int[lenght];
        for(int i = 0; i < lenght; i++){
            data[i] = i;
        }
    }

    private void done(){
        new Thread(() -> {
            board.ready = true;

            for (int i = 0; i < lenght; i++) {
                board.index = i;
                frame.repaint(); // This is safe because repaint() is thread-safe

                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    // Handle interruption
                }
            }

            board.ready = false;
            frame.repaint();
        }).start();

    }

    private void shuffle(){
        new Thread(() -> {
            int mem;
            Random r = new Random();
            for (int i = 1; i < lenght; i++) {
                int j = r.nextInt(0, i);
                mem = data[i];
                data[i] = data[j];
                data[j] = mem;

                board.index = i;

                frame.repaint(); // This is safe because repaint() is thread-safe

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // Handle interruption
                }
            }
        }).start();

    }

    private boolean sort(){
        pointer = 0;

        switch (selectedSorter){
            case Sorters.Bubble -> {BubbleSort b = new BubbleSort(data, board, frame); return true;}
            case Sorters.Shaker ->{ShackerSort s = new ShackerSort(data, board, frame); return true;}
            case Sorters.Quick -> {QuickSort q = new QuickSort(data, board, frame); return true;}
            default -> {return false;}
        }
    }
}
