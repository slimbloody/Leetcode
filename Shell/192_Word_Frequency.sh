#!/bin/bash
#

#1
#file=`cat 192words.txt`
#echo "$file"

#2
#value="$(cat config.txt)"

#3: read line by line
#while read line; do
#    echo $line
#done < file.txt

# solution 1
cat words.txt | tr -s ' ' '\n'| sort | uniq -c | sort -r | awk '{ print $2, $1 }'

# solution 2
# awk 中的数组不必提前声明，也不必声明大小，初始化数组元素用 0 或空串，这根据上下文而定
awk '\
{ for (i=1; i<NF; ++i) { ++A[$i]} }\
END { for (i in A) { print i, A[i]} }\
' words.txt | sort -nr -k2

cat words.txt | awk '{for(i=1;i<=NF;++i){count[$i]++}} END{for(i in count) {print i,count[i]}}' | sort -k2nr

