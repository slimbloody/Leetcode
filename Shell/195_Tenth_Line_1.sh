#!/bin/bash
cnt=0
while read -r line && [[ "${cnt}" -le 10 ]]; do
  "${cnt}" = "${cnt}" + 1
  if [[ ${cnt} -eq 10 ]]; then
    echo "${line}"
    exit 0
  fi
done < 195file.txt
