import java.util.*;
public class Day18_3408_Solution {

class TaskManager {
    private Map<Integer, TaskInfo> taskMap;
    private PriorityQueue<TaskHeapEntry> heap;

    private static class TaskInfo {
        int userId;
        int priority;
        boolean valid;

        TaskInfo(int userId, int priority, boolean valid) {
            this.userId = userId;
            this.priority = priority;
            this.valid = valid;
        }
    }

    private static class TaskHeapEntry implements Comparable<TaskHeapEntry> {
        int priority;
        int taskId;
        @SuppressWarnings("unused")
        int userId;

        TaskHeapEntry(int priority, int taskId, int userId) {
            this.priority = priority;
            this.taskId = taskId;
            this.userId = userId;
        }

        @Override
        public int compareTo(TaskHeapEntry other) {
            if (this.priority != other.priority) {
                return Integer.compare(other.priority, this.priority); // Higher priority first
            } else {
                return Integer.compare(other.taskId, this.taskId); // Higher taskId first for same priority
            }
        }
    }

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        heap = new PriorityQueue<>();
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            taskMap.put(taskId, new TaskInfo(userId, priority, true));
            heap.offer(new TaskHeapEntry(priority, taskId, userId));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new TaskInfo(userId, priority, true));
        heap.offer(new TaskHeapEntry(priority, taskId, userId));
    }

    public void edit(int taskId, int newPriority) {
        TaskInfo taskInfo = taskMap.get(taskId);
        if (taskInfo != null) {
            taskInfo.priority = newPriority;
            heap.offer(new TaskHeapEntry(newPriority, taskId, taskInfo.userId));
        }
    }

    public void rmv(int taskId) {
        TaskInfo taskInfo = taskMap.get(taskId);
        if (taskInfo != null) {
            taskInfo.valid = false;
        }
    }

    public int execTop() {
        while (!heap.isEmpty()) {
            TaskHeapEntry entry = heap.poll();
            TaskInfo taskInfo = taskMap.get(entry.taskId);
            if (taskInfo != null && taskInfo.valid && taskInfo.priority == entry.priority) {
                taskMap.remove(entry.taskId);
                return taskInfo.userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
}
