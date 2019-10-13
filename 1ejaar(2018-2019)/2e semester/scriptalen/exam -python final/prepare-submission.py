import zipfile
import os


solution_filename = 'solution.py'
zip_filename = 'june-submission.zip'

with zipfile.ZipFile(zip_filename, 'w') as z:
    for root, dirs, files in os.walk('.'):
        if solution_filename in files:
            file = os.path.join(root, solution_filename)
            print(f'Adding {file}')
            z.write(file)

print(f'Upload {zip_filename} to Toledo')