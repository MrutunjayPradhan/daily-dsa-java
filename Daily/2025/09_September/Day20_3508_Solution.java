import java.util.*;
public class Day20_3508_Solution {

class Router {
    private final int memoryLimit;
    private final Deque<Packet> queue;
    private final Map<String, Boolean> duplicates;
    private final Map<Integer, List<Packet>> destinationMap;
    private int currentSize;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new LinkedList<>();
        this.duplicates = new HashMap<>();
        this.destinationMap = new HashMap<>();
        this.currentSize = 0;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        
        // Check for duplicate
        if (duplicates.containsKey(key)) {
            return false;
        }

        // Remove oldest packet if memory limit reached
        if (currentSize >= memoryLimit) {
            Packet oldest = queue.pollFirst();
            removeFromDestinationMap(oldest);
            String oldestKey = oldest.source + "," + oldest.destination + "," + oldest.timestamp;
            duplicates.remove(oldestKey);
            currentSize--;
        }

        // Create and add new packet
        Packet newPacket = new Packet(source, destination, timestamp);
        queue.addLast(newPacket);
        duplicates.put(key, true);
        
        // Add to destination map for efficient querying
        destinationMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(newPacket);
        currentSize++;
        
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[0];
        }

        Packet packet = queue.pollFirst();
        removeFromDestinationMap(packet);
        String key = packet.source + "," + packet.destination + "," + packet.timestamp;
        duplicates.remove(key);
        currentSize--;

        return new int[]{packet.source, packet.destination, packet.timestamp};
    }

    @SuppressWarnings("unused")
    public int getCount(int destination, int startTime, int endTime) {
        if (!destinationMap.containsKey(destination)) {
            return 0;
        }

        List<Packet> packets = destinationMap.get(destination);
        int count = 0;
        
        // Since packets are added in increasing timestamp order, we can use binary search
        int left = 0, right = packets.size() - 1;
        
        // Find first packet with timestamp >= startTime
        int startIdx = findFirstGreaterOrEqual(packets, startTime);
        if (startIdx == -1) {
            return 0;
        }
        
        // Find last packet with timestamp <= endTime
        int endIdx = findLastLessOrEqual(packets, endTime);
        if (endIdx == -1) {
            return 0;
        }
        
        return Math.max(0, endIdx - startIdx + 1);
    }

    private int findFirstGreaterOrEqual(List<Packet> packets, int target) {
        int left = 0, right = packets.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (packets.get(mid).timestamp >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private int findLastLessOrEqual(List<Packet> packets, int target) {
        int left = 0, right = packets.size() - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (packets.get(mid).timestamp <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private void removeFromDestinationMap(Packet packet) {
        List<Packet> packets = destinationMap.get(packet.destination);
        if (packets != null) {
            // Since we need to maintain order for binary search, we'll use a more efficient approach
            // In practice, we might want to use a different data structure, but for the constraints
            // and since removals are relatively infrequent, this should work
            packets.remove(packet);
            if (packets.isEmpty()) {
                destinationMap.remove(packet.destination);
            }
        }
    }

    private static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }
}
}
