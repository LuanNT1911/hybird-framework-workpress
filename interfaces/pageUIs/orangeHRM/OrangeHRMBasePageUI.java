package pageUIs.orangeHRM;

public class OrangeHRMBasePageUI {
    public static final String DYNAMIC_MENU_LINK = "//ul[@id='mainMenuFirstLevelUnorderedList']//a[string()='%s']";
    public static final String DYNAMIC_SIDEBAR_TAB_LINK = "//ul[@id='sidenav']//a[string()='%s']";
    public static final String DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER = "//h1[text()='%s']/parent::div/following-sibling::div//input[@value='%s']";
    public static final String DYNAMIC_TABLE_COLUMN_NAME_PRECEDING_SIBLING = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
    public static final String CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX = "//table[@id='%s']//tr[%s]/td[%s]";
    public static final String PASSWORD_TEXTBOX = "//input[@id='txtPassword']";
    public static final String LOGIN_BUTTON = "//input[@id='btnLogin']";
}
