package com.vocabulary.operate;

import com.vocabulary.model.UserTree;
import com.vocabulary.model.VocabularyNode;
import com.vocabulary.model.VocabularyTree;
import com.vocabulary.operate.oprations.Operator;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class DefaultRememberHandler implements Operator {

    @Override
    public void doOperate(VocabularyTree vocabularyTree, UserTree userTree) {
        Scanner scanner = new Scanner(System.in);
        List<VocabularyNode> todaySchedule = userTree.getTodaySchedule(new Date());
        for (int i = 0; i < todaySchedule.size();) {
            System.out.println(todaySchedule.get(i));
            if (scanner.hasNext()) {
                if (scanner.nextLine().compareTo(todaySchedule.get(i).getVocabulary())==0) {
                    i++;
                }
            }
        }
    }
}
