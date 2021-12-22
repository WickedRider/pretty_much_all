import re
import numpy as np
import collections
import func_aux  as fa

c = {}
def create_list(message):
    list = dict(collections.Counter(message))
    #creating the sorted list according to the probablity
    list_sorted = sorted(iter(list.items()), key = lambda k_v:(k_v[1],k_v[0]),reverse=True)
    final_list = []
    for key,value in list_sorted:
        final_list.append([key,value,''])
    return final_list

def divide_list(list):
    if len(list) == 2:
        return [list[0]],[list[1]]
    else:
        n = 0
        for i in list:
            n+= i[1]
        x = 0
        distance = abs(2*x - n)
        j = 0
        for i in range(len(list)):               #shannon tree structure
            x += list[i][1]
            if distance < abs(2*x - n):
                j = i
    return list[0:j+1], list[j+1:]


def label_list(list):
    list1,list2 = divide_list(list)
    for i in list1:
        i[2] += '0'
        c[i[0]] = i[2]
    for i in list2:
        i[2] += '1'
        c[i[0]] = i[2]
    if len(list1)==1 and len(list2)==1:        #assigning values to the tree
        return
    label_list(list2)
    return c

def decodeShannon(fOut, letter_binary):
    """
        Decode Shannon_Fano.\n
        Args:
            fOut -> File to print decoded text
            letter_binary -> Node, is received from using the encode function
        Returns:
            Creates file with uncompressed data written.
    """
    output = open(fOut,"r")
    intermediate = output.readlines()
    bitstring = ""
    for digit in intermediate:
        bitstring = bitstring + digit
    uncompressed_string =""
    code =""
    for digit in bitstring:
        code = code+digit
        pos=0
        for letter in letter_binary:               # decoding the binary and genrating original data
            if code ==letter[1]:
                uncompressed_string=uncompressed_string+letter_binary[pos] [0]
                code=""
            pos+=1

    with open("decoded.txt", "w") as f:
        f.write(uncompressed_string)

def codeShannon(fIn, fOut):
    """
        Function to encode in Shannon-Fano\n
        Args:
            fIn -> File input, from where the data will be retrieved
            fOut -> File output, to where data encoded will be written
        Returns:
            Tree of the encoding, while creating a file to save it.
    """
    inString = fa.readText(fIn)
    asArrayIn = np.array(list(inString))

    code = label_list(create_list(inString))

    output = open(fOut,"w+")          # generating output binary
    letter_binary = []
    for key, value in code.items():
        letter_binary.append([key,value])
    print("Compressed file generated as ", fOut)

    for a in inString:
        for key, value in code.items():
            if key in a: 
                output.write(value)
    
    np.save("shannon_letter", np.array(letter_binary))
    

    return letter_binary
