import re
def encode(s):
 
    encoding = "" # stores output string
    print(encoding)
    i = 0
    while i < len(s):
        # count occurrences of character at index `i`
        count = 1
        if(s[i] == ' '):
            encoding += str(count)+" "
            i=i+1
        
        while i + 1 < len(s) and s[i] == s[i + 1]:
            count = count + 1
            i = i + 1
 
        # append current character and its count to the result
        encoding += str(count) + s[i]
        i = i + 1

 
    return encoding

# def encodei(sequence):
#     #Encode a sequence of characters and return the result as a list of tuples (data value and number of observed instances of value).
#     #Keyword arguments:
#     #sequence -- a sequence of characters to encode represented as a string.
    
#     count = 1
#     result = []

#     for x, item in enumerate(sequence):
#         if x == 0:
#             continue
#         elif item == sequence[x - 1]:
#             count += 1
#         else:
#             result.append((sequence[x - 1], count))
#             count = 1

#     result.append((sequence[len(sequence) - 1], count))

#     return result



def decode(source):
    toDeco = ""
    for i in range(0, len(source), 2):
        for n in range(int(source[i])):
            toDeco+=source[i+1]
        
    return toDeco