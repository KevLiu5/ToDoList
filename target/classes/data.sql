-- data.sql

-- Create the "todos" table
CREATE TABLE IF NOT EXISTS todos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    priority VARCHAR(20),
    completed BOOLEAN DEFAULT false
    );

-- Insert data into the "todos" table
INSERT INTO todos (title, description, priority) VALUES ('Complete Project Proposal', 'Prepare and submit the project proposal by the deadline.', 'HIGH');
INSERT INTO todos (title, description, priority, completed) VALUES ('Review Code Pull Requests', 'Review and provide feedback on code pull requests from team members.', 'MEDIUM', true);
INSERT INTO todos (title, description, priority) VALUES ('Prepare for Team Meeting', 'Gather agenda items and prepare for the upcoming team meeting.', 'LOW');
