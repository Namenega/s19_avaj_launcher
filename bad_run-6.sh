#!/bin/bash

# Colors - ${GRN} - ${CYN} - ${END}
GRN='\033[1;32m'
TST='\033[1;34m'
CYN='\033[1;36m'
END='\033[0m'

echo ""
echo "*-------------------------------------------------------------------------------------------*"
echo "|                              ${GRN}LAUNCH SCRIPT TO RUN THE PROJECT${END}                             |"
echo "|                                                                                           |"
echo "| Command : ${CYN} java ro.academyplus.avaj.simulator.Simulator files/scenarii/empty.txt${END}     |"
echo "*-------------------------------------------------------------------------------------------*"
echo ""
echo ""
echo "*----------------*"
echo "| Sixth scenario |"
echo "*----------------*"
echo ""
echo "${CYN}Content of Sixth bad scenario${END}"
echo ""
echo "------------------------------"
while read p; do
  echo "  ${TST}$p${END}"
done <./files/scenarii/empty.txt
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT SIXTH BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/empty.txt

echo ""
echo "${GRN}Done !${END}"
