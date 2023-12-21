package com.teachmeskills.homework_14;

import com.teachmeskills.homework_14.validation.Validator;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {

        String inputFile = getInputFilePath();
        try {
            checkDocumentNumbers(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getInputFilePath() {
        return "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\input.txt";
    }

    private static void checkDocumentNumbers(String inputFile) throws IOException {
        Validator validator = new Validator();
        validator.validate(inputFile);
    }
}