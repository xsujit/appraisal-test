package com.example.pages;


import static com.example.paths.HomeElement.GET_STARTED;
import static com.example.paths.HomeElement.PROGRESS;
import static com.example.utils.WebDriverUtil.click;
import static com.example.utils.WebDriverUtil.getText;
import static com.example.utils.WebDriverUtil.goTo;

public class HomePage {

    public HomePage visit() {
        goTo("http://localhost:8080");
        return this;
    }

    public String getProgress() {
        return getText(PROGRESS);
    }

    public AppraisalPage getStarted() {
        click(GET_STARTED);
        return new AppraisalPage();
    }

    public Navigation getNavigationPane() {
        return new Navigation();
    }

}
