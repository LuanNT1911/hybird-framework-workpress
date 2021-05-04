package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
    public static final String FIRSTNAME_TEXTBOX_ADD_FORM = "//input[@id='firstName']";
    public static final String LASTNAME_TEXTBOX_ADD_FORM = "//input[@id='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX_ADD_FORM = "//input[@id='employeeId']";
    public static final String SAVE_BUTTON_ADD_FORM = "//input[@id='btnSave']";

    // ** Personal Details Tab
    public static final String FULLNAME_HEADER_TEXT_PERSONAL_FORM = "//div[@id='profile-pic']/h1[text()='%s']";
    public static final String FIRSTNAME_TEXTBOX_PERSONAL_FORM = "//input[@id='personal_txtEmpFirstName']";
    public static final String LASTNAME_TEXTBOX_PERSONAL_FORM = "//input[@id='personal_txtEmpLastName']";
    public static final String EMPLOYEE_ID_TEXTBOX_PERSONAL_FORM = "//input[@id='personal_txtEmployeeId']";
    public static final String SSN_NUMBER_TEXTBOX_PERSONAL_FORM = "//input[@id='personal_txtNICNo']";
    public static final String GENDER_RADIO_PERSONAL_FORM = "//label[text()='%s']/preceding-sibling::input";
    public static final String MARITAL_STATUS_DROPDOWN_PERSONAL_FORM = "//select[@id='personal_cmbMarital']";
    public static final String NATIONALITY_DROPDOWN_PERSONAL_FORM = "//select[@id='personal_cmbNation']";
    public static final String DATE_OF_BIRTH_TEXTBOX_PERSONAL_FORM = "//input[@id='personal_DOB']";
    public static final String SUCCESS_MASSAGE_AT_PERSONAL_FORM = "//div[contains(@class,'message success')]";

    //** Salary Tab
    public static final String PAY_GRADE_DROPDOWN_SALARY_FORM = "//select[@id='salary_sal_grd_code']";
    public static final String SALARY_COMPONENT_TEXTBOX_SALARY_FORM = "//input[@id='salary_salary_component']";
    public static final String CURRENCY_DROPDOWN_SALARY_FORM = "//select[@id='salary_currency_id']";
    public static final String PAY_FREQUENCY_DROPDOWN_SALARY_FORM = "//select[@id='salary_payperiod_code']";
    public static final String AMOUNT_TEXTBOX_SALARY_FORM = "//input[@id='salary_basic_salary']";
    public static final String COMMENTS_TEXTBOX_SALARY_FORM = "//textarea[@id='salary_comments']";

    //** Job Tab
    public static final String JOB_TITLE_DROPDPWN_JOB_FORM = "";
    public static final String EMPLOYEE_STATUS_DROPDPWN_JOB_FORM = "";
    public static final String JOB_CATEGORY_TEXTBOX_JOB_FORM = "";
    public static final String JOIN_DATE_TEXTBOX_JOB_FORM = "";
    public static final String SUB_UNIT_DROPDPWN_JOB_FORM = "";
    public static final String LOCATION_DROPDPWN_JOB_FORM = "";
    public static final String START_DATE_TEXTBOX_JOB_FORM = "";
    public static final String END_DATE_TEXTBOX_JOB_FORM = "";

}
