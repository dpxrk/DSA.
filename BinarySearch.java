
public class BinarySearch {
	
	public int binarySearch(int[] array, int numberToSearch) {
		int low = 0;
		int high = array.length - 1;
		
		while (low <= high) {
			int middle = (low + high) / 2; // have taken the index of mid element
			if (array[middle] == numberToSearch) {
				return middle;
			}
			
			if (array[middle] < numberToSearch) {
				low = middle + 1;
			}
			
			if (array[middle] > numberToSearch) {
				high = middle - 1;
			}
			
		}
		
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 23, 43, 66, 90}; // Will only work when array is sorted.
		
		BinarySearch BS = new BinarySearch();
		
		
		int index = BS.binarySearch(arr,43);
		System.out.println("Found value at: "+ index);
	}

}
