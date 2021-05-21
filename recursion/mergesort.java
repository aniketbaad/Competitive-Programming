import java.util.*;

class MergeSort {
	public static void main(String[] args){
		int n = 10;
		int[] array = new int[n];
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<n;i++){
			array[i] = sc.nextInt();
		}

		mergeSort(array, 0, n-1);

		for(int i=0;i<n;i++){
			System.out.println(array[i]);
		}
	}

	public static void mergeSort(int[] array, int left, int right){
		if(right>left){
			int mid = (left+right)/2;
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}

	public static void merge(int[] array, int left, int mid, int right){
		int n1 = mid - left + 1;
		int n2 =  right - mid;

		int[] A1 = new int[n1];
		int[] A2 = new int[n2];

		for(int i=0;i<n1;i++){
			A1[i] = array[left + i];
		}

		for(int i=0;i<n2;i++){
			A2[i] = array[mid + 1 + i];
		}

		int i=0;
		int j=0;
		int k=left;
		while((i<n1) && (j<n2)){
			if(A1[i] < A2[j]){
				array[k] = A1[i];
				i++;
			}else{
				array[k] = A2[j];
				j++;
			}
			k++;
		}

		while(i<n1){
			array[k] = A1[i];
			i++;
			k++;
		}

		while(j<n2){
			array[k] = A2[j];
			j++;
			k++;
		}
	}
}
