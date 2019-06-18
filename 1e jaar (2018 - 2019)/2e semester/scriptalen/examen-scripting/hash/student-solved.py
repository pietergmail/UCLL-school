import hashlib

def hash_file(filename):
    with open(filename, 'r') as file:
        data = file.readlines()

        ret = ""
        for line in data:
            line = line.replace('\n', '')
            hs = hashlib.sha256(line.encode('ASCII')).hexdigest()[:10]
            ret += hs + "\n"
    
    with open(filename, 'w') as file:
        file.write(ret)
    file.close()
