class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;
        
        int i = 0;
        int m = meetings.length;
        while (i < m) {
            int currentTime = meetings[i][2];
            Map<Integer, List<Integer>> adjL = new HashMap<>();
            Set<Integer> people = new HashSet<>();
            
            while(i < m && meetings[i][2] == currentTime) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                adjL.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
                adjL.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                people.add(x);
                people.add(y);
                i++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int p : people) {
                if (knowsSecret[p]) {
                    queue.offer(p);
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int neighbor : adjL.getOrDefault(curr, new ArrayList<>())) {
                    if (!knowsSecret[neighbor]) {
                        knowsSecret[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (knowsSecret[j]) result.add(j);
        }
        return result;
    }
}
