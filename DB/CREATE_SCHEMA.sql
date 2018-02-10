-- Role: lesson

-- DROP ROLE lesson;

CREATE ROLE lesson LOGIN
PASSWORD 'lesson'
NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;
COMMENT ON ROLE lesson IS 'spring-mfc-user';

-- Schema: lesson

-- DROP SCHEMA lesson;

CREATE SCHEMA lesson
AUTHORIZATION lesson;

GRANT ALL ON SCHEMA lesson TO lesson;
GRANT ALL ON SCHEMA lesson TO public;
