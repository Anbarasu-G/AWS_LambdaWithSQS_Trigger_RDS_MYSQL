# AWS_LambdaWithSQS_Trigger_RDS_MYSQL

This project demonstrates a serverless architecture where **AWS Lambda** is triggered by **Amazon SQS** messages to perform operations on a **MySQL database hosted in Amazon RDS**. It's ideal for use cases involving asynchronous processing, microservices, and decoupled data pipelines.

---

## 🧰 Tech Stack

- **AWS Lambda** (Node.js or Python)
- **Amazon SQS** (Standard Queue)
- **Amazon RDS** (MySQL)
- **AWS IAM**
- **AWS CloudWatch**
- **AWS CloudFormation / AWS SAM** (optional for deployment)

---

## 📌 Features

- Trigger Lambda from SQS messages  
- Perform MySQL operations (INSERT/UPDATE/DELETE) via Lambda  
- Use environment variables for DB credentials  
- Basic error handling and logging  
- Modular and extensible codebase

---

## 📁 Project Structure

AWS_LambdaWithSQS_Trigger_RDS_MYSQL/
├── lambda/
│ └── handler.js / handler.py # Lambda function code
├── scripts/
│ └── db_init.sql # Sample SQL for DB setup
├── template.yaml # AWS SAM/CloudFormation template
└── README.md

