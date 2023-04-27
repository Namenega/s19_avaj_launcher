#!/bin/bash

# Colors - ${GRN} - ${CYN} - ${END}
GRN='\033[1;32m'
CYN='\033[1;36m'
END='\033[0m'

echo "${GRN}Launch script to compile *.java files into *.class files${END}"
echo "Command : ${CYN} find * -name '*.java' > ../files/sources.txt${END}"
echo "Command : ${CYN} javac @files/sources.txt${END}"

mkdir -p files/src

find * -name "*.java" > files/src/sources.txt
javac @files/src/sources.txt

echo "${GRN}Done !${END}"
