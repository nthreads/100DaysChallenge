

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOrRunningStream {

    // 295. Find Median from Data Stream
    // https://leetcode.com/problems/find-median-from-data-stream/

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder()); // Smaller number
    private static PriorityQueue<Integer> minHeap = new PriorityQueue(); // Larger numbers


    static void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    static double findMedian() {
        return (maxHeap.size() == minHeap.size())?  (maxHeap.peek() + minHeap.peek()) / 2d : maxHeap.peek();
    } 

    public static void main(String[] args) {
        addNum(5);
        addNum(4);
        System.out.println("Median " + findMedian());
    }
}
