#!/usr/bin/env bash
mvn release:prepare -B
current_version=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
mvn release:perform -B
mvn release:clean release:branch \
    -DbranchBase=master \
    -DbranchName=release \
    -DsuppressCommitBeforeBranch=true -DremoteTagging=false \
    -DupdateWorkingCopyVersions=false -B

