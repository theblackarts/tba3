# The Black Arts

The Black Arts (TBA) is a turn-based strategy card game played by two players, each with a 52 card deck. Each player starts a game with 100 hit points (HP), a shuffled deck, and a hand of 7 cards. A player wins the game by using his or her cards to reduce his or her opponent from 100 to 0 HP.

## The Black Arts Specification
Please note that this Specification is a work in progress and incomplete. Updates will be made frequently.

[Click here to view the specification](https://docs.google.com/document/d/1I8qmWIa8b9jKjzwYstWFG5m0pXAK5NyCk16oVsQCEtk/edit?usp=sharing)

## How to Collaborate Using Git and GitHub

1. Download Git
2. Create a GitHub account
3. Log into your GitHub account
4. Find The Black Arts official repository (search tba3)
5. Fork the official repository to *your* GitHub account
6. Clone *your* copy of the repository to your local machine using a terminal
   $ git clone <url>
7. cd into the directory that contains the repository
   $ cd ~/path/to/tba3/on/local/machine
8. Check that you have fetch and push set up correctly
   $ git remote -v
9. Add official repo upstream
   $ git remote add upstream https://github.com/theblackarts/tba3.git
10. Check that it worked
    $ git remote -v
11. To pull from upstream
    $ git pull upstream master
    (here you're specifying upstream to point to the master branch of the official repository to pull those changes).

## Pull Request

1. Set up git and github (see How to collaborate using git and github above)
2. Pull all the changes from your github repo and upstream
3. Make one logical change to the code base
4. Push this change to *your* github repo
5. Log into your github account
6. Open the repo of interest from your account
7. Click the Pull Request tab
8. Click the green button, New pull request
9. Give some information about the one logical change you made
10. Confirm by selecting Create pull request
