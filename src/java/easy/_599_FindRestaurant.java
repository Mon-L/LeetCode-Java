package easy;

import java.util.*;

public class _599_FindRestaurant {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> helper = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            helper.put(list1[i], i);
        }

        int min = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer j = helper.get(list2[i]);
            if (j != null) {
                int k = j + i;
                if (min == k) {
                    ret.add(list2[i]);
                } else if (min > k) {
                    ret.clear();
                    ret.add(list2[i]);
                    min = k;
                }
            }
        }
        
        return ret.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _599_FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(new _599_FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})));
        System.out.println(Arrays.toString(new _599_FindRestaurant().findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"})));
    }
}
