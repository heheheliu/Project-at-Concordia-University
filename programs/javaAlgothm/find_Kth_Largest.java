import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//solve this problem in O(n.log(k)) by using a min-heap.
/* the idea is to construct a min-heap of size k and insert the first k elements of array
A[0......k-1] into the min-heap, then for each of the remaining array elements A[0.....n-1],
if that element is more than the min-heap's root, replace the root with the current element.
Now we will be left with top k largest array elements in the min-heap,
and k th largest element will reside at the root of the min-heap.
 */
class find_Kth_Largest {

    // Function to find the k'th largest element in an
    // array using min-heap
    public static int findKthLargest(List<Integer> ints, int k) {
        // create a min-heap using the `PriorityQueue` class and insert
        // the first `k` array elements into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < ints.size(); i++) {
            // if the current element is more than the root of the heap
            if (ints.get(i) > pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }

    // public static void main(String[] args) {
    //     List<Integer> ints = Arrays.asList(19, 21, 15, 18, 10, 17, 29);
    //     int k = 2;
    //     System.out.println("k th largest array element is " + findKthLargest(ints, k));


    // }
}