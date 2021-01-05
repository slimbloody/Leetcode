#!/bin/bash
awk 'FNR == 10 {print}'  file.txt

awk 'NR == 10' file.txt

awk '{if(NR==10) print $0}' file.txt

sed -n 10p file.txt

tail -n+10 file.txt | head -1

STARTING=10; NLINES=1; cat file.txt | tail -n+${STARTING} | head -n${NLINES}

tail -n+10 file.txt|head -1


mapfile -s 9 -n 1 array < file.txt
echo "${array[0]}" | head -1

