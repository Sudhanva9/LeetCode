class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }

        int[] res = new int[arr1.length];
        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                res[idx++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

         List<Integer> extra = new ArrayList<>();
        for (int key : map.keySet()) {
            for (int j = 0; j < map.get(key); j++) {
                extra.add(key);
            }
        }
        Collections.sort(extra);

        // Add remaining sorted elements
        for (int num : extra) {
            res[idx++] = num;
        }

        return res;
    }
}
