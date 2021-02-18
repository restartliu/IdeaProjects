package com.vocabulary.operate;

import com.vocabulary.model.UserTree;
import com.vocabulary.model.VocabularyTree;
import com.vocabulary.operate.oprations.Operator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class OperationManager{

    private final Map<String, Operator> operatorList = new LinkedHashMap<>();
    private static final OperationManager operationManager = new OperationManager();
    private final VocabularyTree vocabularyTree = VocabularyTree.getInstance();
    private UserTree userTree;

    {
        operatorList.put("DefaultRememberHandler", new DefaultRememberHandler());
    }

    private OperationManager(){}

    public static OperationManager getOperationManager(UserTree userTree){
        operationManager.setUserTree(userTree);
        return operationManager;
    }

    public void setUserTree(UserTree userTree) {
        this.userTree = userTree;
    }

    boolean addOperation(String operatorName, Operator operator){
        return (this.operatorList.put(operatorName, operator)!=null);
    }

    public void doOperations(String operatorName) {
        operationManager.operatorList.get(operatorName).doOperate(vocabularyTree, userTree);
    }
}
