package com.resileo.seleniumweb;

public class ObjectRepository extends ObjectMap {

	public static final int Label = 0;

	// ******* Appedo Login **********
	String appedo_login_txtUsername = "xpath://input[@placeholder='Enter your email']";
	String appedo_login_txtPassword = "xpath://input[@placeholder='Enter your password']";
	String appedo_login_btnlogin = "id:btnlogin";
	String appedo_verifyLogin = "xpath://button[@class='mat-button ng-star-inserted']";

	// ******** Appedo Logout ***********
	String appedo_signout = "id:signout";
	String appedo_verifyLogout = "xpath://mat-card-title[@class='mat-card-title']";

	// ******* Registration ***********
	String appedo_reg_link = "id:register";
	String appedo_reg_txtUserID = "id:email";
	String appedo_reg_txtFirstName = "id:fname";
	String appedo_reg_txtLastName = "id:lname";
	String appedo_reg_txtPassword = "id:password";
	String appedo_reg_txtConfirmPassword = "id:confirm";
	String appedo_reg_txtMobile = "id:mobile_no";
	String appedo_reg_validate_txtUserID = "xpath://mat-error[@id='mat-error-1']";
	String appedo_reg_validate_txtFirstName = "xpath://mat-error[@id='mat-error-1']";
	String appedo_reg_validate_txtMobile = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_reg_btnSignup = "id:btnReqPass";
	String appedo_verifyRegistration = "id:overlay";
	String verify_pass_popups = "xpath://span[@class='clrblack']";

	// ************ Forgot Password *********
	String appedo_link_forgotPwd = "id:forgot";
	String appedo_txt_email = "xpath://input[@placeholder='Enter your email']";
	String appedo_btn_reqPwd = "id:btnReqPass";
	String appedo_btn_cancel = "id:btnCancel";
	String appedo_verifyMailSent = "xpath://span[@class='clrblack']";

	// *********** Download Agents **********
	String appedo_downloadAgents = "xpath://mat-icon[contains(text(),'cloud_download')]";
	String appedo_download_linuxAgent = "xpath://span[contains(text(),'Linux Agent')]";
	String Appedo_download_windowsAgent = "xpath://span[contains(text(),'Windows Agent')]";
	String Appedo_download_avlMonitorAgent = "xpath://span[contains(text(),'AVL Monitor Agent')]";
	String Appedo_download_avlMonitorNodeAgent = "xpath://span[contains(text(),'AVL Monitor Node Agent')]";
	String appedo_download_confirmation = "xpath://span[contains(text(),'Download')]";

	// ********** Appedo Menu ****************
	String appedo_settingMenu = "xpath://span[contains(text(),'Settings')]";
	String appedo_settingList = "xpath://span[contains(text(),'Alert Settings')]";
	String appedo_verify_settingMenu = "xpath://span[contains(text(),'Alert Settings')]";
	String appedo_dashboardMenu = "xpath://span[contains(text(),'Dashboard')]";
	String appedo_dropdown_myDashboard1 ="xpath://span[contains(text(),'000')]";
	String appedo_verify_dashBoardMenu = "xpath://span[contains(text(),'Charts')]";
	String appedo_verify_charts = "xpath://span[contains(text(),'Charts')]";
	String appedo_systemMetricsMenu = "xpath://span[contains(text(),'System Metrics')]";
	String appedo_verify_SystemMetrics = "xpath://mat-card-title[@class='mat-card-title']";
	String appedo_endUserMonitorsMenu = "xpath://span[contains(text(),'End User Monitors')]";
	String appedo_verify_endUserMonitorsMenu = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-external-monitors[1]/mat-tab-group[1]/mat-tab-header[1]/div[2]/div[1]/div[1]";
	String appedo_visualizerMenu = "xpath://span[contains(text(),'Visualizer')]";
	String appedo_verify_visualizerMenu = "xpath://mat-label[contains(text(),'Visualizer Module')]";
	String appedo_loadTestMenu = "xpath://span[contains(text(),'Load Testing')]";
	String appedo_verify_LoadTest = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-load-test[1]/mat-tab-group[1]/mat-tab-header[1]/div[2]/div[1]/div[1]";
	String appedo_selectTheme = "id:themesel";
	String appedo_verify_selectTheme = "xpath://div[@class='mat-menu-content']";
	String appedo_toggleMenu = "id:toggleMenu";
	String appedo_verify_toggleMenu = "xpath://div[contains(text(),'Scenarios')]";

	// ********** Select Theme ****************
	String appedo_darkBrown = "id:theme0";
	String appedo_lightBrown = "id:theme1";
	String appedo_darkIndigo = "id:theme2";
	String appedo_lightIndigo = "id:theme3";
	String verify_theme = "id:themesel";

	// ******* Settings Module *******
	// Settings - change password
	String appedo_link_Settings = "xpath://span[contains(text(),'Settings')]";
	String appedo_link_changePassword = "xpath://span[contains(text(),'Change Password')]";
	String appedo_verify_txtValidation_Changepswrd = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_txtName_oldPassword = "id:oldPassword";
	String appedo_txtName_newPassword = "id:newPassword";
	String appedo_txtName_confirmPassword = "id:confirm";
	String appedo_btnUpdate = "id:btnUpd";
	String appedo_verifyChangePassword = "xpath://span[@class='clrblack']";

	// Settings - update profile
	String appedo_link_updateProfile = "xpath://span[contains(text(),'Update Profile')]";
	String appedo_updateProfile_txtfName = "id:fname";
	String appedo_updateProfile_btnUpdate = "id:btnupd";
	String appedo_verify_updateProfile = "xpath://span[@class='clrblack']";
	String appedo_updateProfile_txtEmail = "id:email";
	String appedo_updateProfile_txtLname = "id:lname";
	String appedo_validation_updateProfile_txtEmail = "xpath:mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_updateProfile_txtFname = "xpath:mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_updateProfile_txtLname = "xpath:mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_updateProfile_txtMobile = "xpath:mat-error[@class='mat-error ng-star-inserted']";
	String appedo_updateProfile_mobile = "id:mobile_no";

