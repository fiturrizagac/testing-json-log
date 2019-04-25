#!/usr/bin/env bash
mvn release:prepare -B
mvn release:perform -B
