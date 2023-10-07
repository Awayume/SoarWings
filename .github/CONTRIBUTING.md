# Contribution Guideline
Thank you for your interest in contributing.  
Please check the following before contributing.
Contributions that do not follow the rules may be rejected.

## General Rules
- You should use English in this project.

## Commits
- Write concise commit messages
- Make your commits detailed. Consider splitting commits that are too large into multiple commits.

### Commit message
Commit messages must always start with the following prefix:

|  prefix  |        description         |
|:---------|:---------------------------|
| add      | Add something              |
| remove   | Remove something           |
| change   | Change something           |
| update   | Update something           |
| upgrade  | Upgrade version (not libs) |
| feat     | New feature                |
| fix      | Fix something              |
| hotfix   | Fix critical bugs          |
| library  | Add/update/remove library  |
| perf     | Improve performance        |
| refactor | Refactoring                |
| test     | Add/change test codes      |
| style    | Fix style                  |
| docs     | Add/change docs            |
| ci       | About CI/CD                |
| chore    | Chores                     |

Example:
```
add: Add something
```

Exceptions:
- Merge commits (default message)
- Revert commits (default message)
- Dependabot commits (default message)

#### WIP commits
WIP commits should only be used on working branches.  
Also, all WIP commits must be rebased before submitting a PR.  
<br>
Example:
```
[WIP] add: Add something
```

#### Commits related to the Issue
Include the issue number in the commit message to link the commit to the issue.  
It should appear immediately after the prefix.  
<br>
```
fix #0: Fix error
```

## Pull Requests
- Do not delete templates.
- Think objectively before contributing.

## Issues
- Do not use Issues to get help. You can use Forums or Discord guild.
- Think objectively before contributing.
