import java.util.Random;
import java.util.Arrays;

public class SortTools {

    public static int[] createSequenceInc(int n) {
        int[] arr = {};
        if (n > 0) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
        }
        //System.out.println("SequenceInc: " + Arrays.toString(arr));
        return arr;
    }

    public static int[] createSequenceDec(int n) {
        int[] arr = {};
        if (n > 0) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = n - i;
            }
        }
        //System.out.println("SequenceDec: " + Arrays.toString(arr));
        return arr;
    }

    public static int[] createSequenceRand(int n) {
        int[] arr = {};
        if (n > 0) {
            arr = new int[n];
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                int value = rand.nextInt(n) + 1;
                arr[i] = value;
            }
        }
        //System.out.println("SequenceRand: " + Arrays.toString(arr));
        return arr;
    }

    public static int[] createSequenceAlt(int n) {
        int[] arr = {};
        if (n > 0) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i%2 == 0) arr[i] = 1;
                else arr[i] = 2;
            }
        }
        //System.out.println("SequenceAlt: " + Arrays.toString(arr));
        return arr;
    }

    public static int[] insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int val = a[j];
            int i = j - 1;
            while(i >= 0 && a[i] > val) {
                a[i+1] = a[i];
                i -= 1;
            }
            a[i+1] = val;
        }
        //System.out.println("insertionSort: " + Arrays.toString(a));
        return a;
    }

    public static <T extends Comparable<T>> T[] insertionSortGen(T[] GenArray) {
        for (int j = 1; j < GenArray.length; j++) {
            T val = GenArray[j];
            int i = j - 1;
            while(i >= 0 && GenArray[i].compareTo(val) > 0) {
                GenArray[i+1] = GenArray[i];
                i -= 1;
            }
            GenArray[i+1] = val;
        }
        //System.out.println("insertionSortGen: " + Arrays.toString(GenArray));
        return GenArray;
    }

    public static int[] bubbleSort(int[] a) {
        for (int i=a.length; i >= 1; i--) {
            for (int j = 0; j <= i-2; j++) {
                if (a[j] > a[j+1]) {
                    int s = a[j];
                    a[j] = a[j+1];
                    a[j+1] = s;
                }
            }
        }
        //System.out.println("bubbleSort: " + Arrays.toString(a));
        return a;
    }

    public static int[] bubbleSortNew(int[] a) {
        for (int i=a.length; i >= 1; i--) {
            for (int j = 0; j <= i-10; j++) {
                int[] temp = Arrays.copyOfRange(a,j,j+10);
                insertionSort(temp);
                for (int k = 0; k < 10; k++) {
                    a[j+k] = temp[k];
                }
            }
        }
        //System.out.println("bubbleSortNew: " + Arrays.toString(a));
        return a;
    }

    public static <T extends Comparable<T>> T[] bubbleSortGen(T[] GenArray) {
        for (int i=GenArray.length; i >= 1; i--) {
            for (int j = 0; j <= i-2; j++) {
                if (GenArray[j].compareTo(GenArray[j+1]) > 0) {
                    T s = GenArray[j];
                    GenArray[j] = GenArray[j+1];
                    GenArray[j+1] = s;
                }
            }
        }
        //System.out.println("bubbleSortGen: " + Arrays.toString(GenArray));
        return GenArray;
    }

    public static void main(String[] args) {

        int[] h = createSequenceDec(100);
        int[] t = createSequenceDec(1000);
        int[] tt = createSequenceDec(10000);
        int[] ht = createSequenceDec(100000);

        long[] Begins = new long[10];
        long[] Ends = new long[10];
        long[] Durations = new long[10];
        long Duration = 0;

        for (int i = 0; i < 10; i++) {
            Begins[i] = System.nanoTime();
            bubbleSortNew(ht);                          // -->> manual changes here for tests: methods [insertionSort;bubbleSort;bubbleSortNew] and arrays [h;t;tt;ht]
            Ends[i] = System.nanoTime();
            Durations[i] = Ends[i] - Begins[i];
            Duration += Durations[i];
        }

        long Median = Duration/10;

        System.out.println(Arrays.toString(Durations));
        System.out.println(Median);

        // Test: 100
        // Durations InsertionsSort: [101900, 2600, 2100, 2100, 2100, 2100, 2100, 2100, 2000, 2300]
        // Median InsertionSort: 12140
        // Durations BubbleSort: [126800, 88500, 69500, 70000, 72800, 118100, 93000, 138800, 117400, 128600]
        // Median BubbleSort: 102350
        // Durations BubbleSortNew [3736900, 1447600, 767800, 471700, 615100, 507100, 652000, 593900, 538500, 526100]
        // Median BubbleSortNew: 985670

        // Test: 1.000
        // Durations InsertionsSort: [2350300, 4100, 3700, 3600, 4000, 4100, 3800, 4000, 3800, 3700]
        // Median InsertionSort: 238510
        // Durations BubbleSort: [3870000, 1850900, 1360400, 1454900, 267300, 225300, 209900, 194500, 196100, 197200]
        // Median BubbleSort: 982650
        // Durations BubbleSortNew [33110500, 21543900, 22105700, 14142200, 17659500, 21571500, 17117400, 16878600, 10987600, 11679100]
        // Median BubbleSortNew: 18679600

        // Test: 10.000
        // Durations InsertionsSort: [19647300, 37700, 35500, 35300, 35700, 42700, 36300, 37700, 35500, 35800]
        // Median InsertionSort: 1997950
        // Durations BubbleSort: [68454700, 62771200, 15983200, 15657100, 15356900, 16055800, 16095000, 15699000, 15816200, 16833900]
        // Median BubbleSort: 25872300
        // Durations BubbleSortNew [1481594600, 1330709500, 1001151900, 1001702200, 1002304700, 1001151400, 1028042000, 1029581100, 1041934000, 1026069400]
        // Median BubbleSortNew: 1094424080

        // Test: 100.000
        // Durations InsertionsSort: [1527040800, 370800, 356000, 362400, 357100, 387100, 372300, 376500, 342900, 188700]
        // Median InsertionSort: 153015460
        // Durations BubbleSort: [6158927300, 5048554500, 1579628200, 1585000300, 1594766600, 1583323700, 1583381900, 1584758000, 1585723400, 1581630500]
        // Median BubbleSort: 2388569440
        // Durations BubbleSortNew [129895385400, 128361078100, 104237039800, 102593201300, 102546523600, 102381044700, 102399273500, 102172595600, 103821973500, 104787092900]
        // Median BubbleSortNew: 108319520840

        /*

        System.out.println("");
        int[] arrI = {2,3,7,8,1,6};
        insertionSort(arrI); // insertionSort: [1, 2, 3, 6, 7, 8]
        bubbleSort(arrI); // bubbleSort: [1, 2, 3, 6, 7, 8]

        System.out.println("");
        int[] arrJ = {2,3,7,8,1,6,5,4,8,6,12,42,6,7};
        insertionSort(arrJ); // insertionSort: insertionSort: [1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 12, 42]
        bubbleSort(arrJ); // bubbleSort: [1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 12, 42]
        bubbleSortNew(arrJ); // bubbleSortNew: [1, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 8, 12, 42]

        System.out.println("");
        Integer[] GenI = {2,3,7,8,1,6};
        insertionSortGen(GenI); // insertionSortGen: [1, 2, 3, 6, 7, 8]
        bubbleSortGen(GenI); // bubbleSortGen: [1, 2, 3, 6, 7, 8]

        System.out.println("");
        String[] GenS = {"bac","cab","abc","dag","bza"};
        insertionSortGen(GenS); // insertionSortGen: [abc, bac, bza, cab, dag]
        bubbleSortGen(GenS); // bubbleSortGen: [abc, bac, bza, cab, dag]

        */

    }

}
