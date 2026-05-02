---
name: terraform-aws
summary: Reusable Terraform/AWS helper skill for cloud deployment guidance.
---

# Terraform AWS Skill

Use this skill when the agent needs reusable help for AWS Terraform deployment design, module creation, or security best practices.

## Use cases
- "Generate a Terraform module for ECS Fargate deployment of this Spring Boot app."
- "Suggest the AWS provider and backend configuration for storing Terraform state in S3."
- "How should I structure Terraform variables for RDS credentials and app environment settings?"
- "Review the ECS task definition and IAM role permissions for minimal access."

## Guidance patterns
- Recommend creating one module for each major infrastructure layer: `network`, `container`, `database`, `security`.
- Use AWS resource tags and environment-specific naming conventions.
- Advise using CloudWatch log groups and application health checks.
- Promote remote Terraform state and avoid embedding secrets directly in `.tf` files.
- Prefer `aws_ecs_service` with `launch_type = "FARGATE"` and `aws_ecr_repository` for build artifacts.
