#!/bin/bash
filename="file.txt"
m=`wc -l "${filename}" | cut -d' ' -f1`
i=0

while read -r line
do
  ((++i))
  j=0
  for a in "${line}"
  do
    ((++j))
    echo "${i}" "${j}" "${a}"
  done
done < "${filename}" | sort -n -k2 -k1 | while read i j a
do
  if [[ "${i}" == "${m}" ]]
  then
    echo "{$a}"
  else
    echo -n "{$a} "
  fi
done


#Input:
#
#name age
#alice 21
#ryan 30
#The words with coordinates:
#
#1 1 name
#1 2 age
#2 1 alice
#2 2 21
#3 1 ryan
#3 2 30
#Sorted by j and i:
#
#1 1 name
#2 1 alice
#3 1 ryan
#1 2 age
#2 2 21
#3 2 30
#Final output:
#
#name alice ryan
#age 21 30