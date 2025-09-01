import java.util.PriorityQueue;

public class Day1_1792_Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
          // Priority queue to simulate a max heap
        PriorityQueue<double[]> pq = new PriorityQueue<>(
           (a,b)->Double.compare(b[0],a[0]) // Sort by delta in descending order
        );

        // Helper function to calculate the improvement in pass ratio
        for (int[] cls : classes) {
            int passi = cls[0], totali = cls[1];
            double delta = improvement(passi, totali);
            pq.offer(new double[] {delta, passi, totali});
        }

        // Assign extra students to maximize the average pass ratio
        while (extraStudents-- > 0) {
            // Remove the class with the highest improvement
            double[] top = pq.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];

            // Add an extra student to this class
            passi++;
            totali++;

            // Calculate new improvement and add back to the heap
            pq.offer(new double[] {improvement(passi, totali), passi, totali});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];
            totalRatio += (double) passi / totali;
        }

        return totalRatio / classes.length;
    }

    // Helper method to calculate the improvement in pass ratio
    private double improvement(int passi, int totali) {
        return ((double) (passi + 1) / (totali + 1)) - ((double) passi / totali);
    }
}
