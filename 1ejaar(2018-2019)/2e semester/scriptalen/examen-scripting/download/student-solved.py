def generate_download_script(ids):
    res = ""
    for ida in ids:
        res += "if [ ! -d {} ]; then\n".format(ida)
        res += "    git clone https://github.com/{}/project {}\n".format(ida,ida)
        res += "else\n"
        res += "    (cd {}; git pull)\n".format(ida)
        res += "fi\n"
    return res
