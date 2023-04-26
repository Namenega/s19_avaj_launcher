#!/bin/bash

# Colors - ${GRN} - ${CYN} - ${END}
GRN='\033[1;32m'
CYN='\033[1;36m'
END='\033[0m'

echo "${GRN}Follow this order to go through project${END}"
echo "---------------------------------------"
echo "1. ${CYN}compile.sh${END} -> compile java files into class files"
echo "2. ${CYN}run.sh${END}     -> run correct projects"
echo "3. ${CYN}bad-run.sh${END} -> run incorrect projects"
echo "4. ${CYN}rm-junk.sh${END} -> remove junk files"
