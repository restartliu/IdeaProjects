package com.vocabulary.model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class VocabularyTree implements BaseTree{

    private static final VocabularyTree INSTANCE = new VocabularyTree();

    private final Map<String, VocabularyNode> vocabularyList = new TreeMap<>();

    private VocabularyTree(){};

    public static VocabularyTree getInstance(){
        return INSTANCE;
    }

    public void constructTree(String filepath) throws IOException {
        Iterator<String> iterator = Files
                .readAllLines(Paths.get(filepath), StandardCharsets.UTF_8).stream().iterator();
        while (iterator.hasNext()) {
            String vocabulary = iterator.next();
            String phoneticTranscription = iterator.next();
            String paraphrase = iterator.next();
            this.vocabularyList.put(vocabulary, new VocabularyNode(vocabulary, phoneticTranscription, paraphrase, false));
        }
    }

    public void passTree(){
        this.vocabularyList.forEach((k, v)-> System.out.println(v));
    }

    public List<VocabularyNode> getUserIndexList(){
        List<VocabularyNode> indexList = new ArrayList<>();
        this.vocabularyList.forEach((k,v)->indexList.add(v));
        Collections.shuffle(indexList, new Random(new Date().getTime()));
        return indexList;
    }

    public VocabularyNode getElementByVocabulary(String index){
        return this.vocabularyList.get(index);
    }

    @Override
    public Integer getSize() {
        return this.vocabularyList.size();
    }
}
