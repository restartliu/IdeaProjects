package com.vocabulary.operate.oprations;

import com.vocabulary.model.UserTree;
import com.vocabulary.model.VocabularyTree;

/**
 * @author Administrator
 */
public interface Operator {

    /**
     * some function for this program
     * @param vocabularyTree include all vocabulary
     * @param userTree user vocabulary tree for remember or other function, it's a subset of vocabulary tree, created when a new user was added
     */
    void doOperate(VocabularyTree vocabularyTree, UserTree userTree);

}
