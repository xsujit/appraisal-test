package com.example.pages;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.paths.AppraisalElement.ALERT;
import static com.example.paths.AppraisalElement.APPRAISAL_TEXT;
import static com.example.paths.AppraisalElement.SUBMIT;
import static com.example.utils.DataGenerator.generateParagraph;
import static com.example.utils.WebDriverUtil.click;
import static com.example.utils.WebDriverUtil.getText;
import static com.example.utils.WebDriverUtil.sendKeys;

public class AppraisalPage {

    private static final Logger logger = LoggerFactory.getLogger(AppraisalPage.class);

    public AppraisalPage enterAppraisal() {
        String paragraph = generateParagraph();
        logger.info("paragraph={}", paragraph);
        sendKeys(APPRAISAL_TEXT, paragraph);
        return this;
    }

    public AppraisalPage submit() {
        click(SUBMIT);
        return this;
    }

    public String getAlert() {
        return getText(ALERT);
    }
}
