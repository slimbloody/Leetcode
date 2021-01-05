#!/bin/bash
i=0
while (( i++ < 10 )) do
  read -r line
done < file.txt
echo "${line}"

