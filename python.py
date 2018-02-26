from sys import argv
script, operation = argv
with open('result.txt', 'w') as file:
   try:
      exec('res = ' + operation)
      file.write(str(res))
   except:
      file.write('SYNTAX ERROR')