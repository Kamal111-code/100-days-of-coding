class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff < min) {
                min = diff;
                ans.clear();

                List<Integer> valid = new ArrayList<>();
                valid.add(arr[i - 1]);
                valid.add(arr[i]);
                ans.add(valid);

            } else if (diff == min) {

                List<Integer> valid = new ArrayList<>();
                valid.add(arr[i - 1]);
                valid.add(arr[i]);
                ans.add(valid);
            }
        }

        return ans;
    }
}
