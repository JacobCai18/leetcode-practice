package com.jacobcai.cd;

import java.util.*;

public class Lc380 {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;
    
    public Lc380() {
        nums = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val,
                    index);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index,
                 last);
        indices.put(last,
                    index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
    
    public static void main(String[] args) {
        Lc380 lc380 = new Lc380();
        System.out.println(lc380.insert(1));
        System.out.println(lc380.remove(2));
        System.out.println(lc380.insert(2));
        System.out.println(lc380.getRandom());
        System.out.println(lc380.remove(1));
        System.out.println(lc380.insert(2));
        System.out.println(lc380.getRandom());
    }
}
