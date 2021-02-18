package com.vocabulary.model.entity;

import java.util.*;

public class Schedule {

    private Map<String, List<Integer>> scheduleList;
    private final Integer[] curveOfEbbinghaus = {1, 2, 4, 7, 15, 30};
    private final long OneDay = 24 * 60 * 60 * 1000;
    private final String DateStandardFormat = "%-4tY %<-3tB %<2te";

    public Schedule(Integer rememberPerDay, Integer total, Date createdDate) {
        this.createSchedule(rememberPerDay, total, createdDate);
    }

    private void createSchedule(Integer rememberPerDay, Integer total, Date createdDate) {
        scheduleList = new LinkedHashMap<>();
        int totalDayCount = total / rememberPerDay + (total % rememberPerDay == 0 ? 0 : 1);
        Map<Integer, List<Integer>> analyzedMatrix = matrixAnalyze(totalDayCount);
        analyzedMatrix.forEach((k, v) -> {
            scheduleList.put(String.format(DateStandardFormat, new Date(k*OneDay+createdDate.getTime())), v);
        });
    }

    private Map<Integer, List<Integer>> matrixAnalyze(Integer totalDayCount) {
        Integer[][] matrix = new Integer[totalDayCount][curveOfEbbinghaus.length];
        for (int i = 0; i < totalDayCount; i++) {
            for (int j = 0; j < curveOfEbbinghaus.length; j++) {
                matrix[i][j] = curveOfEbbinghaus[j] + i;
            }
        }
        Integer finishDay = matrix[totalDayCount - 1][curveOfEbbinghaus.length - 1];
        Map<Integer, List<Integer>> analyzedSchedule = new HashMap<>();
        for (int i = 0; i < finishDay; i++) {
            List<Integer> temp = new LinkedList<>();
            for (int j = 0; j < totalDayCount; j++) {
                int finalI = i + 1;
                if (Arrays.stream(matrix[j]).anyMatch(w -> w == finalI)) {
                    temp.add(j);
                }
            }
            analyzedSchedule.put(i, temp);
        }
        return analyzedSchedule;
    }

    public void printSchedule() {
        this.scheduleList.forEach((k, v) -> {
            System.out.print(k + ":   ");
            v.forEach(w -> {
                System.out.printf("%3d%s", (w + 1), (v.get(v.size() - 1) == w ? "" : ", "));
            });
            System.out.println();
        });
    }

    public List<Integer> getTodaySchedule(Date today) {
        String dateFormat = String.format(DateStandardFormat, today);
        return this.scheduleList.get(dateFormat);
    }

}
