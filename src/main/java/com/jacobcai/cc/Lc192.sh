cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{print $2, $1}'
# tr -s 'a' 'b': squeeze repeated instances of character to a single instance
# uniq -c: prefix lines by the number of occurrences
# uniq 之前需要 sort, 因为 uniq 只去除相邻的重复行
# sort -n: --numeric-sort, compare according to string numerical value
# sort -r: --reverse, reverse the result of comparisons
