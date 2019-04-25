#!/usr/bin/env bash

tag_prefix="RC-v"

mvn release:prepare -DtagNameFormat="$tag_prefix@{project.version}" -B

tag_name=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.scm.tag}' --non-recursive exec:exec)

mvn release:perform -B

git checkout $tag_name

mvn release:clean release:branch \
    -DbranchName=release \
    -DsuppressCommitBeforeBranch=true -DremoteTagging=false \
    -DupdateWorkingCopyVersions=false -B