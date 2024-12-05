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
package jobs4u.app.backoffice.console.presentation;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import jobs4u.Application;
import jobs4u.app.backoffice.console.presentation.PluginManagement.*;
import jobs4u.app.backoffice.console.presentation.PluginManagement.Actions.UploadInterviewModelFileAction;
import jobs4u.app.backoffice.console.presentation.applications.Actions.*;
import jobs4u.app.backoffice.console.presentation.applications.Actions.ManagePhasesAction;
import jobs4u.app.backoffice.console.presentation.applications.Actions.RegisterApplicationAction;
import jobs4u.app.backoffice.console.presentation.applications.Actions.RegisterJobOpeningAction;
import jobs4u.app.backoffice.console.presentation.applications.Actions.SetupPhasesAction;
import jobs4u.app.backoffice.console.presentation.applications.UI.*;
import jobs4u.app.backoffice.console.presentation.authz.*;
import jobs4u.app.common.console.presentation.authz.MyUserMenu;
import jobs4u.core.candidateusermanagement.application.SeeCandidateInfoController;
import jobs4u.core.usermanagement.domain.BaseRoles;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACTIVATE_USER_OPTION = 4;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 5;

    //SUBMENU ADMIN
    private static final int ENABLE_DISABLE_LIST_USERS = 1;

    //SUBMENU OPERATOR
    private static final int REGISTER_CANDIDATE_OPTION = 1;
    private static final int DISPLAY_FILES_APPLICATION_EMAIL_BOT_OPTION = 2;
    private static final int REGISTER_APPLICATION_OPTION = 3;
    private static final int GENERATE_REQUIREMENT_TEMPLATE = 4;
    private static final int UPLOAD_FILE_REQ = 5;

    //SUBMENU Customer Manager
    private static final int REGISTER_CUSTOMER_OPTION = 1;
    private static final int REGISTER_JOB_OPENING = 2;
    private static final int DISPLAY_PERSONAL_DATA_CANDIDATE_OPTION = 3;
    private static final int LIST_APPLICATIONS_JOB_OPENING = 4;
    private static final int SELECT_REQUIREMENT = 5;
    private static final int SELECT_INTERVIEW_MODEL_FOR_INTERVIEW = 6;
    private static final int GENERATE_INTERVIEW_MODEL_TEMPLATE = 7;
    private static final int SETUP_PHASES = 8;
    private static final int MANAGE_PHASES = 9;
    private static final int EVALUATE_REQ = 10;
    private static final int NOTIFY_BY_EMAIL = 11;
    private static final int UPLOAD_INTERVIEW_MODEL_FILE = 12;
    private static final int RANK_CANDIDATES = 13;
    private static final int GRADE_INTERVIEW = 14;
    private static final int LIST_CANDIDADATES_BY_GRADE = 15;
    private static final int PUBLISH_RESULTS = 16;
    private static final int TOP_WORDS = 17;


    //SUBMENU Language Engineer
    private static final int DEPLOY_CONFIGURE_PLUGIN = 1;
    private static final int REQUIREMENTS = 2;
    private static final int INTERVIEW_MODEL = 3;
    private static final int HELP_ANSWERS = 4;
    private static final int COLLECT_DATA_FIELDS = 5;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 3;

    // OPERATOR MAIN MENU
    private static final int OPERATOR_MY_USER_OPTION = 1;
    private static final int OPERATOR_SETTINGS_OPTION = 2;

    // CUSTOMER MANAGER MAIN MENU
    private static final int CUSTOMER_MANAGER_SETTINGS_OPTION = 2;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Jobs4U Backoffice [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Jobs4U Backoffice [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        // Menu específico do admin
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.ADMIN)) {
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }
        // Menu específico do operator
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.OPERATOR)) {
            final Menu settingsMenu = buildOperatorSettingsMenu();
            mainMenu.addSubMenu(OPERATOR_SETTINGS_OPTION, settingsMenu);
        }
        // Menu específico do Customer Manager
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CUSTOMER_MANAGER)) {
            final Menu settingsMenu = buildCustomerManagerSettingsMenu();
            mainMenu.addSubMenu(CUSTOMER_MANAGER_SETTINGS_OPTION, settingsMenu);
        }
        // Menu específico do Language Engineer
        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.LANGUAGE_ENGINEER)) {
            final Menu settingsMenu = buildLanguageEngineerSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    // "SubMenu" do Admin
    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List All Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new ActivateUserAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    // "SubMenu" do Operator
    private Menu buildOperatorSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(REGISTER_CANDIDATE_OPTION, "Register a Candidate",
                new AddCandidateUI()::show);
        menu.addItem(DISPLAY_FILES_APPLICATION_EMAIL_BOT_OPTION, "Process files from Applications Email Bot",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(REGISTER_APPLICATION_OPTION, "Register an Application of a Candidate",
                new RegisterApplicationAction());
        menu.addItem(GENERATE_REQUIREMENT_TEMPLATE, "Generate a Template Text File for a Job Requirement specification",
                new GenerateRSTemplateUI()::show);
        menu.addItem(UPLOAD_FILE_REQ, "Upload a file (Requirements)", new UploadRequirementsFileUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    // "SubMenu" do Customer Manager
    private Menu buildCustomerManagerSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(REGISTER_CUSTOMER_OPTION, "Register a Customer",
                new AddCustomerUI()::show);
        menu.addItem(REGISTER_JOB_OPENING, "Register a Job Opening",
                new RegisterJobOpeningAction());
        menu.addItem(DISPLAY_PERSONAL_DATA_CANDIDATE_OPTION, "Display all Personal Data of a Candidate",
                new SeeCandidateInfoUI(new SeeCandidateInfoController())::show);
        menu.addItem(LIST_APPLICATIONS_JOB_OPENING, "List all Applications for a Job Opening",
                new ListApplicationsAction());
        menu.addItem(SELECT_REQUIREMENT, "Select the Job Requirements Specification to be used for a Job Opening",
                new SelectRequirementUI()::show);
        menu.addItem(SELECT_INTERVIEW_MODEL_FOR_INTERVIEW, "Select the Interview Model to be used for a Job Opening",
                new SelectInterviewModelUI()::show);
        menu.addItem(GENERATE_INTERVIEW_MODEL_TEMPLATE, "Generate a Template Text File for an Interview Model",
                new GenerateIMTemplateUI()::show);
        menu.addItem(SETUP_PHASES, "Setup Phases for a Job Opening",
                new SetupPhasesAction());
        menu.addItem(MANAGE_PHASES, "Manage Phases for a Job Opening",
                new ManagePhasesAction());
        menu.addItem(EVALUATE_REQ, "Verification of requirements",
                new VerifyRequirementsAction());
        menu.addItem(NOTIFY_BY_EMAIL, "Notify Candidates about Application State by Email",
                new NotifyByEmailAction());
        menu.addItem(UPLOAD_INTERVIEW_MODEL_FILE, "Upload Interview Model File",
                new UploadInterviewModelFileAction());
        menu.addItem(RANK_CANDIDATES, "Rank Candidates",
                new RankkUI()::show);
        menu.addItem(GRADE_INTERVIEW, "Grade Interview",
                new GradeInterviewUI()::show);
        menu.addItem(LIST_CANDIDADATES_BY_GRADE, "List Candidates By Interview Grade",
                new ListCandidatesByInterviewGradesUI()::show);
        menu.addItem(PUBLISH_RESULTS, "Publish results of the selection of candidates",
                new PublishResultsUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    // "SubMenu" do Language Engineer
    private Menu buildLanguageEngineerSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(DEPLOY_CONFIGURE_PLUGIN, "Deploy and Configure a Plugin",
                new RegisterPluginUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

}