	// Settings - Manage Enterprise
	String appedo_link_settings = "xpath://span[contains(text(),'Settings')]";
	String appedo_link_manageEnterprise = "xpath://span[contains(text(),'Manage Enterprise')]";
	String appedo_enterprise_btnCreate = "id:btnupd";
	String appedo_enterprise_txtEnterpriseName = "id:entName";
	String appedo_enterprise_txtEnterpriseDesc = "id:entDesc";
	String appedo_enterprise_btnSave = "id:btnadd";
	String appedo_verify_enterprise = "xpath://span[@class='clrblack']";
	String appedo_enterprise_btnCancel = "xpath://span[contains(text(),'Cancel')]";
	String appedo_validation_enterprise_txtName = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-enterprise[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_validation_enterprise_txtDesc = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-enterprise[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_editEnterprise = "id:edit0";
	String appedo_verify_editEnterprise = "xpath://span[@class='clrblack']";
	String appedo_deactivateEnterprise = "id:dea0";
	String appedo_verify_activateEnterprise = "xpath://span[contains(.,'Successfully Activated the Enterprise')]";
	String appedo_verify_deactivateEnterprise = "xpath://span[contains(.,'Successfully Deactivated the Enterprise')]";
	String appedo_activateEnterprise = "id:act0";
	String appedo_enterprise_mapUser = "xpath://tr[1]//td[5]//span[1]";
	String appedo_enterprise_email = "xpath://td[@class='mat-cell cdk-column-email_id mat-column-email_id ng-star-inserted']";
	String appeodo_enterprise_btnMapUser = "id:btnadd";
	String appedo_enterprise_verify = "xpath://span[@class='clrblack']";
	String appedo_enterprise_txtEmail = "id:email";
	String appedo_enterprise_txtFirstName = "id:fname";
	String appedo_enterprise_saveFinish = "xpath://span[contains(text(),'Save & Finish')]";
	String appedo_enterprise_removeMappedUser = "xpath://tr[1]//td[1]//mat-icon[1]";
	String appedo_enterprise_validateEmail = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-enterprise[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";

	// Alert setting - Mail
	String appedo_link_alertSettings = "xpath://span[contains(text(),'Alert Settings')]";
	String appedo_btnSaveNext = "id:btnsavenext";
	String appedo_alert_maxTryDuration = "id:tryCountDurationInMin";
	String appedo_alert_triggerFrequency = "id:triggerAlertEveryInMin";
	String appedo_alert_maxTrycount = "id:maxTryCount";
	String appedo_addAlert_email = "id:btnsavenext";
	String appedo_txtEmail = "id:email";
	String appedo_btnSaveAdd = "id:btnsaveadd";
	String appedo_btnSaveFinish = "id:btnsavefinish";
	String appedo_verify_mailAdded = "xpath://alert/div/span";
	String appedo_alertEdit = "xpath://tr[1]//td[1]//mat-icon[1]";
	String appedo_alertEditemail = "xpath://input[@id='email']";
	String appedo_alertEmail_update = "id:btnsavefinish";
	String appedo_verify_mailUpdate = "xpath://span[@class='clrblack']";
	String appedo_alertDelete = "xpath://tr[1]//td[2]//mat-icon[1]";
	String appedo_verify_mailDelete = "xpath://span[contains(.,'Successfully removed the selected record')]";
	String appedo_alertSetting_validate__txtMaxTry = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-alert-config[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_alertSetting_validate__txtAlertTriggerFrequency = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-alert-config[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_alertSetting_validate__txtMaxTrycount = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-alert-config[1]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";

	// Alert Setting - Mobile
	String appedo_txtMobile = "id:sms";
	String appedo_alertSms = "xpath://div[contains(text(),'SMS')]";
	String appedo_alertSms_addQuery="xpath://span[@class='mat-option-text']";
	String appedo_alertSms_filterBy="id:filterpopup";
	String appedo_alertSms_selectColumn="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]";
	String appedo_alertSms_selectAColumn="xpath://span[@class='mat-option-text']";
	String appedo_alertSms_filterValueType="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[3]/div[1]/div[1]/div[1]/input[1]";
	String appedo_alertSms_addToFilter="id:addtofilter";
	String appedo_alertSms_getOtp="xpath://table/tbody/tr[1]/td[8]/span";
	String appedo_alertSms_btnNext="id:btnnext";
	String appedo_alertSms_verify="xpath://a[contains(text(),'Verify')]";
	String appedo_alertSms_txtOtp="xpath://div/table/tbody/tr[1]/td[6]/span[1]/input";
	String appedo_alertSms_verifyOtp="xpath://mat-icon[@class='md-18 mat-icon notranslate mat-primary material-icons']";
	String appedo_alertSms_verifyStatus="xpath://table/tbody/tr[1]/td[5]";
	String appedo_alertSms_mobileNumber="xpath://table/tbody/tr[1]/td[4]";
	String appedo_alertSms_edit="xpath://table/tbody/tr[1]/td[1]";
	String appedo_alertSms_delete="xpath://table/tbody/tr[1]/td[2]";
	String appedo_alertSms_resend="xpath://a[contains(text(),'Resend')]";

	// ******************* Dash board Charts ****************
	String appedo_rum_link = "xpath://div[contains(text(),'Real User')]";
	String appedo_rum_viewGraphs = "id:drawchart0";
	String appedo_addTo_myChart = "id:addtomychart0";
	String appedo_rum_chartName = "id:mcName";
	String appedo_rum_chartName_save = "xpath://span[contains(text(),'Save')]";
	String verify_rum_chart_addedToDashboard = "xpath://span[@class='clrblack']";
	String verify_rum_chart_name_alreadyExists = "xpath://span[@class='clrblack']";
	String appedo_addTo_existsingChart = "xpath://mat-select[@id='ddMcName']";
	String appedo_menu = "id:toggleMenu";
	String appedo_link_dashboard = "xpath://mat-icon[contains(text(),'dashboard')]";
	String appedo_link_chart = "xpath://span[contains(text(),'Charts')]";

	// Adding chart to existing Dash board
	String appedo_select_existing_dbchart_dropdown = "id:ddMcName";
	String appedo_select_existing_dashboard = "xpath://span[contains(text(),'appedo2')]";
	String appedo_addTo_myChart1 = "xpath://div[@id='idx1']//span[@mattooltip='Add to MyChart']";
	String appedo_select_chart_added_dashboard = "xpath://span[contains(text(),'appedo2')]";
	String appedo_validate_added = "xpath://span[contains(text(),'browser wise Report RUM')]";
	String appedo_dropdown_myDashboard = "id:myDash";
	String testDD = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option";
	String appedo_myDashboard_list = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]";
	String appedo_removeChart="xpath://div[@id='idx1']//mat-icon[@class='clrred mat-icon notranslate material-icons mat-icon-no-color'][contains(text(),'highlight_off')]";

	// Resize chart
	String appedo_selectChart = "xpath://span[contains(text(),'chart1')]";
	String appedo_resizeChart = "xpath://mat-icon[@class='mat-icon notranslate mat-accent material-icons ng-star-inserted']";
	String appedo_resizeId = "id:idx0";
	String appedo_chartSize = "xpath://div[@id='idx0']//div[@class='ng-star-inserted']";
	String appedo_chart_resize = "id:chart-bottom-right-resize";
	String appedo_verify_selectdashBoard = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/app-login-header[1]/mat-toolbar[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]";
	String appedo_verifyResize = "xpath://span[@class='clrblack']";

	// **************** End User Monitors ***************
	// RUM
	String appedo_link_EndUserMonitors = "xpath://span[contains(text(),'End User Monitors')]";
	String appedo_rumlink = "xpath://div[contains(text(),'Real User')]";
	String appedo_addRum = "id:addrum";
	String appedo_rum_txtTestName = "id:RumName";
	String appedo_rum_txtTestDesc = "id:RumDesc";
	String appedo_rum_warning = "id:warning";
	String appedo_rum_critical = "id:critical";
	String appedo_minBreachCount = "id:minbreachcount";
	String appedo_rum_btnSave = "xpath://span[contains(text(),'Save')]";
	String appedo_rum_scriptDownload = "xpath://button[@class='mat-raised-button']";
	String appedo_validation_txtName = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_txtDesc = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_txtWaringThreshold = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_txtCriticalThreshold = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_validation_txtMinBreachCount = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_rum_icon_Cancel = "xpath://mat-icon[contains(text(),'cancel')]";
	String appedo_rum_verifyRUM = "xpath://span[@class='clrblack']";
	String appedo_Chart_remove_from_dashboard = "id:removeme0";
	String appedo_dashboard_verifyDelete = "xpath://span[@class='clrblack'";
	String appedo_rum_Edit = "id:edit0";
	String appedo_rum_Delete = "xpath://tr[1]//td[1]//mat-icon[1]";

	// SUM - URL
	String appedo_sum_EndUserMonitors = "xpath://span[contains(text(),'End User Monitors')]";
	String appedo_link_Sum = "xpath://div[contains(text(),'Synthetic User')]";
	String appedo_addSum = "id:addsum";
	String appedo_sum_txtTestname = "id:TestName";
	String appedo_sum_txtTesturl = "id:TestUrl";
	String appedo_sum_country = "id:Country";
	String appedo_sum_selectCtry = "xpath://span[contains(text(),'US')]";
	String appedo_sum_city = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[6]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
	String appedo_sum_selectCity = "xpath://mat-pseudo-checkbox[@class='mat-option-pseudo-checkbox mat-pseudo-checkbox ng-star-inserted']";
	String appedo_sum_btnSave = "xpath://span[contains(text(),'Save')]";
	String appedo_sum_txtTestName = "id:TestName";
	String appedo_sum_warning = "id:warning";
	String appedo_sum_critical = "id:critical";
	String appedo_sum_minBreachCount = "id:minBreachCnt";
	String appedo_sum_editRunEvery = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[3]/div[1]/div[1]/div[1]";
	String appedo_sum_editRunEvery15min = "xpath://span[contains(text(),'15 Mins')]";
	String appedo_sum_btnCancel = "xpath://span[contains(text(),'Cancel')]";
	String appedo_sum_edit = "xpath://table/tbody/tr[1]/td[2]";
	String appedo_sum_validatetxtTestName = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_validateTestUrl = "xpath://span[@class='clrblack']";
	String appedo_sum_validateWarning = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_validateCritical = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_validateMinBreachCount = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";

	// SUM - Transaction
	String appedo_sum_btntransaction = "id:testtypetrans";
	String appedo_sum_transactionclr = "id:testtrans2";
	String appedo_sum_transaction_warningValidation = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[3]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_transaction_criticalValidation = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[3]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_transaction_minBreachValidation = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[3]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_transaction_country = "id:Country";
	String appedo_sum_transaction_selectctry = "xpath://span[contains(text(),'US')]";
	String appedo_sum_transaction_city = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[5]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
	String appedo_sum_transaction_selectCity = "xpath://span[contains(text(),'Oregon')]";
	String appedo_sum_transaction_btnsave = "xpath://span[contains(text(),'Save')]";

	// SUM - Script
	String appedo_sum_btnScript = "id:testtypescript";
	String appedo_sum_script = "id:Script";
	String appedo_sum_script_validateWarning = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_script_validateCritical = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_script_validateMinBreachCount = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[4]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_sum_script_country = "id:Country";
	String appedo_sum_script_selectctry = "xpath://span[contains(text(),'US')]";
	String appedo_sum_script_city = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/sum-addedit-dialog[1]/div[2]/form[1]/div[6]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
	String appedo_sum_script_selectCity = "xpath://span[contains(text(),'Oregon')]";
	String appedo_sum_script_btnSave = "xpath://span[contains(text(),'Save')]";

	// Sum Activate Deactivate
	String appedo_DeactivateSum = "xpath://span[contains(text(),'Active')]";
	String appedo_deactivateStatus = "xpath://table/tbody/tr[1]/td[7]";

	// SUM Scroll down
	String appedo_sumScroll = "xpath://mat-tab-body[@id='mat-tab-content-0-1']/div/div[2]/div";
	String appedo_scrollStart = "xpath://td[contains(text(),'4520')]";
	String appedo_scrollEnd = "xpath://td[contains(text(),'4571')]";

	// Sum enterprise
	String appedo_dropdown_enterprise = "xpath://mat-select[@name='entselect']";
	String appedo_selectEnterpriseRum = "xpath://span[contains(text(),'EnterpriseForTest')]";
	String appedo_drilDownicon = "xpath://mat-icon[contains(text(),'schedule')]";
	String appedo_enterpriseSumEdit = "id:edit0";
	String appedo_verifyEdit = "xpath://span[@class='clrblack']";
	String appedo_enterprise_viewChart = "id:drawchart0";

	// SUM enterprise User
	String appedo_enterpriseSumDelete = "xpath://mat-icon[@mattooltip='Only owner can delete']";

	// Appedo_viewSUMgraph
	String appedo_sum_viewGraph = "id:drawchart0";
	String appedo_sum_viewGraph_slider12hrs = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/app-login-header[1]/mat-toolbar[1]/div[2]/div[1]/mat-slider[1]/div[1]/div[2]/div[1]";
	String appedo_sum_viewGraph_btnapplySelection = "id:applyDtControls";
	
	// Autorefresh Functionality
	String appedo_autoRef="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-dashboard[1]/div[1]/div[2]/mat-chip-list[1]/div[1]/mat-chip[1]";
	String appedo_autoRefStart="xpath://mat-chip[@mattooltip='Click to start the auto refresh']";
	
	// Calendar
	String appedo_datepickerSwitch="id:switch";
	String appedo_datepickerFromDate="id:fromdate";
	String appedo_datepickerToDate="id:todate";
	String appedo_fromDateFunction="xpath://mat-datetimepicker-content[@class='mat-datetimepicker-content ng-star-inserted']";
	String appedo_selectTodaydate="xpath://div[@class='mat-datetimepicker-calendar-body-cell-content mat-datetimepicker-calendar-body-selected mat-datetimepicker-calendar-body-today']";
	String appedo_selectCurrentTime="xpath://div[@class='mat-datetimepicker-clock-cell mat-datetimepicker-clock-cell-selected ng-star-inserted']";
	String appedo_selectCurrentMin="xpath://div[@class='mat-datetimepicker-clock-minutes active']//div[@class='mat-datetimepicker-clock-cell ng-star-inserted'][contains(text(),'20')]";
	String appedo_selectCurDateMsg="xpath://span[@class='clrblack']";
	

	// AVM - GET
	String appedo_link_avm = "xpath://div[contains(text(),'Availability Monitor')]";
	String appedo_addAvm = "id:addavm";
	String appedo_avm_txtTestName = "id:TestName";
	String appedo_avm_txtTestUrl = "id:TestUrl";
	String appedo_avm_requestMethod = "name:ReqMethod";
	String appedo_avm_btnTestReq = "xpath://span[contains(text(),'Test Request')]";
	String appedo_avm_responseBody = "xpath://p[contains(text(),'<!DOCTYPE html>')]";
	String appedo_avm_headers = "xpath://h4[contains(text(),'Headers')]";
	String appedo_avm_view = "xpath://div[@class='ng-star-inserted']//h3";
	String appedo_avm_tabLabels = "xpath://div[@class='mat-tab-labels']";
	String appedo_avm_successStatusTrue = "xpath://span[contains(text(),'true')]";
	String appedo_avm_successStatusfalse = "xpath://span[contains(text(),'false')]";
	String appedo_avm_linkSchedule = "xpath://div[contains(text(),'Schedule')]";
	String appedo_avm_testDetails = "xpath://div[contains(text(),'Test Details')]";
	String appedo_avm_runEvery = "name:RunEvery";
	String appedo_avm_selectRunEvery = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
	String appedo_avm_txtMinBreachCnt = "id:MinBreachCnt";
	String appedo_avm_country = "id:Country";
	String appedo_avm_selectCountry = "xpath://span[contains(text(),'united states')]";
	String appedo_avm_city = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[2]/div[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]";
	String appedo_avm_selectCity = "xpath://span[contains(text(),'oregon-')]";
	String appedo_avm_verifyadd = "xpath://span[@class='clrblack']";
	String appedo_avm_btnsave = "xpath://span[contains(text(),'Save')]";
	String appedo_avm_validate_testName = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_avm_validate_testNameUrl = "xpath://mat-error[@class='mat-error ng-star-inserted']";
	String appedo_avm_responseTime = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[3]/div[1]/div[1]/h3[1]/span[2]/span[1]";
	String appedo_avm_statusCode = "xpath://span[@class='clrgreen'][contains(text(),'200')]";
	String appedo_avm_Status = "xpath://span[contains(text(),'OK')]";
	String appedo_avm_editCity = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[2]/div[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]/div[1]";
	String appedo_avm_editSelectcity = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[1]/span[1]";

	// AVM - HEAD
	String appedo_avm_requestMethodHead = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[3]/span[1]";
	String appedo_TestReqHeaders = "xpath://div[@class='bdrbtm1px']";

	// AVM - POST
	String appedo_avm_selectrequestMethod = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
	String appedo_avm_contentType = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[3]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]";
	String appedo_avm_selectContentType = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[5]/span[1]";
	String appedo_avm_responseBW = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[3]/div[1]/div[1]/h3[1]/span[3]";
	String appedo_avm_ResponseBody = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[3]/div[1]/div[1]/p[1]";
	String appedo_avm_ReqBodyTxt = "id:ReqBody";
	String appedo_avm_postStatusCode = "xpath://span[@class='clrgreen'][contains(text(),'201')]";
	String appedo_avm_postStatus = "xpath://span[contains(text(),'Created')]";
	String appedo_avm_postBandWidth = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[3]/div[1]/div[1]/h3[1]/span[3]";
    //String appedo_avm_verify = "xpath://div[@class='cdk-overlay-container lightindigotheme']";
	
	// AVM - PUT
	String appedo_avm_requestMethodPUT = "xpath://span[contains(text(),'PUT')]";
	String appedo_avm_resBodyPUT = "xpath://h4[contains(text(),'Response Body')]";
	String appedo_avm_resStatuscode = "xpath://span[contains(text(),'200')]";
	String appedo_avm_putStatus = "xpath://span[contains(text(),'OK')]";

	// AVM - WSDL
	String appedo_avm_reqMethodWsdl = "xpath://span[contains(text(),'WSDL')]";
	String appedo_avm_header = "xpath://div[contains(text(),'Headers 5')]";
	String appedo_avm_expandHeader = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/avm-addedit-dialog[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[2]/div[1]/div[1]/mat-icon[1]";
	String appedo_avm_removeHeaderAccept = "xpath://div[@class='ng-untouched ng-pristine ng-valid']//div[1]//div[1]//mat-icon[1]";
	String appedo_avm_removeHeaderAcceptLanguage = "xpath://div[@class='ng-untouched ng-pristine ng-valid']//div[1]//div[1]//mat-icon[1]";
	String appedo_avm_removeHeaderConnection = "xpath://div[@class='ng-untouched ng-pristine ng-valid']//div[1]//div[1]//mat-icon[1]";
	String appedo_avm_removeHeaderUserAgent = "xpath://mat-icon[@class='pointer mat-icon notranslate mat-warn material-icons ng-star-inserted']";
	String appedo_avm_headerContentType = "id:Name0";
	String appedo_avm_removeHeaderContentType = "xpath://mat-icon[@class='pointer mat-icon notranslate mat-warn material-icons ng-star-inserted']";
	String appedo_avm_addHeader = "xpath://mat-icon[@class='pointer mat-icon notranslate mat-primary material-icons']";
	String appedo_avm_addAcceptEncoding = "id:Name1";
	String appedo_avm_addValueAcceptEncoding = "id:Value1";
	String appedo_avm_addValueContentType = "id:Value0";
	String appedo_avm_addSoapAction = "id:Name2";
	String appedo_avm_addValueSoapAction = "id:Value2";

	// AVM - View Graphs
	String appedo_avmViewGraph = "id:drawchart0";
	String appedo_avm_addTochart = "xpath://div[@id='idx0']//span[@class='mgnleft10 pointer ng-star-inserted']";
	String appedo_avm_chartName = "id:mcName";
	String appedo_avm_btnSaveChart = "xpath://button[@class='mat-raised-button mat-primary ng-star-inserted']";
	String appedo_verifyChartAdded = "xpath://span[@class='clrblack']";
	String appedo_myDashboardDropdown = "id:ddMcName";
	String appedo_selectMyDashboard = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[3]/span[1]";
	String appedo_selectMyDashboard1 = "xpath://span[contains(text(),'000')]";
	String appedo_dashboardDropdown = "id:myDash";
	//String appedo_selectDashboard = "xpath://span[contains(text(),chartName)]";
			//"xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/app-login-header[1]/mat-toolbar[1]/div[3]/mat-form-field[2]/div[1]/div[1]/div[1]";
	String appedo_removeChartclick = "xpath://div[@id='idx0']//mat-icon[@class='clrred mat-icon notranslate material-icons mat-icon-no-color'][contains(text(),'highlight_off')]";

	// AVM - SLA policy
	String appedo_avm_policy = "id:alert0";
	String appedo_avm_alert1polnamePattern = "xpath://td[contains(text(),'ENOTFOUND for AVM Test Id ')]";
	String appedo_avm_alert2polnamePattern = "xpath://td[contains(text(),'ETIMEDOUT for AVM Test Id ')]";
	String appedo_avm_alert3polnamePattern = "xpath://td[contains(text(),'ECONNREFUSED for AVM Test Id ')]";
	String appedo_avmAlertcancel = "xpath://mat-icon[contains(text(),'cancel')]";
	String appedo_avmValuebasedAlert = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/mat-tab-group[1]/mat-tab-header[1]/div[2]/div[1]/div[1]/div[2]";
	String appedo_avm_alert1polnameVal = "xpath://td[contains(text(),'Status Code for AVM Test Id ')]";
	String appedo_avm_alert2polnameVal = "xpath://td[contains(text(),'Response Time for AVM Test Id ')]";
	String appedo_avm_configAlertTable = "id:mat-dialog-1";
	String appedo_avmDel = "id:del0";

	// AVM - Alert Setting
	String appedo_avm_alert_edit = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[2]/mat-icon[1]";
	String appedo_avm_alert_delete = "xpath://table/tbody/tr[4]/td[1]";
	
	// AVM Details
	String appedo_avm_details="xpath://table/tbody/tr[4]/td[10]";
	String appedo_avm_details_totalRows="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/log-details[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/mat-label[1]";
	String appedo_avm_details_displayedRows="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/log-details[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/mat-label[2]";
	String appedo_avm_details_filteredRows="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/log-details[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/mat-label[3]";
	String appedo_avm_details_txtfilter="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/log-details[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]";
	String appedo_avm_details_rowsFiltered="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/log-details[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/mat-label[3]";
	
	//AVM Location
	String appedo_linkavm_Location="xpath://div[contains(text(),'Availability Location')]";
	String appedo_addAvl = "id:addavl";
	String appedo_txtCountry="id:Country";
	String appedo_txtState="id:State";
	String appedo_txtRegion="id:Region";
	String appedo_txtZone="id:Zone";
	String appedo_txtCity="id:City";
	String appedo_BtnSave="xpath://span[contains(text(),'Save')]";
	String appedo_iconAlert="id:alert0";
	String appedo_addAlert="xpath://span[contains(text(),'Add Alerts')]";
	String appedo_txtemailAVL="id:email";
	String appedo_iconEdit="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/avl-alert-dialog[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/mat-icon[1]";
	String appedo_iconDelete="xpath://mat-icon[@mattooltip='Remove Alert']";
	String appedo_BtnSaveadd="xpath://span[contains(text(),'Save & Add')]";
	String appedo_Btncancel="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/avl-alert-dialog[1]/div[1]/mat-icon[1]";
	String appedo_iconDel="id:del0";
	
	// ******** Visualizer Module *********
	// DB - Add, edit & delete
	String appedo_link_Visualizer = "xpath://span[contains(text(),'Visualizer')]";
	String appedo_addDB = "id:dbconn";
	String appedo_db_txtEngineName = "name:EngineName";
	String appedo_db_txtSelectEngineName = "xpath://span[contains(text(),'PostgreSQL')]";
	String appedo_db_txtHost = "id:Host";
	String appedo_db_txtDBuser = "id:DBUser";
	String appedo_db_txtDatabase = "id:Database";
	String appedo_db_portNumber = "id:Port";
	String appedo_db_txtDBpassword = "id:DBPassword";
	String appedo_db_btnSave = "id:save";
	String appedo_db_validateEngineName = "xpath://span[contains(text(),'Engine Name')]";
	String appedo_db_validateHost = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-addedit-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_db_validatetxtDBUser = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-addedit-dialog[1]/div[2]/form[1]/div[3]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_db_validatetxtDatabase = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-addedit-dialog[1]/div[2]/form[1]/div[1]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_db_validatePort = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-addedit-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_db_validatetxtDBPassword = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-addedit-dialog[1]/div[2]/form[1]/div[3]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_db_verify = "xpath://span[@class='clrblack']";
	String appedo_db_mapEnterprise = "id:mapent0";
	String appedo_db_addEnterprise = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-ent-map[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]";
	String appedo_db_selectEnterprise = "xpath://span[@class='mat-option-text']";
	String appedo_db_addIcon = "id:mapent";
	String appedo_db_saveEnterprise = "id:save";
	String appedo_db_removeEnterprise = "id:removeent0";
	
	// Add Query
	String appedo_db_addQuery = "id:addqry0";
	String appedo_db_addQuery_selectTable = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]";
	String appedo_db_addQuery_selectFromTable = "xpath:/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/mat-option[1]/span[1]";
	String appedo_db_addQuery_groupBy = "id:grouppopup";
	String appedo_db_addQuery_groupColumn = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[1]/div[1]/div[1]/div[1]";
	String appedo_db_addQuery_selectGroupColumn = "xpath://span[contains(text(),'module_code')]";
	String appedo_db_addQuery_addToGroup = "id:addtogroup";
	String appedo_db_addQuery_view = "id:popupagg";
	String appedo_db_addQuery_aggregator = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[3]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[1]/div[1]/div[1]/div[1]";
	String appedo_db_addQuery_selectAggregator = "xpath://span[contains(text(),'Count of Rows')]";
	String appedo_db_addQuery_addToColumn = "id:addtoagg";
	String appedo_db_addQuery_orderBy="id:popuporderby";
	String appedo_db_addQuery_orderBy_selectColumn="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[4]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_orderBy_selectAColumn="xpath://span[contains(text(),'Column Index 0')]";
	String appedo_db_addQuery_addToOrderBy="id:addtoagg";
	String appedo_db_addQuery_runQuery = "id:runquery";
	String appedo_db_verify_addQuery = "xpath://button[contains(text(),'module_code')]";
	String appedo_db_addQuery_saveQuery = "id:savequery";
	String appedo_db_addQuery_txtQueryName = "id:queryName";
	String appedo_db_addQuery_txtDesc = "id:queryDesc";
	String appedo_db_addQuery_btnSave = "id:save";
	String appedo_db_addQuery_close = "id:goback";
	String appedo_db_verify_saveQuery = "xpath://span[@class='clrblack']";
	String appedo_db_verifyAddedChart="cssSelector:body.mat-typography:nth-child(2) div.wrapper.lightindigotheme app-sidenav.ng-star-inserted:nth-child(2) mat-sidenav-container.mgntop10.mat-drawer-container.mat-sidenav-container.mat-drawer-transition:nth-child(2) mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-dashboard.ng-star-inserted:nth-child(2) div.mgnleft10.mgnrgt10.dbwrapper85:nth-child(2) div.mat-elevation-z8.mgntop10.dbwrapper85.ng-star-inserted:nth-child(41) div.ng-star-inserted > span.font_14.mgnleft5:nth-child(1)";
	String appedo_db_removeChart="xpath://span[@id='removeme1']//mat-icon[@class='clrred mat-icon notranslate material-icons mat-icon-no-color'][contains(text(),'highlight_off')]";
	
	// View Query
	String appedo_db_viewQueries = "id:grdqry0";
	String appedo_db_editViewQueries = "id:confiqquery0";
	String appedo_db_removeOrderBy="id:removeOrderCol0";
	String appedo_db_selectOrderBy="xpath://span[contains(text(),'Column Index 1')]";
	String appedo_db_orderBy_sortBy="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[4]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]";
	String appedo_db_orderBy_desc="xpath://span[contains(text(),'DESC')]";
	String appedo_db_refreshQuery="id:runquery";
	String appedo_db_viewQuery_mapEnterprise = "id:mapent0";
	String appedo_db_viewQuery_mapEnterpriseQuery = "id:mapent";
	String appedo_db_viewQuery_addEnterprise = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/db-ent-map[1]/div[2]/div[1]/mat-form-field[1]/div[1]";
	String appedo_db_viewQuery_EnterpriseName = "xpath://span[contains(text(),'Sample01')]";
	String appedo_visualization_click = "name:visualization";
	String appedo_selectArrow = "xpath://mat-select[@id='mat-select-5']//div[@class='mat-select-arrow']";
	String appedo_visualizerChartTypeStamp = "id:visual1";
	String appedo_chartTypeStampValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/mat-chip-list[1]/div[1]";
	String appedo_visualizerChartTypePie = "id:visual2";
	String appedo_visualizerChartTypePie3d = "id:visual3";
	String appedo_chartTypePieValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/*";
	String appedo_visualizerChartTypeDonut = "id:visual4";
	String appedo_chartTypeDonutValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]";
	String appedo_visualizerChartTypeDonut3d = "id:visual5";
	String appedo_chartTypeDonut3dValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/*";
	String appedo_visualizerChartTypeHbar = "id:visual6";
	String appedo_chartTypeHbarValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/*";
	String appedo_visualizerChartTypeOthers = "id:visual7";
	String appedo_chartTypeOthersValidation = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/*";
	String appedo_db_deleteViewQueries = "id:delqry0";
	String appedo_db_addQuery_verifyRefreshQuery = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/section[1]/div[1]/*";
	
	// Drill Down 
	String appedo_db_addQuery_filterBy="id:filterpopup";
	String appedo_db_addQuery_SelcolName="xpath://input[@placeholder='Select Column']";
	String appedo_db_addQuery_selUserID="xpath://span[contains(text(),'user_id')]";
	String appedo_db_addQuery_filVal="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/mat-card[1]/mat-card-content[1]/mat-form-field[3]/div[1]/div[1]/div[1]/input[1]";
	String appedo_db_BtnaddtoFilter="id:addtofilter";
	String appedo_db_filBySelModulecode="xpath:/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/mat-option[1]/span[1]";
	String appedo_db_edit2ViewQueries = "id:confiqquery1";
	String appedo_db_editGetid="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-title[1]/div[1]/mat-label[1]";
	String appedo_db_editMapDrilldownChartId="xpath://input[@placeholder='Map Drilldown chart id']";
	String appedo_db_editAddtochart="id:addtomychart";
	String appedo_db_editDashboardName="id:mcName";
	String appedo_db_editBtnSave="xpath://span[contains(text(),'Save')]";
	String appedo_db_dashboardRemove="xpath://div[@id='idx0']//span[@class='mgnleft10 pointer ng-star-inserted']";
	
	// Parameterization
	String appedo_db_addQuery_addGroup="id:addgroup";
	String appedo_db_addQuery_addGroupColumn="xpath://span[contains(text(),'user_id')]";
	String appedo_db_addQuery_configureColumn="id:configColumn";
	String appedo_db_addQuery_configure_columnDataType1="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/config-column[1]/div[2]/form[1]/div[1]/div[1]/div[1]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_configure_selectColumnDataType1="xpath://span[contains(text(),'text')]";
	String appedo_db_addQuery_configure_mapParam1="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/config-column[1]/div[2]/form[1]/div[1]/div[1]/div[1]/mat-form-field[4]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_configure_selectParam1="xpath://span[contains(text(),'param1')]";
	String appedo_db_addQuery_configure_columnDataType2="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/config-column[1]/div[2]/form[1]/div[1]/div[2]/div[1]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_configure_selectColumnDataType2="xpath://span[contains(text(),'count')]";
	String appedo_db_addQuery_configure_mapParam2="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/config-column[1]/div[2]/form[1]/div[1]/div[2]/div[1]/mat-form-field[4]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_configure_selectParam2="xpath://span[contains(text(),'param2')]";
	String appedo_db_addQuery_configure_columnDataType3="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/config-column[1]/div[2]/form[1]/div[1]/div[3]/div[1]/mat-form-field[2]/div[1]/div[1]/div[1]/mat-select[1]";
	String appedo_db_addQuery_configure_selectColumnDataType3="xpath://span[contains(text(),'rows')]";
	String appedo_db_addQuery_configure_save="id:save";
	String appedo_db_addQuery_advanceSql="xpath://span[@class='mat-checkbox-label']";
	String appedo_db_addQuery_SqlCustomQuery="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/textarea[1]";
	String appedo_db_addQuery_txtParam1="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[3]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]";
	String appedo_db_addQuery_txtParam2="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[3]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]";
	String appedo_db_addQuery_apply="xpath://span[contains(text(),'Apply')]";
	String appedo_db_addQuery_refreshQuery="id:runquery";
	String appedo_db_viewQuery_mapDrillDownChartID="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/db-addedit-query[1]/mat-card[1]/mat-card-content[1]/div[1]/div[2]/div[1]/mat-form-field[2]/div[1]/div[1]/div[1]/span[1]";
	String appedo_db_viewQuery_addToMyChart="id:addtomychart";
	
	
	// Scheduler
	String appedo_db_scheduler = "id:opensche0";
	String appedo_db_scheduler_reportTitle = "id:ReportTitle";
	String appedo_db_scheduler_reportDesc = "id:ReportDesc";
	String appedo_db_scheduler_attachment = "xpath://mat-checkbox[@id='mat-checkbox-2']//div[@class='mat-checkbox-inner-container']";
	String appedo_db_verifyAttachment = "xpath://span[contains(text(),'Send As Attachment')]";
	String appedo_db_scheduler_selectFrequency = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/qry-scheduler[1]/div[2]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]/div[1]"; // ng-touched']//div[@class='mat-form-field-infix']";
	String appedo_db_scheduler_frequencyMonthly = "id:freq4";
	String appedo_db_scheduler_frequencyWeekly = "id:freq2";
	String appedo_db_scheduler_frequency = "xpath://table/tbody/tr[1]/td[7]";
	String appedo_db_scheduler_status = "xpath://span[contains(text(),'Activate Scheduler')]";
	String appedo_db_scheduler_mapEmail = "id:configemail0";
	String appedo_db_scheduler_addEmail = "id:addemail";
	String appedo_db_scheduler_txtEmail = "id:email0";
	String appedo_db_scheduler_removeEmail = "id:removeemail0";
	String appedo_db_mapEnterprise_delete = "id:removeent0";
	String appedo_editDB = "id:editdbconn0";
	String appedo_deleteDB = "id:deldbconn0";
	String verify_pass_popup = "xpath://span[@class='clrblack']";

	// ********** System Metrics *************
	// View Graph - OS
	String appedo_link_systemMetrics = "xpath://span[contains(text(),'System Metrics')]";
	String OAD_sysAdmin_sysName = "xpath://td[contains(text(),'Amazon Linux 2')]";
	String appedo_view_os_Graph1 = "xpath://span[contains(text(),'43694')]";
	String appedo_view_os_Graph2 = "xpath://span[contains(text(),'43695')]";
	String appedo_view_os_Graph3 = "xpath://span[contains(text(),'43693')]";
	String appedo_view_os_Graph4 = "xpath://span[contains(text(),'43692')]";
	String appedo_view_os_Graph5 = "xpath://span[contains(text(),'43696')]";
	
	// View Graph - Application
	String appedo_app = "xpath://tbody//tr[1]//td[5]";
	String appedo_app_graph = "xpath://table/tbody/tr[2]/td[10]";
	String appedo_app_dashboard_chart_name = "xpath://input[@placeholder='Dashboard Name']";
	String appedo_app_dashboard_chart_save = "xpath://span[contains(text(),'Save')]";
	String appedo_view_app_Graph1 = "xpath://span[contains(text(),'43900')]";
	String appedo_view_app_Graph2 = "xpath://span[contains(text(),'43902')]";
	String appedo_view_app_Graph3 = "xpath://span[contains(text(),'43901')]";
	String appedo_view_app_Graph4 = "xpath://span[contains(text(),'43899')]";
	String appedo_view_app_Graph5 = "xpath://span[contains(text(),'43898')]";
	
	// View Graph - DB
	String appedo_Db = "xpath://tbody//tr[1]//td[6]";
	String appedo_Db_graph = "xpath://table/tbody/tr[1]/td[10]";
	String appedo_Db_dashboard_chart_name = "xpath://input[@placeholder='Dashboard Name']";
	String appedo_Db_dashboard_chart_save = "xpath://span[contains(text(),'Save')]";
	String appedo_view_Db_Graph1 = "xpath://span[contains(text(),'43824')]";
	String appedo_view_Db_Graph2 = "xpath://span[contains(text(),'43822')]";
	String appedo_view_Db_Graph3 = "xpath://span[contains(text(),'43823')]";
	String appedo_view_Db_Graph4 = "xpath://span[contains(text(),'43821')]";
	String appedo_view_Db_Graph5 = "xpath://span[contains(text(),'43831')]";

	// OAD - Edit Delete
	String appedo_oad_edit = "xpath://mat-icon[contains(text(),'edit')]";
	String appedo_oad_name = "id:module_name";
	String appedo_oad_desc = "id:modDesc";
	String appedo_oad_save = "xpath://span[contains(text(),'Save')]";
	String appedo_oad_del = "xpath://table/tbody/tr[1]/td[1]";

	// System Metrics Status
	String appedo_SystemMetrics_btnOS = "xpath://table/tbody/tr[1]/td[4]";
	String appedo_SystemMetrics_btnapp = "xpath://table/tbody/tr[1]/td[5]";
	String appedo_SystemMetrics_btnDB = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_SystemMetrics_btnLog = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-system-details[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/span[1]";
	String appedo_SystemMetrics_btnNetwork = "xpath://table/tbody/tr[1]/td[8]";
	String appedo_SystemMetrics_btnNetprofiler = "xpath://table/tbody/tr[1]/td[9]";
	String appedo_SystemMetrics_btnLogChart = "xpath://table/tbody/tr[1]/td[7]";
	String appedo_SystemMetrics_btnLogCharticon = "xpath://tr[1]//td[7]//mat-icon[1]";
	String appedo_btnsystem_metricsMenu = "xpath://span[contains(text(),'System Metrics')]";

	// Configure Metrics - OS
	String appedo_systemMetrics_os = "xpath://tbody//tr[1]//td[4]";
	String appedo_systemMetrics_os_configure = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_systemMetrics_os_selectCategory = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]/span[1]";
	String appedo_systemMetrics_os_category = "xpath://span[contains(text(),'bitlocker')]";
	String appedo_systemMetrics_os_category_selectCheckbox = "xpath://span[contains(text(),'Max Read Split Size')]";
	String appedo_systemMetrics_os_btnUpdate = "xpath://span[contains(text(),'Update')]";
	String appedo_verify_configureMetrics = "xpath://span[@class='clrblack']";
	String appedo_systemMetrics_os_drawChart = "xpath://mat-icon[contains(text(),'show_chart')]";
	String appedo_systemMetrics_os_addedChart = "cssSelector:body.mat-typography:nth-child(2) div.wrapper.lightindigotheme app-sidenav.ng-star-inserted:nth-child(2) mat-sidenav-container.mgntop10.mat-drawer-container.mat-sidenav-container.mat-drawer-transition:nth-child(2) mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-dashboard.ng-star-inserted:nth-child(2) div.mgnleft10.mgnrgt10.dbwrapper85:nth-child(2) div.mat-elevation-z8.mgntop10.ng-star-inserted.dbwrapper85:nth-child(40) div.ng-star-inserted > span.font_14.mgnleft5";
	String appedo_systemMetrics_removeCategory = "xpath://span[contains(text(),'bitlocker.Max Read Split Size')]";
	
	// Configure Metrics - APP
	String appedo_systemMetrics_app = "xpath://table/tbody/tr[1]/td[5]";
	String appedo_systemMetrics_app_configure = "xpath://mat-icon[@class='pointer mat-icon notranslate mat-warn material-icons ng-star-inserted'][contains(text(),'settings')]";
	String appedo_systemMetrics_app_selectCategory = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]/span[1]";
	String appedo_systemMetrics_app_category = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[4]/span[1]";
	String appedo_systemMetrics_app_category_selectCheckbox = "xpath://span[contains(text(),'Application Restarts')]";
	String appedo_systemMetrics_app_btnUpdate = "xpath://span[contains(text(),'Update')]";
	String appedo_systemMetrics_app_drawChart = "xpath://mat-icon[contains(text(),'show_chart')]";
	String appedo_systemMetrics_app_addedChart = "cssSelector:body.mat-typography:nth-child(2) div.wrapper.lightindigotheme app-sidenav.ng-star-inserted:nth-child(2) mat-sidenav-container.mgntop10.mat-drawer-container.mat-sidenav-container:nth-child(2) mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-dashboard.ng-star-inserted:nth-child(2) div.mgnleft10.mgnrgt10.dbwrapper85:nth-child(2) div.mat-elevation-z8.mgntop10.dbwrapper85.ng-star-inserted:nth-child(43) div.ng-star-inserted > span.font_14.mgnleft5";
	String appedo_systemMetrics_app_removeCategory = "xpath://span[contains(text(),'asp.net.Application Restarts')]";
	
	// Configure Metrics - DB
	String appedo_systemMetrics_db = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_systemMetrics_db_configure = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_systemMetrics_db_selectCategory = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[1]/span[1]/span[1]";
	String appedo_systemMetrics_db_category = "xpath://span[@class='mat-option-text'][contains(text(),'connections')]";
	String appedo_systemMetrics_db_selectCheckbox = "xpath://span[contains(text(),'Active Connections')]";
	String appedo_systemMetrics_db_btnUpdate = "xpath://span[contains(text(),'Update')]";
	String appedo_systemMetrics_db_drawChart = "xpath://table/tbody/tr[1]/td[10]";
	String appedo_systemMetrics_db_addedChart = "cssSelector:body.mat-typography:nth-child(2) div.wrapper.lightindigotheme app-sidenav.ng-star-inserted:nth-child(2) mat-sidenav-container.mgntop10.mat-drawer-container.mat-sidenav-container.mat-drawer-transition:nth-child(2) mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-dashboard.ng-star-inserted:nth-child(2) div.mgnleft10.mgnrgt10.dbwrapper85:nth-child(2) div.mat-elevation-z8.mgntop10.ng-star-inserted.dbwrapper85:nth-child(40) div.ng-star-inserted > span.font_14.mgnleft5:nth-child(1)";
	String appedo_systemMetrics_db_removeCategory = "xpath://span[contains(text(),'connections.Active Connections')]";

	// View OAD Graph - OS
	String appedo_os = "xpath://tbody//tr[1]//td[4]";
	String appedo_os_graph = "xpath://mat-icon[contains(text(),'show_chart')]";
	String appedo_os_graph1 = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-module-details[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[10]/mat-icon[1]";
	String appedo_oad_addToDashboard = "xpath://div[@id='idx1']//mat-icon[@class='mat-icon notranslate mat-warn material-icons'][contains(text(),'pie_chart')]";
	String verify_oad_chart_name_alreadyExists = "xpath://span[@class='clrblack']";
	String appedo_os_dashboard_chart_name = "xpath://input[@placeholder='Dashboard Name']";
	String appedo_os_dashboard_chart_save = "xpath://span[contains(text(),'Save')]";

	// View OAD Graph - DB
	String appedo_configDB = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_configCustomListConnection = "xpath://span[@class='mat-option-text'][contains(text(),'cache')]";
	String appedo_configCustomListConnection1 = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
	String appedo_customMenu = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[2]/div[1]/div[1]/mat-checkbox[1]/label[1]/span[1]";
	String appedo_customDBAddedChart = "cssSelector:body.mat-typography:nth-child(2) div.wrapper.lightindigotheme app-sidenav.ng-star-inserted:nth-child(2) mat-sidenav-container.mgntop10.mat-drawer-container.mat-sidenav-container.mat-drawer-transition:nth-child(2) mat-sidenav-content.mat-drawer-content.mat-sidenav-content:nth-child(5) app-dashboard.ng-star-inserted:nth-child(2) div.mgnleft10.mgnrgt10.dbwrapper85:nth-child(2) div.mat-elevation-z8.mgntop10.dbwrapper85.ng-star-inserted:nth-child(40) div.ng-star-inserted > span.font_14.mgnleft5";
	String appedo_customRemoveConfig = "xpath://span[contains(text(),'connections.aaadb')]";

	// View OAD Graph -APP
	String appedo_customSelectApp = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
	String appedo_customListHttp = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[11]/span[1]";

	// Add Custom Metrics
	String appedo_systemMetrics_addcustom = "xpath://tr[1]//td[9]//mat-icon[1]";
	String appedo_systemMetrics_createMetrics = "id:categorySelection";
	String appedo_systemMetrics_customSelect = "xpath://span[contains(text(),'Memory')]";
	//String appedo_systemMetrics_customSelect = "xpath://span[contains(text(),'Database ==> Instances')]";
	String appedo_systemMetrics_counterName = "id:CounterNameCM";
	String appedo_systemMetrics_unit = "name:UnitCM";
	String appedo_systemMetrics_counterDesc = "id:CounterDescCM";
	String appedo_systemMetrics_query = "id:QryStringCM";
	String appedo_systemMetrics_selectUnit = "xpath://span[contains(text(),'%')]";
	String appedo_systemMetrics_customError = "className:mat-error ng-star-inserted";
	String appedo_systemMetrics_customDescError = "className:mat-error ng-star-inserted";
	String appedo_systemMetrics_customQueryError = "className:mat-error ng-star-inserted";
	String appedo_systemMetrics_customSave = "xpath://span[contains(text(),'Save')]";
	String appedo_systemMetrics_customVerify = "xpath://span[@class='clrblack']";
	String appedo_systemMetrics_configure = "xpath://tr[1]//td[6]//mat-icon[1]";
	String appedo_systemMetrics_selectCategory = "xpath:/html/body/div[1]/div[2]/div/mat-dialog-container/configure-setting-dialog/div[2]/div[1]/mat-form-field/div/div[1]/div/mat-select/div/div[1]";
	String appedo_systemMetrics_categoryOption = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[87]/span[1]";
	String appedo_systemMetrics_menuOption = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[2]/div[1]/div[1]/mat-checkbox[1]/label[1]";
	String appedo_systemMetrics_btnUpdate = "xpath://span[contains(text(),'Update')]";
	String appedo_systemMetrics_btncancel = "xpath://mat-icon[contains(text(),'cancel')]";
	String appedo_systemMetrics_configureRemove = "xpath://span[contains(text(),'Cpu.addmetricstest')]";
	String appedo_systemMetrics_configureRemove1 = "xpath:String appedo_systemMetrics_configureRemove";
	String appedo_systemMetrics_configAddtomychart = "id:addtomychart0";
	String appedo_systemMetrics_configTxtName = "id:mcName";
	String appedo_systemMetrics_configChartBtnsave = "xpath://span[contains(text(),'Save')]";
	String appedo_systemMetrics_viewChartDB = "xpath://tr[1]//td[10]//mat-icon[1]";
	String appedo_systemMetrics_customMenuHttp = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[2]/div[1]/div[3]";
	String appedo_systemMetrics_customMenuHttp1 ="xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[2]/div[1]/div[1]/mat-checkbox[1]/label[1]/span[1]";
	String appedo_systemMetrics_customSelectDB = "xpath:/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/mat-option[2]/span[1]";
	String appedo_removeConfig = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/configure-setting-dialog[1]/div[2]/div[2]/div[2]/div[2]/mat-checkbox[1]/label[1]";
	
	// Copy Metrics
	String appedo_Verify_charts = "xpath://span[contains(text(),'Charts')]";
	String appedo_Verify_SystemMetrics = "xpath://span[contains(text(),'System Metrics')]";
	String appedo_Verify_SystemMetrics1 = "xpath://mat-card-title[@class='mat-card-title']";
	String appedo_SystemMetrics_btnApp = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-system-details[1]/div[1]/mat-card[1]/mat-card-content[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/span[1]";
	String appedo_SystemMetrics_btnCopyMetrics = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-module-details[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/mat-icon[1]";
	String appedo_SystemMetrics_btnPasteMetrics = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-module-details[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[8]/mat-icon[1]";
	String appedo_SystemMetrics_btnPasteConfirmation = "xpath://div[@id='cdk-overlay-14']/snack-bar-container/alert/div/span";

	
	
	// Alert setting for OS
	String appedo_systemMetrics_os_setAlert = "id:openalert0";
	String appedo_systemMetrics_os_createPolicy = "xpath://span[contains(text(),'Create Policy')]";
	String appedo_systemMetrics_os_txtPolicyName = "id:policy_name";
	String appedo_systemMetrics_os_txtPolicyDesc = "id:policy_description";
	String appedo_systemMetrics_os_warning = "id:warning";
	String appedo_systemMetrics_os_critical = "id:critical";
	String appedo_systemMetrics_os_minBreachCount = "id:minbreachcount";
	String appedo_systemMetrics_os_validatePolicyName = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[1]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_os_validatePolicyDesc = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[1]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_os_validateWarning = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_os_validateCritical = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_os_validateMinBreachCount = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_os_btnSave = "xpath://span[contains(text(),'Save')]";
	String appedo_systemMetrics_os_verifyAlert = "xpath://span[@class='clrblack']";
	String appedo_systemMetrics_os_edit = "xpath://mat-icon[@class='pointer mat-icon notranslate mat-accent material-icons']";
	String appedo_systemMetrics_os_changeThreshold = "id:Thresholdbelow";
	String appedo_systemMetrics_os_delete = "xpath://mat-icon[contains(text(),'delete')]";
	String appedo_systemMetrics_os_btnClose = "xpath://mat-icon[contains(text(),'cancel')]";

	// Alert setting for App
	String appedo_systemMetrics_app_validateWarning = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_app_validateCritical = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_app_validateMinBreachCount = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";

	// Alert setting for DB
	String appedo_systemMetrics_db_validateWarning = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[1]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_db_validateCritical = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[2]/div[1]/div[3]/div[1]/mat-error[1]";
	String appedo_systemMetrics_db_validateMinBreachCount = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/manage-alert-dialog[1]/div[2]/form[1]/div[2]/mat-form-field[3]/div[1]/div[3]/div[1]/mat-error[1]";

	// Alert setting for Log
	String appedo_systemMetrics_Log = "xpath://table/tbody/tr[1]/td[7]";
	String appedo_systemMetrics_log_alert = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_systemMetrics_log_addPolicy = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/div[2]/button[1]";
	String appedo_systemMetrics_log_breachSeverity = "name:BreachSeverity";
	String appedo_systemMetrics_log_selectSeverity = "xpath://span[contains(text(),'Critical')]";
	String appedo_systemMetrics_log_severityMinBrchCount = "id:minbreachcount";
	String appedo_systemMetrics_log_breachText = "id:BreachPattern";
	String appedo_systemMetrics_log_btnSave = "xpath://span[contains(text(),'Save')]";
	String appedo_systemMetrics_log_verify = "xpath://span[@class='clrblack']";
	String appedo_systemMetrics_log_btnCancel = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/div[1]/mat-icon[2]";
	String appedo_systemMetrics_log_edit = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]";
	String appedo_systemMetrics_log_delete = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]";
	String appedo_systemMetrics_log_verifyDelete = "xpath://span[contains(.,'Deleted Successfully')]";

	// Alert setting for Network
	String appedo_systemMetrics_network = "xpath://table/tbody/tr[1]/td[8]";
	String appedo_systemMetrics_network_alert = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_systemMetrics_network_addPolicy = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/alert-log[1]/div[2]/button[1]";

	// Enterprise User - System Metrics
	String appedo_enterprise_app_edit = "xpath://mat-icon[contains(text(),'edit')]";
	String appedo_enterprise_viewGraphs = "xpath://table/tbody/tr[1]/td[10]";
	String appedo_enterprise_viewGraphsLog = "xpath://table/tbody/tr[1]/td[7]";
	//String appedo_enterprise_addToMyChart = "xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-dashboard[1]/div[2]/div[27]/div[1]/span[2]/span[2]/mat-icon[1]";
	String appedo_enterprise_addToMyChart = "xpath://span[@id='addtomychart0']//mat-icon[@class='mat-icon notranslate mat-warn material-icons'][contains(text(),'pie_chart')]";
	String appedo_enterprise_dashboardname = "id:mcName";
	//String appedo_btnSave = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/mychart-dialog[1]/div[3]/button[2]";
	String appedo_btnSave = "xpath://span[contains(text(),'Save')]";
	String appedo_verifyAppEdit = "xpath://span[@class='clrblack']";
	String appedo_enterpriseName = "xpath:/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/mat-option[1]/span[1]";
	String appedo_selectEnterpriseDB = "xpath://span[contains(text(),'stark industries')]";
	String appedo_enterprise_db = "xpath://table/tbody/tr[1]/td[6]";
	String appedo_enterprisedropdown = "name:entselect";
	String appedo_selectEnterprisename = "xpath://span[contains(text(),'AutoEnterprise')]";
	String appedo_enterpise_log = "xpath://table/tbody/tr[1]/td[7]";
	String appedo_enterpise_os = "xpath://tbody//tr[1]//td[4]";
	String appedo_enterpise_customMetrics = "xpath://table/tbody/tr[1]/td[9]";
	String appedo_enterpise_delete = "xpath://table/tbody/tr[1]/td[1]";
	String appedo_selectEnterpriseLog = "id:enterprise9";
	String appedo_enterprise_network = "xpath://table/tbody/tr[1]/td[8]";
	String appedo_systemMetrics_viewGraphsNetwork = "xpath://table/tbody/tr[1]/td[7]";
	String appedo_systemMetrics_verifyGraphsNetwork = "xpath://mat-icon[@class='mgnleft10 md-18 mat-icon notranslate mat-primary material-icons']";

	//Load Testing
	String appedo_link_LoadTest="xpath://span[contains(text(),'Load Testing')]";
	String appedo_uploadJmeterScriptBtn="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-load-test[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/div[1]/label[1]";
	String appedo_link_scenarios="xpath://div[contains(text(),'Scenarios')]";
	String appedo_scenarioBody="id:scen";
	String appedo_LoadTestDrawchart="xpath://table/tbody/tr[1]/td[6]";
	String appedo_ReportNameDropdown="xpath:/html[1]/body[1]/app-root[1]/div[1]/app-sidenav[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/load-test-reports[1]/mat-card[1]/div[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/mat-select[1]/div[1]/div[2]";
	String appedo_ReportNameSel="xpath://span[@class='mat-option-text'][contains(text(),'BVT dec2')]";
	String appedo_ReportName="xpath://td[@class='mat-cell cdk-column-Report-Name mat-column-Report-Name ng-star-inserted']";
	String appedo_iconConfig="xpath://table/tbody/tr[1]/td[2]";
	String appedo_txtThread="id:threads";
	String appedo_txtRampup="id:rampTimeFormat";
	String appedo_txtDuration="id:durationTimeFormat";
	String appedo_txtDelay="id:delay";
	String appedo_load_btnUpdate="xpath://span[contains(text(),'Update')]";
	String appedo_ConfigVerify="xpath://span[@class='clrblack']";
	String appedo_checkBoxForever="xpath://span[contains(text(),'Forever')]";
	String appedo_checkBoxScheduler="xpath://span[contains(text(),'Scheduler')]";
	String appedo_txtloop="id:loop";
	String appedo_delScenario="xpath://table/tbody/tr[1]/td[1]";
	String appedo_btnViewReport="xpath://span[contains(text(),'Click here to view report')]";
	String appedo_reportBody="xpath://div[@class='dashboard-container']";
}
