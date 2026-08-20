class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        // Store the last position of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Extend the current partition
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // All characters in this partition end here
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}