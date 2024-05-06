@echo off
echo "Execution start"
echo "Pull before push"
git pull >> repoSync.log
echo "GIT PUSH BAT running" >> repoSync.log
set now=%date% %time%
echo "Time:" %now% >> repoSync.log

echo "Start submitting code to the local repository" >> repoSync.log
git add . >> repoSync.log
 
echo "Commit the changes to the local repository" >> repoSync.log
git commit -m "%now% update" >> repoSync.log
 
echo "Push the changes to the remote git server" >> repoSync.log
git push origin main >> repoSync.log
 
echo "Execution complete!" >> repoSync.log

exit