#!/bin/bash
file="./194file.txt"
declare - a tranctx

while read line; do
  IFS=" "
  j=0
  p=($line)
  while [ ! -z "${p[$j]}" ]; do
    tranctx[$j]=${tranctx[$j]}${p[$j]}$'\n'
    ((++j))
  done
  IFS=$'\n'
done<$file

i=0
while [ ! -z "${tranctx[${i}]}" ]; do
  echo ${tranctx[${i}]}
  ((++i))
done

