# Sorting visualizer written on Java

![Current UI model](https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/programm.png)

## Data sizes


Data sizes are pre setted and can be choosen in first selection box, currently available such sizes as 256, 512, 1024, 2048 and 4096

Unfortunately not all visualisations work correctly with big sized data. Spiral, Circle and BoneFire deals perfectly, due to being polar functions.



## Visualisers


Visualisers can be changed during shuffling or sorting, currently there's 5 types of visualisatin:

<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/triangle.png" alt="Distortin shuffler" style="width:50%; height:auto;">
<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/line.png" alt="Distortin shuffler" style="width:50%; height:auto;">
<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/spiral.png" alt="Distortin shuffler" style="width:50%; height:auto;">
<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/triangle.png" alt="Distortin shuffler" style="width:50%; height:auto;">
<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/function.png" alt="Distortin shuffler" style="width:50%; height:auto;">




## Shufflers


Thre're multiple shuffling methods

- 4 `random` shufflers such as Full, FirstHalf, SecondHalf and Middle. This shufflers shuffle randomly different parts of dataset.
- 5 `displace` shufflers change places of set elements, putting them in different patterns.
> Distortin shuffler randomly calls other `displace` shufflers, creating unusual paterns.



<img src="https://github.com/ArtKhant/Sorting-Visualizer/blob/main/images/distortion.png" alt="Distortin shuffler" style="width:50%; height:auto;">



## Sorters


Currently 9 sorting methods asdded such as:
- Bubble
- Shaker
- Insertion
- Quik
- Selection
- Merge
- Comb
- Heap
- Shell
- Radix LSD
