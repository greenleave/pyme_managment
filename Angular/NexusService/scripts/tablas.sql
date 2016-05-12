--Ya creadas en NexusD3

CREATE TABLE Z_Reference_Setting_report
(
	reference_id  NUMBER(10),
	report_id      NUMBER(10),
	setting_id    NUMBER(10)
);

CREATE SEQUENCE Z_Reference_Setting_report_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_Reference_Setting_Chart
(
	reference_id  NUMBER(10),
	setting_id    NUMBER(10),
	chart_id      NUMBER(10)
);

CREATE SEQUENCE Z_Reference_Setting_Chart_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_Reference_Report_Chart
(
	reference_id         	NUMBER(10),
	chart_id             	NUMBER(10),
	report_id            	NUMBER(10),
	report_configuration 	CLOB,
	report_data  		 	CLOB,
	last_time_executed	 	DATE,
	refresh_time		 	NUMBER(10),
	chart_width				NUMBER(10),
	chart_height			NUMBER(10)
);

CREATE SEQUENCE Z_Reference_Report_Chart_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_charts
(
	chart_id           NUMBER(10),
	chart_description  VARCHAR2(250)
);

CREATE SEQUENCE Z_charts_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_Reports
(
	report_id           NUMBER(10),
	report_description  VARCHAR2(450),
	statement          	CLOB,
	report_title	 	VARCHAR2(100)
);

CREATE SEQUENCE Z_Reports_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_User_Settings
(
	setting_id           NUMBER(10),
	setting_description  VARCHAR2(250),
	user_id              NUMBER(10) NOT NULL,
	ref_chart_id         NUMBER(10),
	ref_report_id         NUMBER(10)
);

CREATE SEQUENCE Z_User_Settings_seq START WITH 0 INCREMENT BY 1;

CREATE TABLE Z_Users
(
	user_id    NUMBER(10),
	user_name  VARCHAR2(150)
);

CREATE SEQUENCE Z_Users_seq START WITH 0 INCREMENT BY 1;