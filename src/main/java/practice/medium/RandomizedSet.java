package practice.medium;

import java.util.*;

class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val))
           return false;
        map.put(val,val);
        list.add(val);
        return true;

    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            map.remove(val);
            list.remove(Integer.valueOf(val));
            return true;
        }
        else
            return false;

    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet=new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
