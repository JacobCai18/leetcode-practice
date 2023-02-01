awk '{
    for (i = 1; i <= NF; i++) { # NF 当前行的 field 字段数
        if (NR == 1) { # NR 正在处理的当前行数
            res[i] = $i
        } else {
            res[i] = res[i]" "$i
        }
    }
} END {
    for(j = 1; j <= NF; j++){
        print res[j] # print 自动换行
    }
}' file194.txt
