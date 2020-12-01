-- 1번
create table regions (
	region_id int primary key,
	region_name varchar(30)
);

-- 2번
create table countries (
	country_id varchar(6) primary key,
	country_name varchar(40),
	region_id int,
	foreign key (region_id)
	references regions (region_id)
);

-- 3번
create table locations (
	location_id int primary key,
	street_adress varchar(80),
	postal_code varchar(20),
	city varchar(40),
	state_province varchar(30),
	country_id varchar(6),
	foreign key(country_id)
	references countries (country_id)
);

-- 4번
create table departments (
	department_id int primary key,
	department_name varchar(40),
	manager_id int,
	location_id int,
	foreign key (location_id)
	references locations (location_id)
);

-- 5번
create table jobs (
	job_id varchar(20) primary key,
	job_title varchar(60),
	min_salary int,
	max_salary int
);

-- 6번
create table employees (
	employee_id int primary key,
	first_name varchar(30),
	last_name varchar(30),
	email varchar(20),
	phone_number varchar(40),
	hire_date datetime,
	job_id varchar(20),
	salary int,
	commission_pct double,
	manager_id int,
	department_id int,
	foreign key (job_id)
	references jobs (job_id),
	foreign key (department_id)
	references departments (department_id)
);

-- 7번
create table job_history (
	employee_id int,
	start_date datetime,
	end_date datetime,
	job_id varchar(20),
	department_id int,
	foreign key (employee_id)
	references employees (employee_id),
	foreign key (job_id)
	references jobs (job_id),
	foreign key (department_id)
	references departments (department_id)
);
