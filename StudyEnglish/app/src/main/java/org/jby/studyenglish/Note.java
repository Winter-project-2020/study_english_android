package org.jby.studyenglish;

public class Note {
    String english;
    String meaning;

    public Note(String english, String meaning){
        this.english = english;
        this.meaning = meaning;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
