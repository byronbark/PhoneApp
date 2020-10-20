# Branching Model for the project
The workflow of the project will be orchestrated in the following way.

![enter image description here](https://nvie.com/img/git-model@2x.png)
Source: https://nvie.com/posts/a-successful-git-branching-model/
## Master Branch (Main)
It will contain the version of the product ready to be deliver it to the client. The different versions of this branch will be represent it as a number tag.

**Important**: Nobody cannot push code directly to this branch. So assure you that you are in the correct branch before doing a push. Use the command ```git branch``` to know the branch that you are.

## Develop Branch
The develop branch will contain the code with the new features and it will the start point to create the feature branches. Therefore, if a new feature will be implemented the branch for this feature will start from this branch. Also, when a feature implementation is finished, this feature branch will join with develop first.

## Feature Branches
These branches are where we are going to code the different tasks of our project. When a task (That is type **feature**) is assigned to us we will do the following before starting the task.

1. Go to develop ```git checkout develop```.
2. Make sure develop is up to date ```git pull origin develop```.
3. Move and create a new branch with the following name "*feature/[name of task]*". For example ```git checkout -b feature-add_phones```.
4. Start to coding :computer: :)

When you finish a feature then you can create a "*Pull request*" (This is made via the Github page of our project) from your branch to the develop branch to check the code and avoid merge conflicts. If your code passed all the tests then it will merge to develop.

## Release Branches
In these branches will go a version of the application that is ready for production. This can happen in the end of each sprint when we finish a group of features. In the release branches we will do user tests to the app and repair bugs only (Not major feature implementation goes here). After each change to the branch it will, frequently, merge back to "*develop*". When all the testing is finish this branch will be merge with "*master*" and "*develop*" to launch the app to production.

- **Naming standard**: "*release-[version of release]*".

## Hotfixes branch
These branches are dedicated for reparating bugs that are in the production environment. There are created from the "*master*" branch and, when the bug is fixed, are merge back to "*master*" and "*develop*".

- **Naming standard**: "*hotfixes-[version of new release]*".

## Merging
All the merge in the project will be done through pull requests. This will facilitate us to do code review, testing and avoid mergin problem. Documentation about it: https://docs.github.com/en/free-pro-team@latest/github/collaborating-with-issues-and-pull-requests/about-pull-requests