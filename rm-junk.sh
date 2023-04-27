#!/bin/bash

# Colors - ${GRN} - ${CYN} - ${END}
GRN='\033[1;32m'
CYN='\033[1;36m'
END='\033[0m'

echo "${GRN}Launch script to delete junk files at the end.${END}"
echo "Command : ${CYN} rm ro/academyplus/avaj/simulator/*.class${END}"
echo "Command : ${CYN} rm -rf files/src${END}"
echo "Command : ${CYN} rm .DS_Store */.DS_Store */*/.DS_Store */*/*/.DS_Store */*/*/*/.DS_Store${END}"

rm ro/academyplus/avaj/simulator/*.class
rm -rf files/src
rm .DS_Store */.DS_Store */*/.DS_Store */*/*/.DS_Store */*/*/*/.DS_Store
rm simulation.txt
