/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.app.backoffice.console.presentation.applications.UI;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import jobs4u.core.customerusermanagement.domain.Address;
import jobs4u.core.jobopeningmanagement.application.RegisterJobOpeningController;
import jobs4u.core.jobopeningmanagement.domain.*;

import java.sql.Date;

/**
 * The type Register job opening ui.
 */
public class RegisterJobOpeningUI extends AbstractUI {

    private final RegisterJobOpeningController theController = new RegisterJobOpeningController();

    @Override
    protected boolean doShow() {
        final String jobReference = Console.readNonEmptyLine("Reference", "Please enter the job reference");
        final String function = Console.readNonEmptyLine("Function", "Please enter the function");
        final String company = Console.readNonEmptyLine("Company", "Please enter the company");
        final String addressString = Console.readNonEmptyLine("Address", "Please enter the address");
        final Address address = new Address(addressString);
        final String contractType = showContractTypes();
        final String mode = showWorkModes();
        final Date startDate = readDate("Please enter the start date (YYYY-MM-DD)", null);
        final Date endDate = readDate("Please enter the end date (YYYY-MM-DD)", startDate);
        final String vacancies = Console.readNonEmptyLine("Vacancies", "Please enter the vacancies");

        try {
            this.theController.registerJobOpening(jobReference, address, company, contractType, function, mode, vacancies, startDate, endDate);
            System.out.println("\nJob Opening created successfully.\n");
        } catch (final IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error creating Job Opening: " + e.getMessage());
        }

        return false;
    }

    private String showContractTypes() {
        System.out.println("Available Contract Types:");
        int index = 1;
        for (ContractType type : ContractType.values()) {
            System.out.println(index + ". " + type.getName());
            index++;
        }
        System.out.println(index + ". " + "Enter other contract type");

        final int contractTypeOption = Console.readInteger("Enter Contract Type Option: ");

        ContractType selectedType = null;

        if (contractTypeOption <= ContractType.values().length) {
            selectedType = ContractType.values()[contractTypeOption - 1];
        } else if (contractTypeOption == ContractType.values().length + 1) {
            return Console.readLine("Please Specify Contract Type: ");
        }else {
            System.out.println("Invalid choice.");
        }
        assert selectedType != null;
        return selectedType.getName();
    }

    private String showWorkModes() {
        System.out.println("Available Work Modes:");
        int index = 1;
        for (Mode mode: Mode.values()) {
            System.out.println(index + ". " + mode.getMode());
            index++;
        }

        final int workModeOption = Console.readInteger("Enter Work Mode Option: ");


        Mode selectedMode = null;

        if (workModeOption <= Mode.values().length) {
            selectedMode = Mode.values()[workModeOption - 1];
        } else {
            System.out.println("Invalid choice.");
        }
        assert selectedMode != null;
        return selectedMode.getMode();
    }

    private Date readDate(String prompt, Date startDate) {
        String dateStr;
        Date date = null;

        while (date == null) {
            dateStr = Console.readNonEmptyLine(prompt, "Please enter the date");

            if (!dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            } else {
                try {
                    date = Date.valueOf(dateStr);
                    if (startDate != null && date.before(startDate)) {
                        System.out.println("End date cannot be before start date. Please enter a valid date.");
                        date = null;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid date. Please enter a valid date.");
                }
            }
        }
        return date;
    }




    @Override
    public String headline() {
        return "Register a Job Opening";
    }
}
