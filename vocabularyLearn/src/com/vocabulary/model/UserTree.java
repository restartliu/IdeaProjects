package com.vocabulary.model;

import com.vocabulary.model.entity.Schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTree implements BaseTree{

    private final List<VocabularyNode> userVocabularyList;
    private final String username;
    private final Integer rememberPerDay;
    private final Date startDate;
    private final Schedule schedule;

    public UserTree(List<VocabularyNode> userVocabularyList, String username, Date startDate,
                    Integer rememberPerDay, Integer totalVocabulary) {
        this.userVocabularyList = userVocabularyList;
        this.username = username;
        this.startDate = startDate;
        this.rememberPerDay = rememberPerDay;
        this.schedule = new Schedule(rememberPerDay, totalVocabulary, startDate);
    }

    public List<VocabularyNode> getTodaySchedule(Date today){
        List<Integer> todaySchedule = schedule.getTodaySchedule(today);
        List<VocabularyNode> trueSchedule = new ArrayList<>();
        todaySchedule.forEach(w->{
            int temp = w*rememberPerDay;
            trueSchedule.addAll(userVocabularyList.subList(temp, temp+rememberPerDay));
        });
        return trueSchedule;
    }

    @Override
    public Integer getSize() {
        return this.userVocabularyList.size();
    }
}
