#!/usr/bin/env bash

# Define o caminho para o arquivo JAR principal e suas dependências
BASE_CP="jobs4u.app.candidate.console/target/jobs4u.app.candidate.console-0.1.0.jar:jobs4u.app.candidate.console/target/dependency/*"

# Chama a VM do Java com o classpath especificado e a classe principal correta
java -cp "$BASE_CP" jobs4u.app.candidate.console.CandidateApp
