transpose=$(head -n1 file194.txt | wc -w)

for i in $(seq 1 $transpose); do
  echo $(cut -d' ' -f$i file194.txt)
done
