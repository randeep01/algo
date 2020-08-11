public class Sorting
{
	/**
	 * worst case o(n^2)
	 * space o(1)
	 * stable no
	 */
	public void selection1(int arr[])
	{
		int size = arr.length;
		int i,j, max, temp;
		for(i=0;i<size-1;i++)
		{
			max = 0;
			for(j=1;j<size-1-i;i++){
				if(arr[j] > arr[max]){
					max = j;
				}
			}
			temp = arr[size-1-i];
			arr[size-1-i] = arr[max];
			arr[max]= temp;
		}
	}

	public void selection2(int arr[]){
		int size = arr.length-1;
		int i,j, min, temp;

		for(i = 0;i<size-1;i++)
		{
			min = i;
			for(j = i+1;j<size;j++)
			{
				if(arr[j] < arr[min]){
					min = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	/**
	 *  worst case o(n^2)
	 *  best case o(n)
	 *  space o(1)
	 *  stable sort yes
	 */
	public void insertion(int arr[])
	{
		int size = arr.length;
		int temp, j;
		for(int i = 1;i<size;i++)
		{
			temp  = arr[i];
			for(j=i;j>0 && more(arr[j-1],temp);j--){
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	public boolean more(int val1,int val2){
		return val1>val2;
	}
}

