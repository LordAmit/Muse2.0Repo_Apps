#!/bin/sh
java -jar /home/amit/workspaces/muse/Muse.jar /home/amit/workspaces/muse/libs4ast /home/amit/muse/app/BMI_Calculator-master/ BMI_Calculator /home/amit/muse/output/BMI_Calculator/schemas/TAINT TAINT > BMI_Calculator_TAINT.log
echo finished executing TAINT
    