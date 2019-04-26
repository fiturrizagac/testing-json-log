#!/usr/bin/env bash

git checkout develop

tag_prefix="RC-v"

mvn release:prepare -DtagNameFormat="$tag_prefix@{project.version}" -B

tag_name=$(mvn -q -Dexec.executable=echo -Dexec.args='${project.scm.tag}' --non-recursive exec:exec)

mvn release:perform -B

git reset --hard

echo "my tag $tag_name"

git checkout $tag_name

git status

git branch -D release

mvn release:clean release:branch \
    -DbranchName=release \
    -DsuppressCommitBeforeBranch=true -DremoteTagging=false \
    -DupdateWorkingCopyVersions=false -B