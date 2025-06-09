import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Window {
    JFrame frame;
    Board board;
    Shuffler shuffler;

    Enum[] sorters = {Sorters.Bubble, Sorters.Shaker, Sorters.Insertion, Sorters.Quick, Sorters.Selection, Sorters.Merge, Sorters.Comb, Sorters.Heap, Sorters.Shell};
    Enum selectedSorter;

    Enum[] dataTypes = {DataType.Triangle, DataType.Line, DataType.Spiral, DataType.ColorCircle};
    Enum selectedDataType;

    Enum[] shuffleTypes = {ShufflingType.Full, ShufflingType.Backward, ShufflingType.FirstHalf, ShufflingType.SecondHalf, ShufflingType.Middle, ShufflingType.CliffRight, ShufflingType.CliffLeft};
    Enum selectedShufflingType;

    int lenght;
    int[] data;
    int pointer;

    public Window(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectedSorter = Sorters.Bubble;
        selectedDataType = DataType.Triangle;
        selectedShufflingType = ShufflingType.Full;

        shuffler = new Shuffler();
        createData(2048);

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
        frame.setSize(1800, 900);
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
        sideController.setLayout(new GridLayout(4, 2, 20,5));
        sideController.setBorder(new EmptyBorder(0, 20, 0, 20));


        JTextField DataLenght = new JTextField();
        sideController.add(DataLenght);


        JButton createData = new JButton("Create Data");
        createData.setAlignmentX(0);
        createData.setAlignmentY(0);
        createData.addActionListener(e->{
            try {
                if (Integer.valueOf(DataLenght.getText())<=2048){
                    createData(Integer.valueOf(DataLenght.getText()));
                }
            }catch(Exception expt){System.out.println(expt.getMessage());}
        });
        sideController.add(createData);


        JComboBox DataTypeBar;

        String[] DataTypeList = new String[dataTypes.length];

        for (int i=0; i < dataTypes.length; i++){ DataTypeList[i] = dataTypes[i].toString();}

        DataTypeBar = new JComboBox(DataTypeList);
        DataTypeBar.addActionListener(e-> {
            try {
                selectedDataType = dataTypes[((JComboBox) e.getSource()).getSelectedIndex()];
                board.graph = selectedDataType;
                frame.getContentPane().revalidate();
                board.repaint();
                frame.repaint();
            }catch(Exception expt) {}
        });
        sideController.add(DataTypeBar);

        sideController.add(new JLabel());

        JComboBox ShufflersTypeBar;
        String shufflersList[] = {};
        shufflersList = new String[shuffleTypes.length];

        for (int i=0; i < shuffleTypes.length; i++){ shufflersList[i] = shuffleTypes[i].toString();}

        ShufflersTypeBar = new JComboBox(shufflersList);
        ShufflersTypeBar.addActionListener(e-> {
            try {
                selectedShufflingType = shuffleTypes[((JComboBox) e.getSource()).getSelectedIndex()];
            }catch(Exception expt) {}
        });
        sideController.add(ShufflersTypeBar);


        JButton shuffle = new JButton("shuffle");
        shuffle.setAlignmentX(0);
        shuffle.setAlignmentY(0);
        shuffle.addActionListener(e->{
            try{
                shuffle();
            }catch(Exception expt){}
        });
        sideController.add(shuffle);


        JComboBox SortersTypeBar;
        String sortersList[] = {};
        sortersList = new String[sorters.length];

        for (int i=0; i < sorters.length; i++){ sortersList[i] = sorters[i].toString();}

        SortersTypeBar = new JComboBox(sortersList);
        SortersTypeBar.addActionListener(e-> {
            try {
                selectedSorter = sorters[((JComboBox) e.getSource()).getSelectedIndex()];
            }catch(Exception expt) {}
        });
        sideController.add(SortersTypeBar);


        JButton sort = new JButton("sort");
        sort.setAlignmentX(0);
        sort.setAlignmentY(0);
        sort.addActionListener(e->{
            try{
                sort();
            }catch(Exception expt){System.out.println(expt.getMessage());}
        });
        sideController.add(sort);


        frame.add(sideController, BorderLayout.EAST);

        frame.repaint();
    }

    private void createData(int lenght){
        try{
            frame.remove(board);
        }catch(Exception expt){System.out.println(expt.getMessage());}

        this.lenght = lenght;
        data = new int[lenght];
        for(int i = 1; i < lenght+1; i++){
            data[i-1] = i;
        }
        board = new Board(data, 0);
        if(board != null){
            System.out.println("Data created new board added");
        }
        frame.add(board);
        board.graph = selectedDataType;
        frame.getContentPane().revalidate();

        board.repaint();
        frame.repaint();
    }



    private void shuffle(){
        new Thread(() -> {
            switch (selectedShufflingType){
                case ShufflingType.Full -> {shuffler.FullShuffle(data, board,frame);}
                case ShufflingType.Backward -> {shuffler.BackwardShuffle(data, board, frame);}
                case ShufflingType.FirstHalf -> {shuffler.FirstHalfShuffle(data, board, frame);}
                case ShufflingType.SecondHalf -> {shuffler.SecondHalfShuffle(data, board, frame);}
                case ShufflingType.Middle -> {shuffler.MiddleHalfShuffle(data, board, frame);}
                case ShufflingType.CliffLeft -> {shuffler.CliffLeft(data, board, frame);}
                case ShufflingType.CliffRight -> {shuffler.CliffRight(data, board, frame);}
                default -> {}
            }
        }).start();

    }

    private void sort(){
        pointer = 0;

        switch (selectedSorter){
            case Sorters.Bubble -> {BubbleSort b = new BubbleSort(data, board, frame);}
            case Sorters.Shaker ->{ShackerSort s = new ShackerSort(data, board, frame);}
            case Sorters.Quick -> {QuickSort q = new QuickSort(data, board, frame);}
            case Sorters.Insertion -> {InsertionSort i = new InsertionSort(data, board, frame);}
            case Sorters.Selection -> {SelectionSort s = new SelectionSort(data, board, frame);}
            case Sorters.Merge -> {MergeSort m = new MergeSort(data, board, frame);}
            case Sorters.Comb -> {CombSort c = new CombSort(data, board, frame);}
            case Sorters.Heap -> {HeapSort h = new HeapSort(data, board, frame);}
            case Sorters.Shell -> {ShellSort s = new ShellSort(data, board, frame);}
            default -> {break;}
        }
    }
}
