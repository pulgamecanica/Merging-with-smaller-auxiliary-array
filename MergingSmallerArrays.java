public class MergingSmallerArrays {

    public static void main(String[] args){
        System.out.println("********************TEST*********************");
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        int a = addNewAndReturnLast(test, 4);
        for(int i = 0; i < test.length; i++)
            System.out.print(test[i] + ", ");
        System.out.println(" ...... " + a);

        int[] arr1 = new int[]{1, 5, 9, 10, 15, 20, 2, 3, 10, 14, 49, 50}; 
        int n = 6;
        System.out.println();
        System.out.println();
        System.out.println("********************Merge*********************");
        merge(arr1, n);
        for(int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + ", ");
        System.out.println();

    }

    public static void merge(int[] array, int n) {
        //Index in AUX for the Greater!
        int m = n - 1;
        //Index for the last Greater element! :D
        int hi =  (n * 2) - 1; 
        int[] aux = new int[n];
        //copy only the left half into the auxiliary array.
        for(int i = 0; i <= m; i++)
            aux[i] = array[i];
        //check the right part! :D
        while(hi >= n){
            if(aux[m] <= array[hi])
                hi--;
            else{
                int box = addNewAndReturnLast(aux, array[hi]);
                array[hi] = box;
                hi--;
            }
        }
        //Copy The Aux Array To the left, It Is sorted.
        for(int i = 0; i < n; i++)
            array[i] = aux[i];
    }

    public static int addNewAndReturnLast(int[] array, int newElement){
        int box = array[array.length - 1];
        array[array.length - 1] = newElement;
        int counter = array.length - 1;
        while(true){
            if(counter <= 0)
                break;
            else if(array[counter-1] > array[counter]){
                array[counter] = array[counter-1];
                array[counter-1] = newElement;
                counter--;
            }
            else
                break;
        }
        return box;
    }
}