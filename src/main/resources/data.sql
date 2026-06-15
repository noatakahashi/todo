INSERT INTO task (title, description, priority, 
status, created_at, updated_at) VALUES
('重要なタスク', '最優先で対応するタスク', 'A', '未着手', 
CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('通常のタスク', '通常対応のタスク', 'B', '進行中', 
CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('低優先タスク', '後回しにできるタスク', 'C', '完了', 
CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);