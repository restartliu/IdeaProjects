package com.vocabulary.model;

import java.io.Serializable;

public class VocabularyNode implements Serializable {

    private String vocabulary;
    private String phoneticTranscription;
    private String paraphrase;
    private Boolean ifRead;

    public VocabularyNode(String vocabulary, String phoneticTranscription, String paraphrase, Boolean ifRead) {
        this.vocabulary = vocabulary;
        this.phoneticTranscription = phoneticTranscription;
        this.paraphrase = paraphrase;
        this.ifRead = ifRead;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getPhoneticTranscription() {
        return phoneticTranscription;
    }

    public void setPhoneticTranscription(String phoneticTranscription) {
        this.phoneticTranscription = phoneticTranscription;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }

    public Boolean getIfRead() {
        return ifRead;
    }

    public void setIfRead(Boolean ifRead) {
        this.ifRead = ifRead;
    }

    @Override
    public String toString() {
        return String.format("%-20s   %-20s   %-40s", this.vocabulary, this.phoneticTranscription, this.paraphrase);
    }
}
