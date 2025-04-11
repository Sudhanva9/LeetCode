class Solution {
    List<Integer> prefixSums = new ArrayList<>();
    List<String> cityNames = new ArrayList<>();
    Random rand = new Random();

    public Solution(List<Pair<String, Integer>> cityPopulations) {
        int sum = 0;
        for (Pair<String, Integer> pair : cityPopulations) {
            cityNames.add(pair.getKey());
            sum += pair.getValue();
            prefixSums.add(sum);
        }
    }

    public String pickIndex() {
        int roll = rand.nextInt(prefixSums.get(prefixSums.size() - 1));
        int left = 0, right = prefixSums.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (roll < prefixSums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return cityNames.get(left);
    }
}
