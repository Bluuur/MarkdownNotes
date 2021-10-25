@echo off
echo "GIT PUSH BAT"


echo "Moving to working directory" 
D:
cd D:\program\MarkdownNotes

echo "Start submitting code to the local repository"
git add *
 
echo "Commit the changes to the local repository"
set now=%date% %time%
echo "Time:" %now%
git commit -m "%now% update"
 
echo "Push the changes to the remote git server"
git push origin main
 
echo "Execution complete!"
pause

exit