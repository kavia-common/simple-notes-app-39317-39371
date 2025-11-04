#!/bin/bash
cd /home/kavia/workspace/code-generation/simple-notes-app-39317-39371/notes_backend
./gradlew checkstyleMain
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

