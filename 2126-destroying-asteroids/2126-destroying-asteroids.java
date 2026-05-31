class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        long cm = mass;
        Arrays.sort(asteroids);
        for (int m : asteroids) {
            if (cm < m) return false;
            cm += m;
        }
        return true;
    }
}