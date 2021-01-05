#/bin/bash
# 193_Valid_Phone_Numbers.sh
#Accept:
grep -E '^(\([0-9]{3}\) |[0-9]{3}-)[0-9]{3}-[0-9]{4}$' 193file.txt

grep -E '^(\(\d{3}\) |\d{3}-)\d{3}-\d{4}$' 193file.txt
sed -n -r '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/p' file.txt
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt

#problem:
#1.
#[:digit:] useless?
#grep -E '^(\([:digit:]{3}\) |[:digit:]{3}-)[:digit:]{3}-[:digit:]{4}$' 193file.txt
#2.
#escape too much?
#grep -e '\(^[0-9]\{3\}-[0-9]\{3\}-[0-9]\{4\}$\)' -e '\(^([0-9]\{3\})[ ]\{1\}[0-9]\{3\}-\([0-9]\{4\}\)$\)'  file.txt
