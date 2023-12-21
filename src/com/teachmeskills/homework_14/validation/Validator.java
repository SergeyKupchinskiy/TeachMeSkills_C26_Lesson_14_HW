package com.teachmeskills.homework_14.validation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Validator {
    private static final String DOCNUM_PREFIX = "docnum";
    private static final String CONTRACT_PREFIX = "contract";

    public void validate(String inputFile) throws IOException {

        String outputValidDocnums = "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\valid\\valid_docnums.txt";
        String outputValidContracts = "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\valid\\valid_contracts.txt";
        String outputInvalidDocnums = "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\invalid\\invalid_docnums.txt";
        String outputErrorLog = "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\log\\error_log.txt";
        String outputExecutionLog = "C:\\Users\\KABAN\\IdeaProjects\\TeachMeSkills_C26_Lesson_14_HW\\file\\log\\execution_log.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter validDocnumsWriter = new BufferedWriter(new FileWriter(outputValidDocnums));
             BufferedWriter validContractsWriter = new BufferedWriter(new FileWriter(outputValidContracts));
             BufferedWriter invalidDocnumsWriter = new BufferedWriter(new FileWriter(outputInvalidDocnums));
             BufferedWriter errorLogWriter = new BufferedWriter(new FileWriter(outputErrorLog));
             BufferedWriter executionLogWriter = new BufferedWriter(new FileWriter(outputExecutionLog))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(DOCNUM_PREFIX)) {
                    if (isValidDocumentNumber(line)) {
                        validDocnumsWriter.write(line);
                        validDocnumsWriter.newLine();
                    }
                    else {
                        invalidDocnumsWriter.write(line + " - invalid character sequence");
                        invalidDocnumsWriter.newLine();
                    }
                }
                else if (line.startsWith(CONTRACT_PREFIX)) {
                    if (isValidDocumentNumber(line)) {
                        validContractsWriter.write(line);
                        validContractsWriter.newLine();
                    }
                    else {
                        invalidDocnumsWriter.write(line + " - invalid character sequence");
                        invalidDocnumsWriter.newLine();
                    }
                }
                else {
                    errorLogWriter.write(line + " - does not meet the validation conditions");
                    errorLogWriter.newLine();
                }

                executionLogWriter.write("Document number processed: " + line);
                executionLogWriter.newLine();
            }
        }
    }

    private boolean isValidDocumentNumber(String documentNumber) {
        documentNumber = documentNumber.toLowerCase().replaceAll("[^a-z0-9]", "");
        return documentNumber.length() == 15 &&
                (documentNumber.startsWith(DOCNUM_PREFIX) || documentNumber.startsWith(CONTRACT_PREFIX));
    }
}