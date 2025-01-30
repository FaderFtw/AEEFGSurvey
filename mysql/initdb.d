-- /mysql/initdb.d/01-init.sql
-- Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS surveydb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Create application user
CREATE USER IF NOT EXISTS 'survey_app_user'@'%' IDENTIFIED BY '${DB_PASSWORD}';

-- Grant necessary privileges to application user
GRANT SELECT, INSERT, UPDATE, DELETE ON surveydb.* TO 'survey_app_user'@'%';

-- Flush privileges to apply changes
FLUSH PRIVILEGES;

-- Set secure defaults for the surveydb
USE surveydb;
