package com.mcireasa.quizzapp.Model;

public class Event {

    public int imageId;
    public String textView;

    public Event() {
    }

    public Event(int imageId, String textView) {
        this.imageId = imageId;
        this.textView = textView;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }
}
