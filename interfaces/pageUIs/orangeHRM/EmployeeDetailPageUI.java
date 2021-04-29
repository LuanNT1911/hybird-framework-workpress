package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
    public static final String FIRSTNAME_TEXTBOX_ADD_FORM = "//input[@id='firstName']";
    public static final String LASTNAME_TEXTBOX_ADD_FORM = "//input[@id='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX_ADD_FORM = "//input[@id='employeeId']";
    public static final String SAVE_BUTTON_ADD_FORM = "//input[@id='btnSave']";

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

}
