import re
def correct(s):
    return re.sub('([A-Z]{1})', r'_\1', s).lower()
