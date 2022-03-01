package com.vj.leet.foursum;

import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0).forEach(System.out::println);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        sortArray(nums);
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        int prev = ( nums.length > 0 )?nums[0] - 1 : 0;
        for (int i =0 ; i < nums.length; i++){
            if(prev == nums[i]) {
                continue;
            } else {
                prev = nums[i];
            }

            List<List<Integer>> res = threeSum(nums, i+1,nums.length, target-nums[i]);
            final int selVal = nums[i];
            res.forEach(a->{a.add(selVal);result.add(a); });
        }

        return removeDuplicates(result);
    }

    private List<List<Integer>> threeSum(int[] nums, int low, int high, int target) {
        if(low >= high){
            return Collections.emptyList();
        }
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        int prev = nums[low] - 1;
        for (int i =low ; i < high; i++){
            if(prev == nums[i]) {
                continue;
            } else {
                prev = nums[i];
            }

            List<List<Integer>> res = twoSum(nums, i+1,high, target-nums[i]);
            final int selVal = nums[i];
            res.forEach(a->{a.add(selVal);result.add(a); });
        }
        return removeDuplicates(result);
    }

    private List<List<Integer>> removeDuplicates(List<List<Integer>> result) {
        Map<Integer, List<Integer>> map = new HashMap<>() ;
        for (List<Integer> integers : result) {
            int key = 29;
            //Collections.sort(integers);
            for(Integer num : integers){
                key = (key * 29) + num * 31;
            }
            map.put(key,integers);
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private List<List<Integer>> twoSum(int[] nums, int low, int high, int target) {
        if(low >= high){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int prev = nums[low] - 1;
        for (int i = low ; i < high; i++){
            if(prev == nums[i]) {
                continue;
            } else {
                prev = nums[i];
            }
            int res = binarySearch(nums, i+1,high-1, target-nums[i]);
            if(res > -1){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[res]);
                result.add(list);
            }
        }
        return removeDuplicates(result);
    }

    int binarySearch(int arr[], int p, int r, int num) {
        if (p <= r) {
            int mid = (p + r)/2;
            if (arr[mid] == num)
                return mid ;
            if (arr[mid] > num)
                return binarySearch(arr, p, mid-1, num);
            if (arr[mid] < num)
                return binarySearch(arr, mid+1, r, num);
        }
        return -1;
    }

    private void sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    int partition (int arr[], int low, int high)
    {
        int pivot = arr[high];    // pivot
        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;    // increment index of smaller element
                swap(arr,i, j);
            }
        }
        swap(arr,i + 1, high);
        return (i + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
