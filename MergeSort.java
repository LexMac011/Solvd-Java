import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {78, 11, 3, 27, 1};

        // printing the array before
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        // printing after
        System.out.println(Arrays.toString(array));

    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }
        int midIndex = inputLength / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[inputLength - midIndex];

        // filling up leftside array
        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = inputArray[i];
        }
        // filling up rightside array
        for (int i = midIndex; i < inputLength; i++) {
            rightArray[i - midIndex] = inputArray[i];
        }
        // calling the function recursively
        mergeSort(leftArray);
        mergeSort(rightArray);
        // Merging
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;
        // comparing the elements in each array to decide which value will be placed
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i];
                i++;
            }
            else {
                inputArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // covering when there's left elements to fill
        while (i < leftSize) {
            inputArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            inputArray[k] = rightArray[i];
            j++;
            k++;
        }
    }
}
