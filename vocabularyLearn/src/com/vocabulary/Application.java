package com.vocabulary;

import com.vocabulary.model.UserTree;
import com.vocabulary.model.VocabularyTree;
import com.vocabulary.operate.OperationManager;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Application {

    static String filepath = "d:/IdeaProjects/vocabularyLearn/resources/vocabulary.txt";
    static String platform = "windows";

    public static void main(String[] args) throws IOException {
        VocabularyTree tree = VocabularyTree.getInstance();
        dealWithFilepath(args);
        tree.constructTree(filepath);
        UserTree liuguanglong = new UserTree(tree.getUserIndexList(), "liuguanglong", new Date(), 10, tree.getSize());
        OperationManager operationManager = OperationManager.getOperationManager(liuguanglong);
        operationManager.doOperations("DefaultRememberHandler");
    }

    private static void dealWithFilepath(String[] args){
        if (args.length == 1) {
            filepath = args[0].equals("linux") ? "/mnt/d/IdeaProjects/vocabularyLearn/resources/vocabulary.txt" : filepath;
        }
    }
}
