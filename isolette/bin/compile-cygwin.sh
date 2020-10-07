#!/usr/bin/env bash
#
# This file is autogenerated.  Do not edit
#
set -e
export SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd ${SCRIPT_HOME}
mkdir -p cygwin-build
mkdir -p ${SCRIPT_HOME}/../src/c/nix/cygwin-build
cd ${SCRIPT_HOME}/../src/c/nix/cygwin-build
cmake -DCMAKE_BUILD_TYPE=Release ..
make $MAKE_ARGS
mv *.exe ${SCRIPT_HOME}/cygwin-build/