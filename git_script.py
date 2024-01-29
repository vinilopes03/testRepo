# !/usr/bin/env python3

import subprocess

def execute_git_commands(filepath, testcase_id, vcc):
    # Verify branch name you want to push to
    branch_name = 'git-scripts'

    # Add the modified file
    add = subprocess.Popen('git add --all', shell=True).wait()

    # Commit the change
    commit_msg = f'{testcase_id}|NON_VCC'

    # Change commit message if it is a VCC
    if vcc:
        commit_msg = f'{testcase_id}|VCC|{filepath}'

    commit = subprocess.Popen(f'git commit -m "{commit_msg}"', shell=True).wait()

    # Push the change
    push = subprocess.Popen(f'git push', shell=True).wait()


def parse_testcase_id(filepath):
    t_id = ''
    split_path = filepath.split('/')
    t_id = split_path[4]

    return t_id


if __name__ == "__main__":
    filepath = './temp/CWE397/testcases/CWE397_Throw_Generic/CWE397_Throw_Generic__declare_Exception_01.java'
    testcase_id = parse_testcase_id(filepath)
    execute_git_commands(filepath, testcase_id, True)
