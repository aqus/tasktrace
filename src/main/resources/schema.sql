CREATE TABLE IF NOT EXISTS priorities (
    priority_id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS statuses (
    status_id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS labels (
    label_id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks (
    task_id SERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(2000) NOT NULL,
    reporter VARCHAR(40) NOT NULL,
    performer VARCHAR(40) NOT NULL,
    text TEXT,
    priority_id BIGINT NOT NULL,
    status_id BIGINT NOT NULL,
    create_time BIGINT NOT NULL,
    FOREIGN KEY(priority_id) REFERENCES priorities(priority_id),
    FOREIGN KEY(status_id) REFERENCES statuses(status_id)
);

CREATE TABLE IF NOT EXISTS attachments (
    attachment_id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(2000) NOT NULL,
    file_id VARCHAR(100) NOT NULL,
    task_id BIGINT NOT NULL,
    FOREIGN KEY(task_id) REFERENCES tasks(task_id)
);

CREATE TABLE IF NOT EXISTS tasks_labels (
    task_id BIGINT NOT NULL,
    label_id BIGINT NOT NULL,
    PRIMARY KEY (task_id, label_id),
    FOREIGN KEY(task_id) REFERENCES tasks(task_id),
    FOREIGN KEY(label_id) REFERENCES labels(label_id)
);

CREATE TABLE IF NOT EXISTS status_transitions (
    status_id BIGINT NOT NULL,
    transition_status_id BIGINT NOT NULL,
    PRIMARY KEY (status_id, transition_status_id),
    FOREIGN KEY(status_id) REFERENCES statuses(status_id),
    FOREIGN KEY(transition_status_id) REFERENCES statuses(status_id)
);