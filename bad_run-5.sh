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
echo "| Command : ${CYN} java ro.academyplus.avaj.simulator.Simulator files/scenarii/bad_scenario_5.txt${END} |"
echo "*-------------------------------------------------------------------------------------------*"
echo ""
echo ""
echo "*----------------*"
echo "| Fifth scenario |"
echo "*----------------*"
echo ""
echo "${CYN}Content of Fifth bad scenario${END}"
echo ""
echo "------------------------------"
echo " Read unknown file"
echo "------------------------------"
echo ""
echo "${CYN}OUTPUT FIFTH BAD SCENARIO${END}"
echo ""

java ro.academyplus.avaj.simulator.Simulator ./files/scenarii/unknown_scenario.txt

echo ""
echo "${GRN}Done !${END}"
