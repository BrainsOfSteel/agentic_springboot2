# github_skills.md

## Skill: Commit and Push Local Branch to GitHub

### Purpose
Safely commit and push changes from the current local branch to GitHub, with developer confirmation before committing.

---

## Behavior Rules

### 1. Detect File Changes
- Scan the repository for all modified, added, and deleted files.
- Use Git status to determine:
  - Modified files
  - New (untracked) files
  - Deleted files
- Present a clear summary of all detected changes.

---

### 2. Respect `.gitignore`
- Strictly ignore all files and directories listed in `.gitignore`.
- Do NOT stage or commit:
  - Ignored files
  - Build artifacts
  - Environment files
  - Dependency folders
- Only consider trackable files.

---

### 3. Confirm With Developer Before Commit
Before committing:
- Show a structured summary:
  - Files changed
  - Type of change (Added / Modified / Deleted)
- Ask the developer for confirmation.
- Optionally suggest a commit message based on changes or ask developer to provide one
- Wait for explicit approval before proceeding.

Do NOT auto-commit without confirmation.

---

### 4. Commit Changes
After developer approval:
- Stage relevant files.
- Create a commit using the approved commit message.
- Ensure:
  - No ignored files are included
  - No unintended files are staged
---

### 5. Push to GitHub
- Push to the current active branch.
- If upstream is not set:
  - Set upstream to origin automatically.
- Confirm successful push.
- Display:
  - Branch name
  - Commit hash
  - Remote repository

---

## Safety Constraints

- Never force push unless explicitly instructed.
- Never bypass developer confirmation.
- Never modify commit history unless requested.
- Never expose secrets from ignored files.

---

## Output Format

Before commit:

After push:

## Assumptions
- Git is already initialized.
- Remote `origin` is configured.
- Developer has proper push permissions.
- Current branch is the intended branch.
## End of Skill