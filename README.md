2024.9.19
开始数据库设计
学生表：学号（主键），姓名，班级，专业，学院，毕业设计题目，指导老师，联系方式，邮箱，账号，密码
老师表：工号（主键），姓名，学院，联系方式，指导学生id,邮箱，密码，账号，密码
打分表：学生id，1234阶段打分老师id（可能有更多），1234阶段分数（可能有更多），评语
-- 创建学生表
CREATE TABLE students (
student_id INT AUTO_INCREMENT PRIMARY KEY,
student_name VARCHAR(255),
class_name VARCHAR(255),
major VARCHAR(255),
college VARCHAR(255),
graduation_project_title VARCHAR(255),
instructor VARCHAR(255),
contact_info VARCHAR(255),
email VARCHAR(255),
account VARCHAR(255),
password VARCHAR(255)
);

-- 创建老师表
CREATE TABLE teachers (
teacher_id INT AUTO_INCREMENT PRIMARY KEY,
teacher_name VARCHAR(255),
college VARCHAR(255),
contact_info VARCHAR(255),
student_ids TEXT, -- 存储指导学生的 id，可以用逗号分隔的字符串形式
email VARCHAR(255),
password VARCHAR(255),
account VARCHAR(255)
);

-- 创建打分表
CREATE TABLE scores (
score_id INT AUTO_INCREMENT PRIMARY KEY,
student_id INT,
teacher_id_1 INT,
score_1 DECIMAL(5,2),
teacher_id_2 INT,
score_2 DECIMAL(5,2),
teacher_id_3 INT,
score_3 DECIMAL(5,2),
teacher_id_4 INT,
score_4 DECIMAL(5,2),
comment TEXT
);