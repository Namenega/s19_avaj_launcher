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
echo "| Command : ${CYN} java ro.academyplus.avaj.simulator.Simulator files/scenarii/bad_scenario_*.txt${END} |"
echo "*-------------------------------------------------------------------------------------------*"
echo ""
echo "*----------------*"
echo "| First scenario |"
echo "*----------------*"
echo ""
echo "${CYN}Content of First bad scenario${END}"
echo ""
echo "------------------------------"
while read p; do
  echo "  ${TST}$p${END}"
done <./files/scenarii/bad_scenario_1.txt
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT FIRST BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/bad_scenario_1.txt

echo ""
echo "${GRN}Done !${END}"
echo ""
echo ""
echo "*-----------------*"
echo "| Second scenario |"
echo "*-----------------*"
echo ""
echo "${CYN}Content of Second bad scenario${END}"
echo ""
echo "------------------------------"
while read p; do
  echo "  ${TST}$p${END}"
done <./files/scenarii/bad_scenario_2.txt
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT SECOND BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/bad_scenario_2.txt

echo ""
echo "${GRN}Done !${END}"
echo ""
echo ""
echo "*----------------*"
echo "| Third scenario |"
echo "*----------------*"
echo ""
echo "${CYN}Content of Third bad scenario${END}"
echo ""
echo "------------------------------"
while read p; do
  echo "  ${TST}$p${END}"
done <./files/scenarii/bad_scenario.txt
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT THIRD BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/bad_scenario.txt

echo ""
echo "${GRN}Done !${END}"
echo ""
echo ""
echo "*-----------------*"
echo "| Fourth scenario |"
echo "*-----------------*"
echo ""
echo "${CYN}Content of Fourth bad scenario${END}"
echo ""
echo "------------------------------"
echo " Read unknown file"
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT FOURTH BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/unknown_scenario.txt

echo ""
echo "${GRN}Done !${END}"
echo ""
echo ""
echo "*----------------*"
echo "| Fifth scenario |"
echo "*----------------*"
echo ""
echo "${CYN}Content of Fifth bad scenario${END}"
echo ""
echo "------------------------------"
while read p; do
  echo "  ${TST}$p${END}"
done <./files/scenarii/bad_scenario_3.txt
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT FIFTH BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/bad_scenario_3.txt

echo ""
echo "${GRN}Done !${END}"
