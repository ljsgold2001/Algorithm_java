public class Sort_heapSort {
	static int current = 0; //데이터가 추가되어 있는 부분만큼의 배열의 길이
	private static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	private static void print(int[] data) {
		for(int i=0; i<current; i++) { //size보다 1 작을 때까지 출력
			System.out.print(data[i] + " ");
		} System.out.println("\n");
	}
	
	private static void buildMaxHeap(int[] data) {
		int length = data.length+1;
		for(int i = (length/2)-1; i>=0; i--) { //배열은 0부터 시작하므로 -1 수행
			maxHeapify(data,i);
		}	
	}

	private static void maxHeapify(int[] data, int i) { //data는 배열,i는 루트 노드의 인덱스
		int root = i;
		int length = current;
		int leftChild = (i*2)+1; //배열은 0부터 시작하므로 +1
		int rightChild = (i*2)+2; //배열은 0부터 시작하므로 +2
		
		System.out.println("i ->_>_. : " + i);
		System.out.println("leftchild : " + leftChild);
		System.out.println("rightchild : " + rightChild);
		
		//리프 노드까지 탐색을 끝냈을 때
		if(leftChild > length && rightChild > length)
			return;

		//leftChild가 존재하고. 루트 노드의 값보다 클 때
		if(leftChild<length && data[leftChild]>data[i])  //leftChild가 존재하고 루트 노드의 값보다 클 때
			root = leftChild; //루트에 leftChild의 인덱스 할당
		
		//rightChild가 존재하고, 루트 노드의 값보다 크거나 leftChild의 값보다도 클 때
		if (rightChild<length && data[root]<data[rightChild]) 
			root = rightChild; //루트에 rightChild의 인덱스 할당
		
		//기존 루트보다 큰 값의 자식이 있을 때
		if(root != i) {
			swap(data, i, root); //실제 노드의 값 교환
			print(data);
			maxHeapify(data, root); //변경된 루트로 다시 max heapify 진행 
		}
	}

	private static void maxHeapInsert(int[] data, int key) {
		data[current] = key; //배열의 마지막 인덱스에 key 값 추가
		int i = current++; //추가한 노드의 인덱스, 다음 연산을 위해 size 1 추가
		int parent = (i-1)/2;
//		System.out.println("i, parent : "+i + "," + parent);
//		System.out.println("data[parent], data[i] : "+data[parent] + "," +data[i]);
		while(i>0 && data[parent]<data[i]) { //루트 노드가 아니고, 부모 노드의 값보다 큰 동안
			swap(data, i, parent); //값 교환
			i = (i-1)/2; //i와 parent의 값을 교환했으므로 인덱스도 parent의 인덱스로 할당
			parent = (i-1)/2; //인덱스 i값이 변화했으므로, 새로운 i의 parent 인덱스로 할당
		}
	}

	private static int maxHeapExtract(int[] data) { //최대값을 뽑아내는 함수
		if(current < 1)
			System.out.print("heap underflow");
		int max = data[0]; //루트 노드의 값이 최대값
		System.out.println("current is " + current);
		data[0] = data[--current]; //힙의 마지막 노드의 값을 루트 노드로 이동, 배열의 길이를 1씩 줄임
		maxHeapify(data, 0); //변경된 루트 노드에 대하여 max heapify 수행
		return max; //최대값 반환
	}
	
	public static void main(String[] args) {
		int[] data = new int[100];
//		int data[] = { 5, 2, 1, 7, 12, 42, 62, 52};
		//heap에 데이터 추가
		maxHeapInsert(data, 4);
		maxHeapInsert(data, 1);
		maxHeapInsert(data, 13);
		maxHeapInsert(data, 2);
		maxHeapInsert(data, 16);
		maxHeapInsert(data, 9);
		maxHeapInsert(data, 10);
		maxHeapInsert(data, 14);
		maxHeapInsert(data, 8);
		maxHeapInsert(data, 77);
		//max heap property를 만족하도록 정렬
//		buildMaxHeap(data);
		//max heap 출력
		print(data);
		System.out.print("\n" + maxHeapExtract(data) + "\n");
		maxHeapInsert(data, 0);
		print(data);
		System.out.print("\n" + maxHeapExtract(data) + "\n");
		print(data);
	}
}
