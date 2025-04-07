class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> callStack = new Stack<>();
        int lastTimestamp = -1;
        int[] res = new int[n];

        for (String log : logs) {
            String[] str = log.split(":");
            int funcId = Integer.parseInt(str[0]);
            boolean isStart = "start".equals(str[1]);
            int timeStamp = Integer.parseInt(str[2]);

            if (!isStart) timeStamp += 1;

            if (!callStack.empty()) {
                int curFunc = callStack.peek();
                res[curFunc] += timeStamp - lastTimestamp;
            }

            if (isStart) {
                callStack.push(funcId);
            } else {
                callStack.pop();
            }

            lastTimestamp = timeStamp;
        }
        return res;
    }
}
