# Project Title

Student Management System

## Description

A simple local host web application that allows student to manage course and teachers to track grades.

## Table of Contents
-[Requirements](#requirements)
-[Installation](#installation)
-[Usage](#usage)

## Requirements
1. Java
2. JavaWeb
3. MySQL
4. Tomcat

## Installation

1. Open zip file as project in IDE
2. If not configured, add Java EE Web Application Framework support
3. If not configured, add WEB-INF/lib as library
4. If not configured, add Tomcat as library
5. If not configured, configured Tomcat 
6. Execute sms.sql SQL script to create database with precreated data.
7. Under 'src/c3p0-config.xml', change the "user" and "password" to local MySQL username and password to connect to local MySQL database.

## Usage
1. Run Tomcat to deploy.
2. Input account: 'admin', password: 'admin' to enter the system as admin.
3. Check database to see other existing account user.
4. Sign up for new user, account must be a valid E-mail address.
5. Log in a student account to enroll courses and see grades.
6. Log in a teacher account to see grade distribution and edit grades.
7. Log in a admin account to manage users, courses, and records.
 
