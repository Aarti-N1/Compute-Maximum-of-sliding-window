package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {

	public static void main(String[] args) {
		//int[] nums = {1,3,-1,2,4,5,7,4};
		int[] nums = {13,0,25,37,0,14, 26, 0, 22, 17, 0,0,0,0,17};
		int[] ans = maxSlidingWindow(nums, 3);
		for(int i=0;i<ans.length;i++) {
			System.out.println(ans[i]);
		}
	}

	
	 public static int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums.length == 0 || k == 0){
	            return new int[0];
	        }
	        int[] answer = new int[nums.length - (k-1)];
/* Making the queue in descending order*/
	        PriorityQueue<Integer> pq = new PriorityQueue(k ,new Comparator<Integer>(){
	            public int compare(Integer o1, Integer o2){
	                if(o1>o2)
	                    return -1;
	                else if(o1==o2)
	                    return 0;
	                else
	                    return 1;
	            }
	        });
	        int startWindow =0 , endWindow = 0;
//Initial loading of queue till it reaches window length
	        while(endWindow<nums.length && endWindow < k){
	            pq.add(nums[endWindow]);
	            endWindow++;
	        }
//Putting max for current index in answer array
	        answer[startWindow] = pq.peek();
//Traverse rest of array adjusting start and end of window
	        for(int i =endWindow; i<nums.length;i++){
	            if(pq.size() == k){
	                //remove the startWindow element
	                pq.remove((Integer)nums[startWindow]);
	                startWindow++;
	                //add the endWindow element
	                pq.add(nums[i]);
	                answer[startWindow] = pq.peek();
	            }    
	        }
	        return answer;
	    }
}
